
public class ModernFurnitureFactory extends AbstractFactory {
    @Override
    public Furniture getFurnitureType(String FurnitureType) {
        if (FurnitureType.equalsIgnoreCase("Chair")) {
            return new ModernChair();
        }
        if (FurnitureType.equalsIgnoreCase("Sofa")) {
            return new ModernSofa();
        }
        if (FurnitureType.equalsIgnoreCase("Coffe Table")) {
            return new ModernCoffeTable();
        }
        return null;
    }
}
