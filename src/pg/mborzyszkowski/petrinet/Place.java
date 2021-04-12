package pg.mborzyszkowski.petrinet;

public class Place extends Node{
	private int numberOfTokens;

	public Place(String name, int numberOfTokens) {
		super(name);
		this.numberOfTokens = numberOfTokens;
	}

	public Place(String name) {
		super(name);
	}

	public int getNumberOfTokens() {
		return numberOfTokens;
	}

	public void setNumberOfTokens(int numberOfTokens) {
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
