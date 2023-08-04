
public class VictorianFurnitureFactory extends AbstractFactory {
    @Override
    public Furniture getFurnitureType(String FurnitureType) {
        if (FurnitureType.equalsIgnoreCase("Chair")) {
            return new VictorianChair();
        }
        if (FurnitureType.equalsIgnoreCase("Sofa")) {
            return new VictorianSofa();
        }
        if (FurnitureType.equalsIgnoreCase("Coffe Table")) {
            return new VictorianCoffeTable();
        }
        return null;
    }
}
