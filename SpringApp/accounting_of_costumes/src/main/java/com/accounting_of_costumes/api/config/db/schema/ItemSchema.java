package com.accounting_of_costumes.api.config.db.schema;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import com.accounting_of_costumes.entities.Item.model.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "item")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"tags", "state", "images"})
public class ItemSchema {

    @Id @GeneratedValue
    private Long id;
    
    @Column(name="item_name", nullable=false, length=200)
    private String name;
    
    @Column(name="items_count", nullable=false)
    private int count=1;

    @Column(name="items_article", nullable=true)
    private String article;

    /*-----*/
    private LocalDate registrationDate;
    private LocalDate writeOffDate;


    /*-----*/
    @ManyToOne
    @JoinColumn(name = "location_fk", nullable = false)
    private LocationSchema location;

    @ManyToOne
    @JoinColumn(name = "items_state_fk", nullable = false)
    private ItemStateSchema state;

    @OneToMany(mappedBy = "item")
    private Set<ImageSchema> images;

    @ManyToMany
    @JoinTable(
            name="item_tag",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="tag_name")
    )
    private Set<TagSchema> tags;

    public ItemSchema(Long id){
        this.id = id;
    }

    public ItemSchema(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.count = item.getCount();
        this.article = item.getArticle();

        this.registrationDate = item.getRegistrationDate();
        this.writeOffDate = item.getWriteOffDate();

        this.location = new LocationSchema(item.getLocation());
        this.state = new ItemStateSchema(item.getItemState());

        this.tags = item.getTags().stream()
                .map(x->new TagSchema(x.getName()))
                .collect(Collectors.toSet());
    }

    public Item toItem(){
        Item item = new Item(this.name,this.state.toItemState());
        item.setCount(this.count);
        item.setArticle(this.article);
        item.setRegistrationDate(this.registrationDate);
        item.setWriteOffDate(this.writeOffDate);
        item.setLocation(this.location.toLocation());
        item.addAllImages(this.images.stream()
                .map(ImageSchema::toImage)
                .collect(Collectors.toSet()));
        item.addAllTags(this.tags.stream()
                .map(TagSchema::toTag)
                .collect(Collectors.toSet()));

        return item;
    }
}
