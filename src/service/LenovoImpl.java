package service;

import repository.LaptopRepository;

public class LenovoImpl implements LaptopInterface{
    LaptopRepository laptopRepository;
    public LenovoImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }
    @Override
    public void printAllByBrand() {
        laptopRepository.printByBrand("Lenovo");
    }
}
