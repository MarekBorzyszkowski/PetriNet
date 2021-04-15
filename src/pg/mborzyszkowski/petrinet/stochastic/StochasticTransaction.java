package pg.mborzyszkowski.petrinet.stochastic;

import java.util.*;
import java.util.stream.Collectors;

import pg.mborzyszkowski.petrinet.Edge;
import pg.mborzyszkowski.petrinet.Place;
import pg.mborzyszkowski.petrinet.Transaction;

public class StochasticTransaction extends Transaction {
	private double parameter;

	public StochasticTransaction(String name, double parameter) {
		super(name);
		this.parameter = parameter;
	}

	public double getLambda(){
		double lambda=parameter;
		List<Edge> outgoingFromTransaction;
		for(Edge inEdge : getIncoming()){
			outgoingFromTransaction = getOutgoing().stream().filter(edge -> edge.getPlace() == inEdge.getPlace()).collect(Collectors.toList());
			if (! outgoingFromTransaction.isEmpty())
				lambda *= (outgoingFromTransaction.get(0).getValueAttribute()-inEdge.getValueAttribute()) * inEdge.getPlace().getNumberOfTokens();
			else
				lambda *= inEdge.getValueAttribute()*inEdge.getPlace().getNumberOfTokens();
		}
		return lambda;
	}
	@Override
	public String toString() {
		return "StochasticTransaction{" + super.toString() +
				"parameter=" + parameter +
				"} ";
	}
}
