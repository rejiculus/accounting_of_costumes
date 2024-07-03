package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.exception.ImageNotFoundException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;

import java.util.List;

public class GetImageBySourceUserCase {
    private ImageGateway imageGateway;

    public GetImageBySourceUserCase(ImageGateway imageGateway) {
        this.imageGateway = imageGateway;
    }

    public Image execute(String source){
        return this.imageGateway.findBySource(source)
                .orElseThrow(() -> new ImageNotFoundException(source));
    }
}
