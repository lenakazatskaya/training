package com.example.megamarket.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ItemDTO {
    private UUID id;
    private String name;
    private UUID parentId;
    private Integer price;
    private String type;
}
