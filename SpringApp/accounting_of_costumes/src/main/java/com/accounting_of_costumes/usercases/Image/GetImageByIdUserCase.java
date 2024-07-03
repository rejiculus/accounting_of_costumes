package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.exception.ImageNotFoundException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;

import java.util.List;

public class GetImageByIdUserCase {
    private ImageGateway imageGateway;

    public GetImageByIdUserCase(ImageGateway imageGateway) {
        this.imageGateway = imageGateway;
    }

    public Image execute(Long id){
        return this.imageGateway.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(id));
    }
}
