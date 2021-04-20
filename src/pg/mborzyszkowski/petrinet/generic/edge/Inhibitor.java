package pg.mborzyszkowski.petrinet.generic.edge;

import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;

public class Inhibitor<PL extends Place> extends Edge<PL>{
	public Inhibitor(int valueAttribute, PL place, ITransaction transaction, Direction direction) {
		super(valueAttribute, place, transaction, direction);
	}

	public Inhibitor(PL place, ITransaction transaction, Direction direction) {
		super(place, transaction, direction);
	}

	@Override
	public String toString() {
		return "Inhibitor{ "+ super.toString() + " }";
	}
}
