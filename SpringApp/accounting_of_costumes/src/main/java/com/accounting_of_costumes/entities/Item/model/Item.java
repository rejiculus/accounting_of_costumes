package com.accounting_of_costumes.entities.Item.model;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

//todo set's check


public class Item {
    private Long id;
    private String name;
    private int count;
    private String article;

    private LocalDate registrationDate;   // дата постановки на учет
    private LocalDate writeOffDate; // дата списания

    private Location location;      // место где находится вешь
    private ItemState itemState; // not null

    private Set<Image> images;
    private Set<Tag> tags;

    public Item(String name, ItemState itemState) {
        this.name = name;
        this.itemState = itemState;
        this.count = 1;
        this.article = "";
        this.location=null;
        this.images = new HashSet<>();
        this.tags = new HashSet<>();
    }

    public Item(Long id, String name, int count, String article, Location location, ItemState itemState, Set<Image> images, Set<Tag> tags) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.article = article;
        this.location = location;
        this.itemState = itemState;
        this.images = images;
        this.tags = tags;
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        if(id == null)
            throw new NullPointerException("Id cant be null!");
        if(id < 0)
            throw new ParamValueException("Id cant be less than zero!");

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(id == null)
            throw new NullPointerException("Name cant be null!");

        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(id <= 0)
            throw new ParamValueException("Count cant be less or equals zero!");

        this.count = count;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(LocalDate writeOffDate) {
        this.writeOffDate = writeOffDate;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ItemState getItemState() {
        return itemState;
    }

    public void setItemState(ItemState itemState) {
        this.itemState = itemState;
    }

    //images
    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public void addImage(Image image){
        this.images.add(image);
    }

    public void deleteImage(Image image){
        this.images.remove(image);
    }

    //tags
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public void deleteTag(Tag tag){
        this.tags.remove(tag);
    }



    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;

        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", article='" + article + '\'' +
                ", incomeDate=" + registrationDate +
                ", writeOffDate=" + writeOffDate +
                ", location=" + location +
                ", itemState=" + itemState +
                '}';
    }
}
