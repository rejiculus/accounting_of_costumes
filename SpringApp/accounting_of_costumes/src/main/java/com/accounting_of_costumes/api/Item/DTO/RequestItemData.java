package com.accounting_of_costumes.api.Item.DTO;

import com.accounting_of_costumes.usercases.ItemState.DTO.IItemStatePublicData;
import com.accounting_of_costumes.usercases.Location.DTO.ILocationPublicData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestItemData {
    private String name;
    private int count;
    private String article;
    private LocalDate registrationDate;
    private LocalDate writeOffDate;
    private Long locationId;
    private String itemStateName;

}
