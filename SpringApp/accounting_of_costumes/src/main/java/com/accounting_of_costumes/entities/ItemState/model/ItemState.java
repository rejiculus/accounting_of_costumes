package com.accounting_of_costumes.entities.ItemState.model;

import com.accounting_of_costumes.entities.Exception.NoValidNameException;
import com.accounting_of_costumes.entities.Exception.NullValueParamException;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.HashSet;
import java.util.Set;

public class ItemState {
    private String name;
    private Set<Item> items;

    public ItemState(String name) {
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
        if(items==null)
            throw new NullValueParamException("items");
        this.items = items;
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
