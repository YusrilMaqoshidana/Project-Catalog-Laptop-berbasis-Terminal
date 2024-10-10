package service;

import repository.LaptopRepository;

public class MacbookImpl implements LaptopInterface{
    LaptopRepository laptopRepository;
    public MacbookImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @Override
    public void printAllByBrand() {
        laptopRepository.printByBrand("Macbook");
    }
}
