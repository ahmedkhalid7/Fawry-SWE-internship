package creational.abstractfactory.concretes;

import creational.abstractfactory.Shape;

public class RoundedSquare implements Shape {

	@Override
	public void draw() {
		System.out.println("Inside RoundedSquare::draw() method.");
	}
}
