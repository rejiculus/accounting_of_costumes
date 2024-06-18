package com.accounting_of_costumes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accounting_of_costumes.models.Tag;
import com.accounting_of_costumes.services.TagService;

@RestController
@RequestMapping("/test")
public class TestTegController {
    
    private TagService tagService;



    @Autowired
    public void setTagService(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> findAll(){
        return tagService.findAll();
    }
}
