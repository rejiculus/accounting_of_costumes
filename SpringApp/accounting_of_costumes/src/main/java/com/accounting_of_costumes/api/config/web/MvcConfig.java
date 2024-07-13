package com.accounting_of_costumes.api.config.web;

import com.accounting_of_costumes.api.Tag.Gateway.TagDatabaseGateway;
import com.accounting_of_costumes.api.config.db.repository.TagRepository;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.usercases.Tag.CreateTagUserCase;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public GetAllTagsUserCase getAllTagsUserCase(TagRepository tagRepository){
        TagGateway TagGateway = new TagDatabaseGateway(tagRepository);
        return new GetAllTagsUserCase(TagGateway);
    }

    @Bean
    public CreateTagUserCase createTagUserCase(TagRepository tagRepository){
        TagGateway TagGateway = new TagDatabaseGateway(tagRepository);
        return new CreateTagUserCase(TagGateway);
    }
}
