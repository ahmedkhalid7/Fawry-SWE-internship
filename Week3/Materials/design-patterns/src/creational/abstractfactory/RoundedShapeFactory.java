package creational.abstractfactory;


import commons.ShapeTypeEnum;
import creational.abstractfactory.concretes.RoundedRectangle;
import creational.abstractfactory.concretes.RoundedSquare;

public class RoundedShapeFactory extends AbstractFactory {

	public Shape getShape(ShapeTypeEnum shapeType){
		switch (shapeType) {
			case SQUARE:
				return new RoundedSquare();

			case RECTANGLE:
				return new RoundedRectangle();

			default: return null;
		}
	}
}
