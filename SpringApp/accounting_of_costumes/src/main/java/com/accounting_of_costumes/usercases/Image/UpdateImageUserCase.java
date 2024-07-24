package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.exception.ImageNotFoundException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Image.DTO.IUpdateImageData;
import com.accounting_of_costumes.usercases.Item.DTO.IItemPublicData;

import java.util.List;

public class UpdateImageUserCase {
    private ImageGateway imageGateway;
    private ItemGateway itemGateway;

    public UpdateImageUserCase(ImageGateway imageGateway, ItemGateway itemGateway) {
        this.imageGateway = imageGateway;
        this.itemGateway = itemGateway;
    }

    public Image execute(IUpdateImageData data){
        Image image = this.imageGateway.findById(data.id())
                .orElseThrow(() -> new ImageNotFoundException(data.id()));

        Item item = this.itemGateway.findById(data.itemId())
                .orElseThrow(()-> new ItemNotFoundException(data.itemId()));

        image.setItem(item);
        image.setSource(data.source());
        return this.imageGateway.update(image);

    }
}
