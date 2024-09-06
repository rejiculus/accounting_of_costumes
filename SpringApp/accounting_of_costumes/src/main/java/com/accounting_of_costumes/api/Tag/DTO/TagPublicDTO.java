package com.accounting_of_costumes.api.Tag.DTO;

import com.accounting_of_costumes.entities.Tag.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagPublicDTO {
    private String name;
    private String path;
    private Set<TagsItemPublicDTO> items;


    public TagPublicDTO(Tag tag){
        this.name = tag.getName();
        this.path = String.format("/tags/%s", tag.getName());
        this.items = tag.getItems().stream()
                .map(TagsItemPublicDTO::new)
                .collect(Collectors.toSet());
    }

}
