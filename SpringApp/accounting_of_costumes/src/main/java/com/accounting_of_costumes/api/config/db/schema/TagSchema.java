package com.accounting_of_costumes.api.config.db.schema;

import java.util.Set;
import java.util.stream.Collectors;

import com.accounting_of_costumes.entities.Tag.model.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tag")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "items")
public class TagSchema {
    @Id
    @Column(name="tag_name",nullable=false,length=100)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<ItemSchema> items;

    public TagSchema(String name){
        this.name = name;
    }

    public TagSchema(Tag tag){
        this.name = tag.getName();
        this.items = tag.getItems().stream()
                .map(item -> new ItemSchema(item.getId()))
                .collect(Collectors.toSet());
    }

    public Tag toTag(){
        return new Tag(this.name);
    }

}
