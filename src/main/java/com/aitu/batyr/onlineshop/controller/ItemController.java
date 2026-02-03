package com.aitu.batyr.onlineshop.controller;

import com.aitu.batyr.onlineshop.ResourceNotFoundException;
import com.aitu.batyr.onlineshop.model.Item;
import com.aitu.batyr.onlineshop.repository.ItemRepository;
import com.aitu.batyr.onlineshop.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;
    private final ItemRepository itemRepository;

    public ItemController(ItemService itemService, ItemRepository itemRepository){
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAll(){
        return itemService.getAll();
    }

    @PostMapping
    public Item create(@RequestBody Item item){
        return itemService.create(item);
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id){
        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item is not found with id: " + id));
    }
}
