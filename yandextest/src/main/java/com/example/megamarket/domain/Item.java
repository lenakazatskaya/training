package com.example.megamarket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    private UUID id;
    private String name;
    private UUID parentId;
    private Integer price;
    private String type;
}
