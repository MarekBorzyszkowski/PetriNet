package pg.mborzyszkowski.petrinet.simple;

import pg.mborzyszkowski.petrinet.Edge;

import java.util.List;

public class TransactionDecorator implements ITransaction{
	protected ITransaction transaction;

	public TransactionDecorator(ITransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public List<Edge> getIncoming() {
		return transaction.getIncoming();
	}

	@Override
	public List<Edge> getOutgoing() {
		return transaction.getOutgoing();
	}

	@Override
	public String getName() {
		return transaction.getName();
	}

	@Override
	public void addIncoming(Edge edge) {
		transaction.addIncoming(edge);
	}

	@Override
	public void addOutgoing(Edge edge) {
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
