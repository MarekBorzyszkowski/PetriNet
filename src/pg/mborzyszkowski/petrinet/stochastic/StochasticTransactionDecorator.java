package pg.mborzyszkowski.petrinet.stochastic;

import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;
import pg.mborzyszkowski.petrinet.generic.transaction.TransactionDecorator;

import java.util.List;
import java.util.stream.Collectors;

public class StochasticTransactionDecorator extends TransactionDecorator<StochasticPlace> {
	private final double parameter;

	public StochasticTransactionDecorator(ITransaction<StochasticPlace> transaction, double parameter) {
		super(transaction);
		this.parameter = parameter;
	}

	public double getLambda(){
		double lambda = parameter;
		List<Edge<StochasticPlace>> outgoingFromTransaction;
		for(Edge<StochasticPlace> inEdge : getIncoming()){
			outgoingFromTransaction = getOutgoing().stream().filter(edge -> edge.getPlace() == inEdge.getPlace()).collect(Collectors.toList());
			if (! outgoingFromTransaction.isEmpty())
				lambda *= (outgoingFromTransaction.get(0).getValueAttribute()-inEdge.getValueAttribute()) * (Integer)inEdge.getPlace().getNumberOfTokens();
			else
				lambda *= inEdge.getValueAttribute()*(Integer)inEdge.getPlace().getNumberOfTokens();
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
