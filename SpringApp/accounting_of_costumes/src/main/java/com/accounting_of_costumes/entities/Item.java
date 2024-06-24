package com.accounting_of_costumes.entities;

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
public class Item {

    @Id @GeneratedValue
    private int id;
    
    @Column(name="item_name", nullable=false, length=200)
    private String name;
    
    @Column(name="items_count", nullable=false)
    private int count=1;

    @Column(name="items_article", nullable=true)
    private String article;

    /*-----*/
    @OneToMany(mappedBy = "item")
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "items_state_fk", nullable = false)
    private ItemState state;

    @ManyToMany
    @JoinTable(
            name="item_tag",
            joinColumns=@JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn(name="tag_name")
    )
    private Set<Tag> tags;

    @ManyToMany
    @JoinTable(
        name="item_operation",
        joinColumns=@JoinColumn(name="id"),
        inverseJoinColumns = @JoinColumn(name="id")
    )
    private Set<Operation> operations;

}
