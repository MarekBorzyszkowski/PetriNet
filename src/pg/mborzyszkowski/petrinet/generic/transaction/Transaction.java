package pg.mborzyszkowski.petrinet.generic.transaction;

import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.Node;
import pg.mborzyszkowski.petrinet.generic.place.Place;

import java.util.*;

public class Transaction<PL extends Place> extends Node implements ITransaction<PL> {

	private final List<Edge<PL>> incoming = new ArrayList<>();
	private final List<Edge<PL>> outgoing = new ArrayList<>();

	public Transaction(String name) {
		super(name);
	}

	@Override
	public List<Edge<PL>> getIncoming() {
		return incoming;
	}

	@Override
	public List<Edge<PL>> getOutgoing() {
		return outgoing;
	}

	@Override
	public void addIncoming(Edge<PL> edge){
		if(edge.getDirection().equals(Direction.TO_TRANSACTION))
			this.incoming.add(edge);
	}

	@Override
	public void addOutgoing(Edge<PL> edge){
		this.outgoing.add(edge);
	}

	@Override
	public boolean isNotConnected(){
		return incoming.isEmpty() && outgoing.isEmpty();
	}

	@Override
	public boolean canExecute(){
		if (isNotConnected())
			return false;
		else
			return this.incoming.stream()
						.map(e -> e.canExecute())
						.reduce(true, (result, edgeCanExecute)  -> result & edgeCanExecute)
					&
					this.outgoing.stream()
							.map(e -> e.canExecute())
							.reduce(true, (result, edgeCanExecute)  -> result & edgeCanExecute);
	}

	@Override
	public void execute(){
		this.incoming.stream().forEach(edge -> edge.execute());
		this.outgoing.stream().forEach(edge -> edge.execute());
	}

	@Override
	public String toString() {
		return "\n\t\tTransaction{" +
				"name=" + this.getName() +
				"\n\t\t\tincoming=" + incoming +
				"\n\t\t\toutgoing=" + outgoing +
				super.toString() + "}";
	}
}
