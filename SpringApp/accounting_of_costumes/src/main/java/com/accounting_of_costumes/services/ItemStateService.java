package com.accounting_of_costumes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.models.ItemState;
import com.accounting_of_costumes.repositories.ItemStateRepository;

@Service
public class ItemStateService {

    private ItemStateRepository itemStateRepository;

    @Autowired
    public void setItemStateRepository(ItemStateRepository itemStateRepository){
        this.itemStateRepository = itemStateRepository;
    }

    public List<ItemState> findAll(){
        return itemStateRepository.findAll();
    }

    public Optional<ItemState> findByName(String name){
        return itemStateRepository.findByName(name);
    }

    public ItemState save(ItemState itemState){
        return itemStateRepository.save(itemState);
    }

    public void delete(ItemState itemState){
        itemStateRepository.delete(itemState);
    }

}
