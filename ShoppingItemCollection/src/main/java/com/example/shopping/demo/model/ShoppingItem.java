package com.example.shopping.demo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.data.annotation.Id;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class ShoppingItem {

    @Id
    private String id;

    private String content;

    private int count;

    private String state;

    private Date createdAt;




    public ShoppingItem(String content, int count, String state) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.count = count;
        this.state = state;
        this.createdAt = new Date();


    }

    public ShoppingItem(ShoppingItem item)
    {
        if(item.getId() == null) {
            this.id = UUID.randomUUID().toString();

        }else
            {
                this.id = item.getId();
            }

            this.content = item.getContent();
            this.count = item.getCount();
            this.state = item.getState();

        if(item.getCreatedAt() == null)
        {
            this.createdAt = new Date();
        }else {

            this.createdAt = item.getCreatedAt();
        }
    }







   /* public ShoppingItem deSerializeItem(JsonNode item)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        ShoppingItem shoppingItem = null;
        try {
            shoppingItem = objectMapper.readValue(item.textValue(), ShoppingItem.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shoppingItem;
    }*/





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
