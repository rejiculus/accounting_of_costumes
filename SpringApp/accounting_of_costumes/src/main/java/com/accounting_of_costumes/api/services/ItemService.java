package com.accounting_of_costumes.api.services;

import java.util.List;

import com.accounting_of_costumes.usercases.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.entities.Item;
import com.accounting_of_costumes.api.repositories.ItemJpaRepository;

@Service
public class ItemService implements ItemRepository {

    private ItemJpaRepository itemJpaRepository;


    @Autowired
    public void setItemRepository(ItemJpaRepository itemJpaRepository){
        this.itemJpaRepository = itemJpaRepository;
    }

    public List<Item> findAll(){
        return itemJpaRepository.findAll();
    }

    public List<Item> findByName(String name){
        return itemJpaRepository.findByName(name);
    }

    public Item save(Item item){
        return itemJpaRepository.save(item);
    }

    public void delete(Item item){
        itemJpaRepository.delete(item);
    }

}

