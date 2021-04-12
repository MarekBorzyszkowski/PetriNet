package pg.mborzyszkowski.petrinet;

public class Regular extends Edge{
	public Regular(int valueAttribute, Place place, Transaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Regular(Place place, Transaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Regular{" + super.toString() +"}";
	}
}
