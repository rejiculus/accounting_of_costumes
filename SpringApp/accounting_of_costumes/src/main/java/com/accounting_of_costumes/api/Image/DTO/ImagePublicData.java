package com.accounting_of_costumes.api.Image.DTO;

import com.accounting_of_costumes.api.Item.DTO.ItemPublicData;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.usercases.Image.DTO.IImagePublicData;
import com.accounting_of_costumes.usercases.Item.DTO.IItemPublicData;

public record ImagePublicData(Long id, String source, IItemPublicData item) implements IImagePublicData {
    ImagePublicData(Image image){
        this(
                image.getId(),
                image.getSource(),
                new ItemPublicData(image.getItem())
        );
    }
}
