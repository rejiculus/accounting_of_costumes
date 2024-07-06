package com.accounting_of_costumes.entities.ItemState.model;

import com.accounting_of_costumes.entities.Item.model.Item;

public class ItemState {
    private String name;

    public ItemState(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
