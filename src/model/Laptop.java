package model;

public class Laptop {
    private int id;
    private String brand;
    private String type;
    private int ram;
    private int storage;
    private Double screenSize;
    private int stock;
    private int price;


    Laptop(int id, String brand, String type, int ram, int storage, Double screenSize, int stock,int price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.stock = stock;
        this.price = price;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public int getRam(){return ram; }
    public int getStorage(){return storage; }
    public Double getScreenSize(){return screenSize; }
    public int getPrice(){return price; }
    public int getStock(){return stock; }

}
