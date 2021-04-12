package pg.mborzyszkowski.petrinet;

public class Edge {
	private int valueAttribute;

	private Place place;
	private Transaction transaction;
	private Direction direction;

	public Edge(int valueAttribute, Place place, Transaction transaction, Direction direction) {
		this.valueAttribute = valueAttribute;
		this.place = place;
		this.transaction = transaction;
		this.direction = direction;
	}

	public Edge(Place place, Transaction transaction, Direction direction) {
		this(1, place, transaction, direction);
	}
}
