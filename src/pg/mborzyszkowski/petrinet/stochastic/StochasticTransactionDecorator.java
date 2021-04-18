package pg.mborzyszkowski.petrinet.stochastic;

import pg.mborzyszkowski.petrinet.Edge;
import pg.mborzyszkowski.petrinet.simple.ITransaction;
import pg.mborzyszkowski.petrinet.simple.TransactionDecorator;

import java.util.List;
import java.util.stream.Collectors;

public class StochasticTransactionDecorator extends TransactionDecorator {
	private final double parameter;

	public StochasticTransactionDecorator(ITransaction transaction, double parameter) {
		super(transaction);
		this.parameter = parameter;
	}

	public double getLambda(){
		double lambda = parameter;
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
