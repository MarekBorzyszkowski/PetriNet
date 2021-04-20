package pg.mborzyszkowski.petrinet.generic.transaction;

import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.place.Place;

import java.util.List;

public class TransactionDecorator<PL extends Place> implements ITransaction<PL> {
	protected ITransaction<PL> transaction;

	public TransactionDecorator(ITransaction<PL> transaction) {
		this.transaction = transaction;
	}

	@Override
	public List<Edge<PL>> getIncoming() {
		return transaction.getIncoming();
	}

	@Override
	public List<Edge<PL>> getOutgoing() {
		return transaction.getOutgoing();
	}

	@Override
	public String getName() {
		return transaction.getName();
	}

	@Override
	public void addIncoming(Edge<PL> edge) {
		transaction.addIncoming(edge);
	}

	@Override
	public void addOutgoing(Edge<PL> edge) {
		transaction.addOutgoing(edge);
	}

	@Override
	public boolean isNotConnected() {
		return transaction.isNotConnected();
	}

	@Override
	public boolean canExecute() {
		return transaction.canExecute();
	}

	@Override
	public void execute() {
		transaction.execute();
	}
}
