package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Item.DTO.ICreateItemData;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateItemData implements ICreateItemData {
    private String name;
    private int count;
    private String article;
    private LocalDate registrationDate;
    private LocalDate writeOffDate;
    private Long locationId;
    private String itemStateName;
    private Set<Long> imageIds;
    private Set<String> tagNames;

    public CreateItemData(String name, int count, String article, LocalDate registrationDate, LocalDate writeOffDate, Long locationId, String itemStateName, Set<Long> imageIds, Set<String> tagNames) {
        this.name = name;
        this.count = count;
        this.article = article;
        this.registrationDate = registrationDate;
        this.writeOffDate = writeOffDate;
        this.locationId = locationId;
        this.itemStateName = itemStateName;
        this.imageIds = imageIds;
        this.tagNames = tagNames;
    }

    public CreateItemData() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setWriteOffDate(LocalDate writeOffDate) {
        this.writeOffDate = writeOffDate;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setItemStateName(String itemStateName) {
        this.itemStateName = itemStateName;
    }

    public void setImageIds(Set<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public void setTagNames(Set<String> tagNames) {
        this.tagNames = tagNames;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public String article() {
        return article;
    }

    @Override
    public LocalDate registrationDate() {
        return registrationDate;
    }

    @Override
    public LocalDate writeOffDate() {
        return writeOffDate;
    }

    @Override
    public Long locationId() {
        return locationId;
    }

    @Override
    public String itemStateName() {
        return itemStateName;
    }

    @Override
    public Set<Long> imageIds() {
        return imageIds;
    }

    @Override
    public Set<String> tagNames() {
        return tagNames;
    }
}
