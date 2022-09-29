package com.example.megamarket.controllers;

import com.example.megamarket.dto.ErrorDTO;
import com.example.megamarket.dto.ShopUnitImportRequestDTO;
import com.example.megamarket.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/import")
    public ResponseEntity<ErrorDTO> importItems(@RequestBody ShopUnitImportRequestDTO importRequest) {
        itemService.saveItems(importRequest);
        return ResponseEntity.ok(new ErrorDTO());
    }

}
