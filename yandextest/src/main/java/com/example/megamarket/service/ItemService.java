package com.example.megamarket.service;

import com.example.megamarket.domain.Item;
import com.example.megamarket.dto.ItemDTO;
import com.example.megamarket.dto.ShopUnitImportRequestDTO;
import com.example.megamarket.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveItems(ShopUnitImportRequestDTO requestDTO) {
        for (ItemDTO itemDTO : requestDTO.getItems()) {
            itemRepository.save(toItem(itemDTO));
        }
    }

    private Item toItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setParentId(itemDTO.getParentId());
        item.setPrice(itemDTO.getPrice());
        return item;
    }
}
