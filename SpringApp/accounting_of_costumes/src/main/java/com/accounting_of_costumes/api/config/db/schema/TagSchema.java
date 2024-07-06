package com.accounting_of_costumes.api.config.db.schema;

import java.util.Set;

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

    public Tag toTag(){
        return new Tag(this.name);
    }

}
