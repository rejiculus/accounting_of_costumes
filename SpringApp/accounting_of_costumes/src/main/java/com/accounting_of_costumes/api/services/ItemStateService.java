package com.accounting_of_costumes.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.entities.ItemState;
import com.accounting_of_costumes.api.repositories.ItemStateJpaRepository;

@Service
public class ItemStateService {

    private ItemStateJpaRepository itemStateJpaRepository;

    @Autowired
    public void setItemStateRepository(ItemStateJpaRepository itemStateJpaRepository){
        this.itemStateJpaRepository = itemStateJpaRepository;
    }

    public List<ItemState> findAll(){
        return itemStateJpaRepository.findAll();
    }

    public Optional<ItemState> findByName(String name){
        return itemStateJpaRepository.findByName(name);
    }

    public ItemState save(ItemState itemState){
        return itemStateJpaRepository.save(itemState);
    }

    public void delete(ItemState itemState){
        itemStateJpaRepository.delete(itemState);
    }

}
