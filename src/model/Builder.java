package model;

public class Builder {
    private int id;
    private String brand;
    private String type;
    private int ram;
    private int storage;
    private Double screenSize;
    private int stock;
    private int price;

    public Builder setId(int id) {
        this.id = id;
        return this;
    }

    public Builder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Builder setType(String type) {
        this.type = type;
        return this;
    }

    public Builder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public Builder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public Builder setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public Builder setPrice(int price) {
        this.price = price;
        return this;
    }

    public Builder setStock(int stock) {
        this.stock = stock;
        return this;
    }


    public Laptop build() {
        return new Laptop(id,
                brand,
                type,
                ram,
                storage,
                screenSize,
                stock,
                price);
    }
}
