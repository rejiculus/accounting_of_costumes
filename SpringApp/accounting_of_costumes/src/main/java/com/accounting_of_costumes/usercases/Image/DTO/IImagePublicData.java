package com.accounting_of_costumes.usercases.Image.DTO;

import com.accounting_of_costumes.usercases.Item.DTO.IItemPublicData;

public interface IImagePublicData {
    Long id();
    String source();
    IItemPublicData item();
}
