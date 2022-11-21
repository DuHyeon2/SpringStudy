package com.springboot.advanced_jpa.data.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
