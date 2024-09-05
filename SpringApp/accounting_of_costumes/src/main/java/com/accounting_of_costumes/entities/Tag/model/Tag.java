package com.accounting_of_costumes.entities.Tag.model;


import com.accounting_of_costumes.entities.Exception.NullValueParamException;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Exception.NoValidNameException;

import java.util.HashSet;
import java.util.Set;

/** Tag
 *
 *
 */

public class Tag {
    private String name;
    private Set<Item> items;

    public Tag(String name){
        this.name = name;
        this.items = new HashSet<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name==null || name.isEmpty())
            throw new NoValidNameException(name);
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        if(items == null)
            throw new NullValueParamException("items");
        this.items = items;
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
