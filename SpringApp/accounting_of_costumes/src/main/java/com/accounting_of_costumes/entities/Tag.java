package com.accounting_of_costumes.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "items")
public class Tag {
    @Id
    @Column(name="tag_name",nullable=false,length=100)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Item> items;

}
