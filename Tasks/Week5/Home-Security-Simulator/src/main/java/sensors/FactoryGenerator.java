package sensors;

public class FactoryGenerator {
   public static AbstractFactory getFactory(FactoryNameEnum factoryName){
      return switch (factoryName) {
         case A -> new SmokeSensorFactoryA();
         case B -> new SmokeSensorFactoryB();
         case C -> new MotionSensorFactoryC();
         case D -> new MotionSensorFactoryD();
         default -> null;
      };
   }
}

