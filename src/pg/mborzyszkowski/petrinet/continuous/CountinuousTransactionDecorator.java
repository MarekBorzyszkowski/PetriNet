package pg.mborzyszkowski.petrinet.continuous;

import pg.mborzyszkowski.petrinet.simple.ITransaction;
import pg.mborzyszkowski.petrinet.simple.TransactionDecorator;

public class CountinuousTransactionDecorator extends TransactionDecorator {
	private final double parameter;

	public CountinuousTransactionDecorator(ITransaction transaction, double parameter) {
		super(transaction);
		this.parameter = parameter;
	}

	public double getParameter() {
		return parameter;
	}

	@Override
	public String toString() {
		return "CountinuousTransactionDecorator{" + super.toString() +
				"parameter=" + parameter +
				"} ";
	}

}
