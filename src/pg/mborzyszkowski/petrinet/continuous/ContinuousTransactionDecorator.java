package pg.mborzyszkowski.petrinet.continuous;

import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;
import pg.mborzyszkowski.petrinet.generic.transaction.TransactionDecorator;

public class ContinuousTransactionDecorator extends TransactionDecorator<ContinuousPlace> {
	private final double parameter;

	public ContinuousTransactionDecorator(ITransaction<ContinuousPlace> transaction, double parameter) {
		super(transaction);
		this.parameter = parameter;
	}

	public double getParameter() {
		return parameter;
	}

	@Override
	public String toString() {
		return "ContinuousTransactionDecorator{" + super.toString() +
				", parameter=" + parameter +
				"} ";
	}

}
