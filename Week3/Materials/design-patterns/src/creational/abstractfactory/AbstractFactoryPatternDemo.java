package creational.abstractfactory;

import commons.ShapeTypeEnum;


public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		//get an object of Rectangle and call its draw method.
		Shape shape1 = shapeFactory.getShape(ShapeTypeEnum.RECTANGLE);

		//call draw method of Rectangle
		shape1.draw();

		//get an object of Square and call its draw method.
		Shape shape2 = shapeFactory.getShape(ShapeTypeEnum.SQUARE);

		//call draw method of square
		shape2.draw();

		//// Rounded Factory

		RoundedShapeFactory roundedFactory = new RoundedShapeFactory();

		//get an object of Rectangle and call its draw method.
		Shape shape3 = roundedFactory.getShape(ShapeTypeEnum.RECTANGLE);

		//call draw method of Rectangle
		shape3.draw();

		//get an object of Square and call its draw method.
		Shape shape4 = roundedFactory.getShape(ShapeTypeEnum.SQUARE);

		//call draw method of square
		shape4.draw();

	}
}
