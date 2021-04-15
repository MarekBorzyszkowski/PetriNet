package pg.mborzyszkowski.petrinet;

import java.util.*;

public class Transaction extends Node{
	private double parameter;

	private List<Edge> incoming = new ArrayList<>();
	private List<Edge> outgoing = new ArrayList<>();

	public Transaction(String name, double parameter) {
		super(name);
		this.parameter = parameter;
	}
	public void addIncoming(Edge edge){
		this.incoming.add(edge);
	}

	public void addOutgoing(Edge edge){
		this.outgoing.add(edge);
	}

	public boolean isNotConnected(){
		return incoming.isEmpty() && outgoing.isEmpty();
	}

	public boolean canExecute(){
		if (! isNotConnected())
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

	public void execute(){
		this.incoming.stream().forEach(edge -> edge.execute());
		this.outgoing.stream().forEach(edge -> edge.execute());
	}

	@Override
	public String toString() {
		return "\n\t\tTransaction{" +
				"name=" + this.getName() +
				" parameter=" + parameter +
				"\n\t\t\tincoming=" + incoming +
				"\n\t\t\toutgoing=" + outgoing +
				super.toString() + "}";
	}
}
