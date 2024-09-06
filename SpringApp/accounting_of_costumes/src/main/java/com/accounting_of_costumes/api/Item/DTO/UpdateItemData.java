package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.usercases.Item.DTO.IUpdateItemData;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UpdateItemData implements IUpdateItemData {
    private Long id;
    private String name;
    private int count;
    private String article;
    private LocalDate registrationDate;
    private LocalDate writeOffDate;
    private Long locationId;
    private String itemStateName;
    private Set<Long> imageIds;
    private Set<String> tagNames;

    public UpdateItemData(Long id,
                          String name,
                          int count,
                          String article,
                          LocalDate registrationDate,
                          LocalDate writeOffDate,
                          Long locationId,
                          String itemStateName,
                          Set<Long> imageIds,
                          Set<String> tagNames) {

    }
    public UpdateItemData() {
        imageIds=new HashSet<>();
        tagNames =new HashSet<>();
    }

    public void setId(Long id) {
        this.id = id;
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
    public Long id() {
        return this.id;
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
