package pg.mborzyszkowski.petrinet.simple;

import pg.mborzyszkowski.petrinet.Direction;
import pg.mborzyszkowski.petrinet.Edge;
import pg.mborzyszkowski.petrinet.Node;

import java.util.*;

public class Transaction extends Node implements ITransaction {

	private List<Edge> incoming = new ArrayList<>();
	private List<Edge> outgoing = new ArrayList<>();

	public Transaction(String name) {
		super(name);
	}

	@Override
	public List<Edge> getIncoming() {
		return incoming;
	}

	@Override
	public List<Edge> getOutgoing() {
		return outgoing;
	}

	@Override
	public void addIncoming(Edge edge){
		if(edge.getDirection().equals(Direction.TO_TRANSACTION))
			this.incoming.add(edge);
	}

	@Override
	public void addOutgoing(Edge edge){
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
