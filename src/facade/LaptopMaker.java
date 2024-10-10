package facade;


import model.Laptop;
import repository.LaptopRepository;
import service.AsusImpl;
import service.LaptopInterface;
import service.LenovoImpl;
import service.MacbookImpl;

public class LaptopMaker {
    private LaptopInterface asus;
    private LaptopInterface lenovo;
    private LaptopInterface macbook;
    private LaptopRepository laptopRepository;

    public LaptopMaker(){
        laptopRepository = new LaptopRepository();
        asus = new AsusImpl(laptopRepository);
        lenovo = new LenovoImpl(laptopRepository);
        macbook = new MacbookImpl(laptopRepository);
    }

    public void printAll(){
        laptopRepository.printAllBrand();
    }
    public void printAsus(){
        asus.printAllByBrand();
    }
    public void printLenovo(){
        lenovo.printAllByBrand();
    }
    public void printMacbook(){
        macbook.printAllByBrand();
    }
    public void getDetailLaptop(int id){
        laptopRepository.getDetailById(id);
    }
    public void addNewLaptop(Laptop laptop){
        laptopRepository.addNewLaptop(laptop);
    }
    public void updateLaptop(int id, Laptop updateLaptop){
        laptopRepository.updateById(id, updateLaptop);
    }
    public void removeLaptop(int id){
        laptopRepository.removeById(id);
    }

}