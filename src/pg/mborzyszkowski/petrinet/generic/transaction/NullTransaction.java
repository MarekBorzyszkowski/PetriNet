package pg.mborzyszkowski.petrinet.generic.transaction;

import pg.mborzyszkowski.petrinet.generic.Node;
import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.place.Place;

import java.util.List;

public class NullTransaction <PL extends Place> extends Node implements ITransaction<PL>{
	public NullTransaction(String name) {
		super(name);
	}

	@Override
	public List<Edge<PL>> getIncoming() {
		return null;
	}

	@Override
	public List<Edge<PL>> getOutgoing() {
		return null;
	}

	@Override
	public void addIncoming(Edge<PL> edge) {

	}

	@Override
	public void addOutgoing(Edge<PL> edge) {

	}

	@Override
	public boolean isNotConnected() {
		return true;
	}

	@Override
	public boolean canExecute() {
		return false;
	}

	@Override
	public void execute() {
	}
}
