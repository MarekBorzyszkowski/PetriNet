package pg.mborzyszkowski.petrinet.generic.edge;

import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;

public class Regular<PL extends Place> extends Edge<PL>{
	public Regular(int valueAttribute, PL place, ITransaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Regular(PL place, ITransaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Regular{" + super.toString() +"}";
	}
}
