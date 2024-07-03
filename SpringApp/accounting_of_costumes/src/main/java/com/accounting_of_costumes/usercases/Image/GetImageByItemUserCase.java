package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Item.DTO.IItemPublicData;

import java.util.List;

public class GetImageByItemUserCase {
    private ImageGateway imageGateway;
    private ItemGateway itemGateway;

    public GetImageByItemUserCase(ImageGateway imageGateway, ItemGateway itemGateway) {
        this.imageGateway = imageGateway;
        this.itemGateway = itemGateway;
    }

    public List<Image> execute(IItemPublicData data){
        Item item = this.itemGateway.findById(data.id())
                .orElseThrow(() -> new ItemNotFoundException(data.id()));

        return this.imageGateway.findByItem(item);

    }
}
