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
