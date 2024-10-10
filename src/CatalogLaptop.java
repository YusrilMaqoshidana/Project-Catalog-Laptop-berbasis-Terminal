import facade.LaptopMaker;
import model.Builder;
import model.Laptop;

import java.util.Scanner;

public class CatalogLaptop {
    public static void main(String[] args) {
        LaptopMaker laptopMaker = new LaptopMaker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Sistem Katalog Penjualan Laptop by Toko Bintang Shop =====");
            laptopMaker.printAll();
            System.out.println("1. Produk Laptop Asus");
            System.out.println("2. Produk Laptop Lenovo");
            System.out.println("3. Produk Laptop Macbook");
            System.out.println("4. Lihat detail produk");
            System.out.println("5. Tambahkan produk laptop");
            System.out.println("6. Update produk laptop");
            System.out.println("7. Hapus produk laptop");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    laptopMaker.printAsus();
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 2:
                    laptopMaker.printLenovo();
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 3:
                    laptopMaker.printMacbook();
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Masukan ID laptop: ");
                    int id = scanner.nextInt();
                    laptopMaker.getDetailLaptop(id);
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 5:
                    Laptop newLaptop = inputLaptopDetails(scanner);
                    laptopMaker.addNewLaptop(newLaptop);
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Masukan ID laptop untuk update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    Laptop updatedLaptop = inputLaptopDetails(scanner);
                    laptopMaker.updateLaptop(updateId, updatedLaptop);
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Masukan ID laptop untuk hapus: ");
                    int removeId = scanner.nextInt();
                    laptopMaker.removeLaptop(removeId);
                    System.out.println("Enter untuk kembali");
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Proses keluar...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid. Tolong coba lagi.");
            }
        }
    }

    private static Laptop inputLaptopDetails(Scanner scanner) {
        Builder builder = new Builder();

        System.out.print("Masukan ID: ");
        builder.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Masukan brand (Asus/Lenovo/Macbook): ");
        builder.setBrand(scanner.nextLine());

        System.out.print("Masukan type: ");
        builder.setType(scanner.nextLine());

        System.out.print("Masukan RAM (GB): ");
        builder.setRam(scanner.nextInt());

        System.out.print("Masukan storage (GB): ");
        builder.setStorage(scanner.nextInt());

        System.out.print("Masukan screen size (inches): ");
        builder.setScreenSize(scanner.nextDouble());

        System.out.print("Masukan stock: ");
        builder.setStock(scanner.nextInt());

        System.out.print("Masukan harga (Rp): ");
        builder.setPrice(scanner.nextInt());

        scanner.nextLine();

        return builder.build();
    }
}