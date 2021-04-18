package pg.mborzyszkowski.petrinet.simple;

import pg.mborzyszkowski.petrinet.Edge;

import java.util.List;

public interface ITransaction {
	List<Edge> getIncoming();

	List<Edge> getOutgoing();

	public String getName();

	void addIncoming(Edge edge);

	void addOutgoing(Edge edge);

	boolean isNotConnected();

	boolean canExecute();

	void execute();

	@Override
	String toString();
}
