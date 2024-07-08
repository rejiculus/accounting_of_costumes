package com.accounting_of_costumes.entities.Image.model;

import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;

import java.util.Objects;

public class Image {
    private Long id;
    private String source;
    private Item item;

    public  Image(String source) {
        this.source = source;
    }
    public  Image(String source, Item item) {
        this.source = source;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;

        return Objects.equals(getId(), image.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", source='" + source + '\'' +
                '}';
    }
}
