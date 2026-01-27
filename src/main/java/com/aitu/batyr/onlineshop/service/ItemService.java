package com.aitu.batyr.onlineshop.service;

import com.aitu.batyr.onlineshop.model.Item;
import com.aitu.batyr.onlineshop.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    public Item create(Item item){
        return itemRepository.save(item);
    }
}
