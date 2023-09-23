package structural.decorator;

import java.math.BigDecimal;

public class SandwichDecorator implements Sandwich {
	private Sandwich currentSandwich;

	public SandwichDecorator(Sandwich sw) {
		currentSandwich = sw;
	}

	@Override
	public String getDescription() {
		return currentSandwich.getDescription();
	}

	@Override public BigDecimal price() {
		return currentSandwich.price();
	}
}
