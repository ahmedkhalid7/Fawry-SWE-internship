package structural.decorator;

import java.math.BigDecimal;

public class Cheese extends SandwichDecorator {

	public Cheese(Sandwich sw) {
		super(sw);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + ", Cheese";
	}

	@Override public BigDecimal price() {
		return super.price().add(new BigDecimal("0.50"));
	}
}
