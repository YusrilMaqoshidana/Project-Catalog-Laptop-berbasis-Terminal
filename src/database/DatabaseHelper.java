package database;

import model.Laptop;
import model.Builder;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static DatabaseHelper instance;
    public List<Laptop> laptopList;

    private DatabaseHelper() {
        laptopList = new ArrayList<>();
        initializeDummyData();
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

    private void initializeDummyData() {
        // Asus laptops
        addLaptop("Asus", "ROG Zephyrus", 32, 1000, 15.6, 10, 10_000_000);
        addLaptop("Asus", "ZenBook", 16, 512, 13.3, 15, 12_999_000);
        addLaptop("Asus", "TUF Gaming", 16, 512, 15.6, 8, 18_999_000);
        addLaptop("Asus", "VivoBook", 8, 256, 14.0, 20, 5_999_000);
        addLaptop("Asus", "ProArt StudioBook", 64, 2000, 17.0, 5, 29_999_000);

        // Lenovo laptops
        addLaptop("Lenovo", "ThinkPad X1 Carbon", 16, 512, 14.0, 12, 23_985_000);
        addLaptop("Lenovo", "Yoga C940", 12, 256, 13.9, 18, 17_985_000);
        addLaptop("Lenovo", "Legion 5", 32, 1000, 15.6, 7, 20_985_000);
        addLaptop("Lenovo", "IdeaPad 5", 8, 256, 15.6, 25, 9_735_000);
        addLaptop("Lenovo", "ThinkBook 14s", 16, 512, 14.0, 15, 13_485_000);

// Macbook laptops
        addLaptop("Macbook", "Air M1", 8, 256, 13.3, 30, 14_985_000);
        addLaptop("Macbook", "Pro 13\"", 16, 512, 13.3, 20, 19_485_000);
        addLaptop("Macbook", "Pro 14\"", 32, 1000, 14.2, 10, 29_985_000);
        addLaptop("Macbook", "Pro 16\"", 64, 2000, 16.2, 8, 37_485_000);
        addLaptop("Macbook", "Air M2", 16, 512, 13.6, 25, 17_985_000);
    }

    private void addLaptop(String brand, String type, int ram, int storage, double screenSize, int stock, int price) {
        Laptop laptop = new Builder()
                .setId(laptopList.size() + 1)
                .setBrand(brand)
                .setType(type)
                .setRam(ram)
                .setStorage(storage)
                .setScreenSize(screenSize)
                .setStock(stock)
                .setPrice(price)
                .build();
        laptopList.add(laptop);
    }
}