package pg.mborzyszkowski.petrinet;

public class Inhibitor extends Edge{
	public Inhibitor(int valueAttribute, Place place, Transaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Inhibitor(Place place, Transaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Inhibitor{ "+ super.toString() + " }";
	}
}
