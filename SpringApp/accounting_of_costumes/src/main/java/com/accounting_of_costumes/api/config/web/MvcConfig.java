package com.accounting_of_costumes.api.config.web;

import com.accounting_of_costumes.api.Place.Gateway.PlaceDatabaseGateway;
import com.accounting_of_costumes.api.Tag.Gateway.TagDatabaseGateway;
import com.accounting_of_costumes.api.config.db.repository.PlaceRepository;
import com.accounting_of_costumes.api.config.db.repository.TagRepository;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.usercases.Place.GetAllPlacesUserCase;
import com.accounting_of_costumes.usercases.Tag.CreateTagUserCase;
import com.accounting_of_costumes.usercases.Tag.DeleteTagUserCase;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import com.accounting_of_costumes.usercases.Tag.GetTagUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    /*      Tags        */
    @Bean
    public GetAllTagsUserCase getAllTagsUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new GetAllTagsUserCase(tagGateway);
    }

    @Bean
    public CreateTagUserCase createTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new CreateTagUserCase(tagGateway);
    }
    @Bean
    public GetTagUserCase getTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new GetTagUserCase(tagGateway);
    }
    @Bean
    public DeleteTagUserCase deleteTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new DeleteTagUserCase(tagGateway);
    }

    /*      Places      */
    @Bean
    public GetAllPlacesUserCase getAllPlacesUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new GetAllPlacesUserCase(placeGateway);
    }
}
