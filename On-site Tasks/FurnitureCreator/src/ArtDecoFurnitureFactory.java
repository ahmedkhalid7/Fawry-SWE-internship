
public class ArtDecoFurnitureFactory extends AbstractFactory {
    @Override
    public Furniture getFurnitureType(String FurnitureType) {
        if (FurnitureType.equalsIgnoreCase("Chair")) {
            return new ArtDecoChair();
        }
        if (FurnitureType.equalsIgnoreCase("Sofa")) {
            return new ArtDecoSofa();
        }
        if (FurnitureType.equalsIgnoreCase("CoffeTable")) {
            return new ArtDecoCoffeTable();
        }
        return null;
    }
}
