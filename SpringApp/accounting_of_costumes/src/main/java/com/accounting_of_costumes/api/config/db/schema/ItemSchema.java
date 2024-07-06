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



    public Item toItem(){
        Item item = new Item(this.name,this.state.toItemState());
        item.setCount(this.count);
        item.setArticle(this.article);
        item.setRegistrationDate(this.registrationDate);
        item.setWriteOffDate(this.writeOffDate);
        item.setLocation(this.location.toLocation());
        item.setImages(this.images.stream()
                .map(ImageSchema::toImage)
                .collect(Collectors.toSet()));
        item.setTags(this.tags.stream()
                .map(TagSchema::toTag)
                .collect(Collectors.toSet()));

        return item;
    }
}
