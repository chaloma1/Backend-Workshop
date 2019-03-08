package com.example.shopping.demo.controller;

import com.example.shopping.demo.model.ShoppingItem;
import com.example.shopping.demo.service.ShoppingItemService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ShoppingItemController {
    @Autowired
    private ShoppingItemService shoppingItemService;


    @GetMapping("/shoppingList")
    public ResponseEntity<List<ShoppingItem>> shoppingList()
    {
        return new ResponseEntity<List<ShoppingItem>>(shoppingItemService.getAllItems(),HttpStatus.OK);
    }

    /*@PostMapping("/shoppingItem")
    public ResponseEntity<ShoppingItem> createItem(@RequestBody ShoppingItem item)
    {
        ShoppingItem shoppingItem = shoppingItemService.addItem(item);
        return new ResponseEntity<ShoppingItem>(item, HttpStatus.OK);
    }*/

    @PostMapping("/shoppingItem")
    public ResponseEntity<ShoppingItem> createItem(@RequestBody ShoppingItem json)
    {

       /* ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem = shoppingItem.deSerializeItem(json);

        */

        //shoppingItemService.addItem(new ShoppingItem(json.getContent(),json.getCount(),json.getState()));
        shoppingItemService.addItem(json);


        return new ResponseEntity<ShoppingItem>(json, HttpStatus.CREATED);
    }

    @PutMapping("/shoppingItem")
    public ResponseEntity<ShoppingItem> updateItem(@RequestBody ShoppingItem json)
    {
        ShoppingItem item = shoppingItemService.getItemById(json.getId());
        item.setContent(json.getContent());
        item.setCount(json.getCount());
        item.setState("Complete");
        item.setCreatedAt(new Date());
        //shoppingItemService.removeItem(json.getId());
        return new ResponseEntity<ShoppingItem>(json,HttpStatus.CREATED);


    }

    @DeleteMapping("/shoppingItem")
    public ResponseEntity<ShoppingItem> deleteItem(@RequestBody ShoppingItem json)
    {
        ShoppingItem item = shoppingItemService.getItemById(json.getId());
        shoppingItemService.removeItem(json.getId());

        return new ResponseEntity<ShoppingItem>(item, HttpStatus.CREATED);
    }




}
