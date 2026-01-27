package com.aitu.batyr.onlineshop.controller;

import com.aitu.batyr.onlineshop.model.Item;
import com.aitu.batyr.onlineshop.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAll(){
        return itemService.getAll();
    }

    @PostMapping
    public Item create(@RequestBody Item item){
        return itemService.create(item);
    }

}
