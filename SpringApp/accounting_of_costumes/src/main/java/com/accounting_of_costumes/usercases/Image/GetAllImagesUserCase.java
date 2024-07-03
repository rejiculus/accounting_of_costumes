package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;

import java.util.List;

public class GetAllImagesUserCase {
    private ImageGateway imageGateway;

    public GetAllImagesUserCase(ImageGateway imageGateway) {
        this.imageGateway = imageGateway;
    }

    public List<Image> execute(){
        return this.imageGateway.findAll();
    }
}
