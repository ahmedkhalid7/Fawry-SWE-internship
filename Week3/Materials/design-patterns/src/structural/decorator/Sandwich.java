package structural.decorator;

import java.math.BigDecimal;

public interface Sandwich {

	default String getDescription() {
		return "Sandwich";
	}
	 BigDecimal price();
}
