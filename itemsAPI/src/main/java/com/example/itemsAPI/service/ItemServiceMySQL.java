package com.example.itemsAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.itemsAPI.entity.Item;
import com.example.itemsAPI.entity.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService
{
    private final ItemRepository itemRepository;
    private Item item;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save( Item item )
    {
        return itemRepository.save( item );
    }

    @Override
    public boolean delete(int itemId )
    {
        itemRepository.deleteById( itemId );
        return false;
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Item findById( int itemId )
    {
        //TODO implement this method
        Optional<Item> itemToFindOptional = this.itemRepository.findById(itemId);
        if (!itemToFindOptional.isPresent()) {
            return null; //failed
        }
        Item itemToFind = itemToFindOptional.get();
        return itemToFind;
    }
}
