package com.aitu.batyr.onlineshop.service;

import com.aitu.batyr.onlineshop.ResourceNotFoundException;
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

    public void delete(Long id){
        if(!itemRepository.existsById(id)){
            throw new ResourceNotFoundException(("Item not found with id: " + id));
        }
        itemRepository.deleteById(id);
    }
}
