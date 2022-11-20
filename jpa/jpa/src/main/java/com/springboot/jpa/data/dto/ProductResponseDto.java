package com.springboot.jpa.data.dto;

public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto(){}

    public ProductResponseDto(Long number, String name, int price, int stock){
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getNumber(){
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
