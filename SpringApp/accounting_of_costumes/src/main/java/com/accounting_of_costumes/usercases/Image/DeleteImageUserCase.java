package com.accounting_of_costumes.usercases.Image;

import com.accounting_of_costumes.entities.Image.exception.ImageNotFoundException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;

import java.util.List;

public class DeleteImageUserCase {
    private ImageGateway imageGateway;

    public DeleteImageUserCase(ImageGateway imageGateway) {
        this.imageGateway = imageGateway;
    }

    public void execute(Long id){
        Image image = this.imageGateway.findById(id)
                .orElseThrow(() -> new ImageNotFoundException(id));

        this.imageGateway.delete(image);
    }
}
