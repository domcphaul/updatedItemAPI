package com.example.itemsAPI.service;

import com.example.itemsAPI.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService
{

    Item save(Item item );

    boolean delete( int itemId );

    List<Item> all();

    Item findById( int itemId );

}
