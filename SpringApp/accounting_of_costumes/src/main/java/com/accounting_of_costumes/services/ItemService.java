package com.accounting_of_costumes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounting_of_costumes.models.Item;
import com.accounting_of_costumes.repositories.ItemRepository;

@Service
public class ItemService {

    private ItemRepository itemRepository;


    @Autowired
    public void setItemRepository(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public List<Item> findByName(String name){
        return itemRepository.findByName(name);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }

}
