package com.accounting_of_costumes.api.ItemState.DTO;

import com.accounting_of_costumes.usercases.ItemState.DTO.ICreateItemStateData;

public record CreateItemStateData(String name) implements ICreateItemStateData {
}
