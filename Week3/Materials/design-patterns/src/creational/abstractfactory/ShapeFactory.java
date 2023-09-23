package creational.abstractfactory;


import commons.ShapeTypeEnum;
import creational.abstractfactory.concretes.Rectangle;
import creational.abstractfactory.concretes.Square;

public class ShapeFactory extends AbstractFactory {

	public Shape getShape(ShapeTypeEnum shapeType){
		switch (shapeType) {
			case SQUARE:
				return new Square();

			case RECTANGLE:
				return new Rectangle();

			default: return null;
		}
	}
}
