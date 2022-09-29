package com.example.megamarket.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ShopUnitImportRequestDTO {
    List<ItemDTO> items;
    LocalDateTime updateDate;
}
