package service;

import repository.LaptopRepository;

public class AsusImpl implements LaptopInterface {
    LaptopRepository laptopRepository;
    public AsusImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @Override
    public void printAllByBrand() {
        laptopRepository.printByBrand("Asus");
    }
}
