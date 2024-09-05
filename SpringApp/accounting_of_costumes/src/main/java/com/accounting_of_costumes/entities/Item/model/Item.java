package com.accounting_of_costumes.entities.Item.model;

import com.accounting_of_costumes.entities.Exception.NoValidIdException;
import com.accounting_of_costumes.entities.Exception.NoValidNameException;
import com.accounting_of_costumes.entities.Exception.NullValueParamException;
import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.exception.NoValidArticleException;
import com.accounting_of_costumes.entities.Item.exception.NoValidCountException;
import com.accounting_of_costumes.entities.Item.exception.NoValidDateException;
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

    {
        this.images = new HashSet<>();
        this.tags = new HashSet<>();
    }

    public Item(String name, ItemState itemState) {
        this.name = name;
        this.itemState = itemState;
        this.count = 1;
        this.article = "";
        this.location=null;
    }

    public Item(Long id, String name, int count, String article, Location location, ItemState itemState) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.article = article;
        this.location = location;
        this.itemState = itemState;
    }


    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        if(id == null || id < 0)
            throw new NoValidIdException(id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty())
            throw new NoValidNameException(name);

        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count <= 0)
            throw new NoValidCountException(count);

        this.count = count;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        if(article==null)
            throw new NullValueParamException("article");
        if(article.isEmpty())
            throw new NoValidArticleException(article);
        this.article = article;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        if(location==null)
            throw new NullValueParamException("location");
        this.location=location;
    }

    public ItemState getItemState() {
        return itemState;
    }

    public void setItemState(ItemState itemState) {
        if(itemState == null)
            throw new NullValueParamException("itemState");

        this.itemState = itemState;

    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if(registrationDate == null)
            throw new NullValueParamException("registrationDate");
        this.registrationDate = registrationDate;
    }

    public LocalDate getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(LocalDate writeOffDate) {
        if(writeOffDate == null)
            throw new NullValueParamException("writeOffDate");
        if(registrationDate==null)
            throw new NullValueParamException("registrationDate");
        if(!writeOffDate.isAfter(registrationDate))
            throw new NoValidDateException(registrationDate,writeOffDate);
        this.writeOffDate = writeOffDate;
    }

    //images
    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        if(images == null)
            throw new NullValueParamException("images");
        this.images = images;
    }

    //tags
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        if(tags == null)
            throw new NullValueParamException("tags");
        this.tags = tags;
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
