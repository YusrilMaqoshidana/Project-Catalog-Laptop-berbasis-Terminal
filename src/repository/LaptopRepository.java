package repository;

import database.DatabaseHelper;
import model.Laptop;

import java.util.List;
import java.util.Optional;

public class LaptopRepository {
    private final DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    public void printAllBrand() {
        System.out.println("Laptop yang tersedia: ");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-4s | %-25s | %-10s | %-15s%n",
                "ID", "Merk dan Tipe", "Stok", "Harga");
        System.out.println("----------------------------------------------------------");

        dbHelper.laptopList.forEach(laptop -> {
            System.out.printf("%-4d | %-25s | %-10d | Rp%-13d%n",
                    laptop.getId(),
                    laptop.getBrand() + " " + laptop.getType(),
                    laptop.getStock(),
                    laptop.getPrice());
        });
        System.out.println("----------------------------------------------------------");
    }

    public void printByBrand(String brand) {
        List<Laptop> laptopsByBrand = dbHelper.laptopList.stream()
                .filter(laptop -> laptop.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (laptopsByBrand.isEmpty()) {
            System.out.println("Laptop tidak ditemukan untuk brand: " + brand);
        } else {
            System.out.println("Laptop dari brand " + brand + ":");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%-4s | %-25s | %-10s | %-15s%n",
                    "ID", "Merk dan Tipe", "Stok", "Harga");
            System.out.println("----------------------------------------------------------");

            laptopsByBrand.forEach(laptop -> {
                System.out.printf("%-4d | %-25s | %-10d | Rp%-13d%n",
                        laptop.getId(),
                        laptop.getBrand() + " " + laptop.getType(),
                        laptop.getStock(),
                        laptop.getPrice());
            });
            System.out.println("----------------------------------------------------------");
        }
    }


    public void getDetailById(int laptopId) {
        Optional<Laptop> laptop = dbHelper.laptopList.stream()
                .filter(l -> l.getId() == laptopId)
                .findFirst();

        if (laptop.isPresent()) {
            Laptop l = laptop.get();
            System.out.println("Detail Laptop:");
            System.out.println("ID: " + l.getId());
            System.out.println("Brand: " + l.getBrand());
            System.out.println("Type: " + l.getType());
            System.out.println("RAM: " + l.getRam() + "GB");
            System.out.println("Storage: " + l.getStorage() + "GB");
            System.out.println("Screen Size: " + l.getScreenSize() + " inches");
            System.out.println("Stok: " + l.getStock());
            System.out.println("Harga: Rp" + l.getPrice());
        } else {
            System.out.println("Laptop dengan ID " + laptopId + " tidak ditemukan.");
        }
    }

    public void addNewLaptop(Laptop laptop) {
        dbHelper.laptopList.add(laptop);
        System.out.println("Berhasil menambahkan laptop dengan ID: " + laptop.getId());
    }

    public void removeById(int laptopId) {
        boolean removed = dbHelper.laptopList.removeIf(laptop -> laptop.getId() == laptopId);
        if (removed) {
            System.out.println("Laptop dengan ID " + laptopId + " telah dihapus.");
        } else {
            System.out.println("Laptop dengan ID " + laptopId + " tidak ditemukan.");
        }
    }

    public void updateById(int laptopId, Laptop updatedLaptop) {
        for (int i = 0; i < dbHelper.laptopList.size(); i++) {
            if (dbHelper.laptopList.get(i).getId() == laptopId) {
                dbHelper.laptopList.set(i, updatedLaptop);
                System.out.println("Laptop dengan ID " + laptopId + " telah diupdate.");
                return;
            }
        }
        System.out.println("Laptop dengan ID " + laptopId + " tidak ditemukan.");
    }
}