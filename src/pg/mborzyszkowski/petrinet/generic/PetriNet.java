package pg.mborzyszkowski.petrinet.generic;

import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.generic.edge.Inhibitor;
import pg.mborzyszkowski.petrinet.generic.edge.Regular;
import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;

import java.util.*;
import java.util.stream.Collectors;

public abstract class PetriNet<TR extends ITransaction<PL>, PL extends Place> {

	private final List<PL> places = new ArrayList<>();
	private final List<TR> transactions = new ArrayList<>();
	private final List<Regular<PL>> regulars = new ArrayList<>();
	private final List<Inhibitor<PL>> inhibitors = new ArrayList<>();

	public PL addPlace(PL place){
		places.add(place);
		return place;
	}

	public List<PL> getPlaces() {
		return places;
	}

	public List<TR> getTransactions() {
		return transactions;
	}

	public List<Regular<PL>> getRegulars() {
		return regulars;
	}

	public List<Inhibitor<PL>> getInhibitors() {
		return inhibitors;
	}

	public TR addTransaction(TR t){
		transactions.add(t);
		return t;
	}

	public Regular<PL> addRegular(int valueAttribute, PL place, ITransaction<PL> transaction, Direction direction){
		Regular<PL> r = new Regular<PL>(valueAttribute, place, transaction, direction);
		regulars.add(r);
		return r;
	}

	public Inhibitor<PL> addInhibitor(int valueAttribute, PL place, ITransaction<PL> transaction, Direction direction){
		Inhibitor<PL> i = new Inhibitor<PL>(valueAttribute, place, transaction, direction);
		inhibitors.add(i);
		return i;
	}

	public List<TR> getActiveTransactions() {
		return transactions.stream()
				.filter(ITransaction::canExecute)
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "PetriNet{\n\t" +
				"places=" + places +
				"\n\ttransactions=" + transactions +
				"\n\tregulars=" + regulars +
				"\n\tinhibitors=" + inhibitors +
				"\n}";
	}
}
