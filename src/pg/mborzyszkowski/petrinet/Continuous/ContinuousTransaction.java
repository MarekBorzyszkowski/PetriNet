package pg.mborzyszkowski.petrinet.Continuous;

import pg.mborzyszkowski.petrinet.Transaction;

public class ContinuousTransaction extends Transaction{
	private double parameter;

	public ContinuousTransaction(String name, double parameter) {
		super(name);
		this.parameter = parameter;
	}

	public double getParameter() {
		return parameter;
	}

	@Override
	public String toString() {
		return "ContinuousTransaction{" + super.toString() +
				"parameter=" + parameter +
				"} ";
	}
}
