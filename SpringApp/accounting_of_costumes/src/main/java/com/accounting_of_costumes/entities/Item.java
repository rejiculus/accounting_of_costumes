package com.accounting_of_costumes.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {

    @Id @GeneratedValue
    private int id;
    
    @Column(name="item_name", nullable=false, length=200)
    private String name;
    
    @Column(name="items_count", nullable=false)
    private int count=1;

    @Column(name="items_article", nullable=true)
    private String article;

    //todo 
    @ManyToMany
    @JoinTable(
        name="item_tag",
        joinColumns=@JoinColumn(name="id"),
        inverseJoinColumns = @JoinColumn(name="tag_name")
    )
    private Set<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "items_state_fk", nullable = false)
    private ItemState state;

    @ManyToMany
    @JoinTable(
        name="item_operation",
        joinColumns=@JoinColumn(name="id"),
        inverseJoinColumns = @JoinColumn(name="id")
    )
    private Set<Operation> operations;

}
