package pg.mborzyszkowski.petrinet;

import pg.mborzyszkowski.petrinet.simple.ITransaction;
import pg.mborzyszkowski.petrinet.simple.Transaction;

public class Inhibitor extends Edge{
	public Inhibitor(int valueAttribute, Place place, ITransaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Inhibitor(Place place, ITransaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Inhibitor{ "+ super.toString() + " }";
	}
}
