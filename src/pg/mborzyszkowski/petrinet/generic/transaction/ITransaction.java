package pg.mborzyszkowski.petrinet.generic.transaction;

import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.place.Place;

import java.util.List;

public interface ITransaction<PL extends Place> {
	List<Edge<PL>> getIncoming();

	List<Edge<PL>> getOutgoing();

	public String getName();

	void addIncoming(Edge<PL> edge);

	void addOutgoing(Edge<PL> edge);

	boolean isNotConnected();

	boolean canExecute();

	void execute();

	@Override
	String toString();
}
