package com.accounting_of_costumes.entities.ItemState.model;

import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.Set;

public class ItemState {
    private String name;
    private Set<Item> items;

    public ItemState(String name) {
        this.name = name;
    }

    public ItemState(String name, Set<Item> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void deleteItem(Item item){
        this.items.remove(item);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemState itemState)) return false;

        return getName().equals(itemState.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "ItemState{" +
                "name='" + name + '\'' +
                '}';
    }
}
