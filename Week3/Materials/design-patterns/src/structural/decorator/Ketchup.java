package structural.decorator;

import java.math.BigDecimal;

public class Ketchup extends SandwichDecorator {

	public Ketchup(Sandwich sw) {
		super(sw);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", ketchup";
	}

	@Override public BigDecimal price() {
		return super.price().add(new BigDecimal("0.25"));
	}
}
