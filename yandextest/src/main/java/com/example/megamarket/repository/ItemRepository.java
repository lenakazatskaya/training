package com.example.megamarket.repository;

import com.example.megamarket.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, String> {
}
