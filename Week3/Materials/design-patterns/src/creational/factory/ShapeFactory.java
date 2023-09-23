package creational.factory;

import commons.ShapeTypeEnum;
import creational.factory.concretes.Circle;
import creational.factory.concretes.Rectangle;
import creational.factory.concretes.Square;

public class ShapeFactory {

	public Shape getShape(ShapeTypeEnum shapeType){
		switch (shapeType) {
			case CIRCLE:
				return new Circle();

			case SQUARE:
				return new Square();

			case RECTANGLE:
				return new Rectangle();

			default: return null;
		}
	}
}
