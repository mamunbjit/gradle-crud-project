package com.mamun.main.model;

public class Motorbike {
    private Long id;
    private String bikeName;
    private String brand;
    private String color;

    public Motorbike() {

    }

    public Motorbike(Long id, String bikeName, String brand, String color) {
        this.id = id;
        this.bikeName = bikeName;
        this.brand = brand;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "id=" + id +
                ", bikeName='" + bikeName + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
