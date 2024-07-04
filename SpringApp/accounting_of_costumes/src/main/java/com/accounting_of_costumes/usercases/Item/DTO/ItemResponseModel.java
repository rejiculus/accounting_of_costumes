package com.accounting_of_costumes.usercases.Item.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@Getter
public class ItemResponseModel {
    private String article;
    private String name;
    private int count;
    private Set<String> imageSources;
    private String state;
    private Set<String> tags;
    // By operations
    private LocalDateTime operationDate;
    private String operationType;
    private String operationPersonFullName;

    // id's
    private Long itemId;
    private Long personId;
    private Long OperationId;
}
