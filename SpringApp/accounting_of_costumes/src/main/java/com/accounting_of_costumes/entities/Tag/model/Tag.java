package com.accounting_of_costumes.entities.Tag.model;


import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/** Tag
 *
 *
 */

public class Tag {
    private String name;

    public Tag(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    //todo check set value
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag tag)) return false;

        return getName().equals(tag.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}
