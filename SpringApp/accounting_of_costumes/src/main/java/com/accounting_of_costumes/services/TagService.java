package com.accounting_of_costumes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.models.Tag;
import com.accounting_of_costumes.repositories.TagRepository;

@Service
public class TagService {

    private TagRepository tagRepository;


    @Autowired
    public void setTagRepository(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }


    public List<Tag> findAll(){
        return tagRepository.findAll();
    }

    public Optional<Tag> findByName(String name){
        return tagRepository.findByName(name);
    }

    public Tag save(Tag tag){
        return tagRepository.save(tag);
    }

    public void delete(Tag tag){
        tagRepository.delete(tag);
    }


}
