
public class FurnitureFactoryGenerator {
    public static AbstractFactory getFurnitureFactory(String FurnitureType) {
        if (FurnitureType.equalsIgnoreCase("ArtDeco")) {
            return new ArtDecoFurnitureFactory();
        }
        if (FurnitureType.equalsIgnoreCase("Victorian")) {
            return new VictorianFurnitureFactory();
        }
        if (FurnitureType.equalsIgnoreCase("Modern")) {
            return new ModernFurnitureFactory();
        }
        return null;
    }
}