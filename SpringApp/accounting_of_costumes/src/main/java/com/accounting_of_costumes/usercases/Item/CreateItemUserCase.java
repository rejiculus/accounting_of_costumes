package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Image.exception.ImageNotFoundException;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Image.model.Image;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;
import com.accounting_of_costumes.entities.ItemState.exception.ItemStateNotFoundException;
import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.ItemState.model.ItemState;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Tag.exception.TagNotFoundException;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;
import com.accounting_of_costumes.usercases.Item.DTO.ICreateItemData;

import java.util.Set;
import java.util.stream.Collectors;

public class CreateItemUserCase {
    private ItemGateway itemGateway;
    private LocationGateway locationGateway;
    private ItemStateGateway itemStateGateway;
    private ImageGateway imageGateway;
    private TagGateway tagGateway;

    public CreateItemUserCase(ItemGateway itemGateway,
                              LocationGateway locationGateway,
                              ItemStateGateway itemStateGateway,
                              ImageGateway imageGateway,
                              TagGateway tagGateway) {
        this.itemGateway = itemGateway;
        this.locationGateway = locationGateway;
        this.itemStateGateway = itemStateGateway;
        this.imageGateway = imageGateway;
        this.tagGateway = tagGateway;
    }

    public Item execute(ICreateItemData data){
        ItemState state = this.itemStateGateway.findByName(data.itemStateName())
                .orElseThrow(() -> new ItemStateNotFoundException(data.itemStateName()));
        Location location = this.locationGateway
                                    .findById(data.locationId())
                                    .orElse(null);

        Set<Image> images = data.imageIds().stream()
                .map(x -> this.imageGateway
                        .findById(x)
                        .orElseThrow(() -> new ImageNotFoundException(x)))
                .collect(Collectors.toSet());

        Set<Tag> tags = data.tagNames().stream()
                .map(x -> this.tagGateway
                        .findByName(x)
                        .orElseThrow(() -> new TagNotFoundException(x)))
                .collect(Collectors.toSet());

        Item item = new Item(data.name(), state);
        item.setCount(data.count());
        item.setArticle(data.article());
        item.setRegistrationDate(data.registrationDate());
        item.setWriteOffDate(data.writeOffDate());
        item.setLocation(location);
        item.addAllImages(images);
        item.addAllTags(tags);

        return this.itemGateway.create(item);
    }
}
