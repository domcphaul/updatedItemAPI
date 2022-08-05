package com.example.itemsAPI.controller;

import com.example.itemsAPI.controller.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.itemsAPI.entity.Item;
import com.example.itemsAPI.entity.ItemRepository;
import com.example.itemsAPI.service.ItemService;

@RestController
@RequestMapping
public class ItemController{

    final ItemService itemService;

    final ItemRepository itemRepository;


    public ItemController(ItemService itemService, @Autowired ItemRepository itemRepository )
    {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @CrossOrigin
    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.save( new Item( itemDto ) );
    }

    @GetMapping("/{id}")
    public Item findItemById( @PathVariable Integer id ){
        return itemService.findById( 1 );
    }

    @PutMapping( "/{id}" )
    public Item update(@RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Item item = itemService.findById( id );
        item.setName( item.getName() );
        item.setDescription( item.getDescription() );
        item.setImageUrl( item.getImageUrl() );
        return itemService.save( item );
    }

    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}
