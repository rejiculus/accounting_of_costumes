package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Exception.ParamValueException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.exception.ItemNotFoundException;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.usercases.Image.DTO.ICreateImageData;

public class CreateImageUserCase {
    private ImageGateway imageGateway;
    private ItemGateway itemGateway;

    public CreateImageUserCase(ImageGateway imageGateway, ItemGateway itemGateway) {
        this.imageGateway = imageGateway;
        this.itemGateway = itemGateway;
    }

    public Image execute(ICreateImageData data){
        if(data.source()==null || data.source().isBlank() || data.item()==null)
            throw new ParamValueException("Create param cant be null!");

        Item item = this.itemGateway.findById(data.item().id())
                .orElseThrow(() -> new ItemNotFoundException(data.item().id()));

        Image image = new Image(data.source());

        return this.imageGateway.create(image);

    }
}
