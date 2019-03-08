package com.example.shopping.demo.service;

import com.example.shopping.demo.model.ShoppingItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingItemService {
    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(ShoppingItem item)
    {
        items.add(item);

    }
    public void removeItem(String id)
    {
        ShoppingItem item = getItemById(id);
        items.remove(item);
    }







    public List<ShoppingItem> getAllItems()
    {

        //items.add(new ShoppingItem("Rohlik",10, "new"));
        return items;
    }


    public ShoppingItem getItemById(String id)
    {
        ShoppingItem item = null;
        for (ShoppingItem i:items
             ) {
            if(i.getId().equals(id))
            {
                item = i;
            }

        }
        return item;
    }
}
