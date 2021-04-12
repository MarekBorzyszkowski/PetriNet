package pg.mborzyszkowski.petrinet;

public class Place extends Node{
	private int numberOfTokens;

	public Place(String name, int numberOfTokens) {
		super(name);
		this.numberOfTokens = numberOfTokens;
	}

	public int getNumberOfTokens() {
		return numberOfTokens;
	}
}
