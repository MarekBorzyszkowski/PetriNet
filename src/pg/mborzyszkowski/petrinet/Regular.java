package pg.mborzyszkowski.petrinet;

import pg.mborzyszkowski.petrinet.simple.ITransaction;
import pg.mborzyszkowski.petrinet.simple.Transaction;

public class Regular extends Edge{
	public Regular(int valueAttribute, Place place, ITransaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Regular(Place place, ITransaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Regular{" + super.toString() +"}";
	}
}
