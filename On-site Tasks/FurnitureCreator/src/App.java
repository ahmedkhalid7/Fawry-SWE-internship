
public class App {
    public static void main(String[] args) throws Exception {

        AbstractFactory ArtDecoFurnitureFactory = FurnitureFactoryGenerator.getFurnitureFactory("ArtDeco");
        Furniture adc = ArtDecoFurnitureFactory.getFurnitureType("Chair");
        Furniture ads = ArtDecoFurnitureFactory.getFurnitureType("Sofa");
        Furniture adct = ArtDecoFurnitureFactory.getFurnitureType("CoffeTable");
        adc.create();
        ads.create();
        adct.create();
    }
}
