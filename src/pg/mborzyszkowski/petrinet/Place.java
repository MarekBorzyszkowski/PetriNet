package pg.mborzyszkowski.petrinet;

public class Place extends Node{
	private double numberOfTokens;

	public Place(String name, int numberOfTokens) {
		super(name);
		this.numberOfTokens = numberOfTokens;
	}

	public Place(String name) {
		super(name);
	}

	public double getNumberOfTokens() {
		return numberOfTokens;
	}

	public void setNumberOfTokens(double numberOfTokens) {
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
