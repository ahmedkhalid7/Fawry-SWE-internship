package creational.abstractfactory;

import commons.ShapeTypeEnum;

public abstract class AbstractFactory {
	abstract Shape getShape(ShapeTypeEnum shapeType) ;
}
