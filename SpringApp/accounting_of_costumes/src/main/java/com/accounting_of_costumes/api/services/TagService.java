package com.accounting_of_costumes.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.entities.Tag;
import com.accounting_of_costumes.api.repositories.TagJpaRepository;

@Service
public class TagService {

    private TagJpaRepository tagJpaRepository;


    @Autowired
    public void setTagRepository(TagJpaRepository tagJpaRepository){
        this.tagJpaRepository = tagJpaRepository;
    }


    public List<Tag> findAll(){
        return tagJpaRepository.findAll();
    }

    public Optional<Tag> findByName(String name){
        return tagJpaRepository.findByName(name);
    }

    public Tag save(Tag tag){
        return tagJpaRepository.save(tag);
    }

    public void delete(Tag tag){
        tagJpaRepository.delete(tag);
    }


}
