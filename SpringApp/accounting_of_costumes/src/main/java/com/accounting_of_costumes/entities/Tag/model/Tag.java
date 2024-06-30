package com.accounting_of_costumes.entities.Tag.model;


import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    public Tag(String name, Set<Item> items){
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }
    //todo check set value
    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }
    //todo check set value
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public void deleteItem(Item item){
        this.items.remove(item);
    }

    private Set<Long> getItemIds(){
        return this.items.stream()
                .map(Item::getId)
                .collect(Collectors.toSet());
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
