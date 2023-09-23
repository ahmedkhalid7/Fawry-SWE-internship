package structural.decorator;

import java.math.BigDecimal;

public class WhiteBreadSandwich implements Sandwich {

	@Override
	public String getDescription() {
		return "White bread Sandwich";
	}

	@Override
	public BigDecimal price() {
		return new BigDecimal("3.0");
	}

}
