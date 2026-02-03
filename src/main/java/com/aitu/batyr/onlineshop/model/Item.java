package com.aitu.batyr.onlineshop.model;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @Column(nullable = false)
    private String name;
    private double price;
    private Integer quantity;

    //constructors

    public Item(){
    }

    public Item(String name, double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getters and setters


    public Long getId() {
        return item_id;
    }

    public void setId(Long id) {
        this.item_id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(getPrice(), item.getPrice()) == 0 && Objects.equals(getId(),item.getId()) && Objects.equals(getName(), item.getName()) && Objects.equals(getQuantity(), item.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getQuantity());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + item_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
