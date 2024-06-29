package com.accounting_of_costumes.api.config.db.schema;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"tags", "operations","state","images"})
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
    @OneToMany(mappedBy = "item")
    private Set<ImageSchema> images;

    @ManyToOne
    @JoinColumn(name = "items_state_fk", nullable = false)
    private ItemStateSchema state;

    @ManyToMany
    @JoinTable(
            name="item_tag",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="tag_name")
    )
    private Set<TagSchema> tags;

    @ManyToMany
    @JoinTable(
        name="item_operation",
        joinColumns=@JoinColumn(name="id"),
        inverseJoinColumns = @JoinColumn(name="id")
    )
    private Set<OperationSchema> operations;

}
