package pg.mborzyszkowski.petrinet.generic.place;

import pg.mborzyszkowski.petrinet.generic.Node;

public abstract class Place extends Node {
	private Number numberOfTokens;

	public Place(String name, Number numberOfTokens) {
		super(name);
		this.numberOfTokens = numberOfTokens;
	}

	public Place(String name) {
		super(name);
	}

	public Number getNumberOfTokens() {
		return numberOfTokens;
	}

	public void setNumberOfTokens(Number numberOfTokens) {
		this.numberOfTokens = numberOfTokens;
	}

	@Override
	public String toString() {
		return "Place{" +
				"name=" + this.getName() + " " +
				"tokens=" + numberOfTokens  +
				 "}";
	}
}
