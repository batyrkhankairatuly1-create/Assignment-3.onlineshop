package com.aitu.batyr.onlineshop.repository;

import com.aitu.batyr.onlineshop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
        
}
