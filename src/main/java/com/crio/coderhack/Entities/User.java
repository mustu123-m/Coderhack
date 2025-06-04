package com.crio.coderhack.Entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document
public class User {
    @Id
    private String userId;
    private String username;
    private int score;
    List<Badges>badges;
    public User(String userId,String username)
    {
        this.userId=userId;
        this.username=username;
        badges=new ArrayList<>();
        score=0;    
    }
}

