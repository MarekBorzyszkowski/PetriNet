package pg.mborzyszkowski.petrinet;

import com.sun.xml.internal.bind.v2.runtime.Transducer;

import java.util.*;
import java.util.stream.Collectors;

public abstract class PetriNet<TR extends Transaction> {

	private List<Place> places = new ArrayList<>();
	private List<TR> transactions = new ArrayList<>();
	private List<Regular> regulars = new ArrayList<>();
	private List<Inhibitor> inhibitors = new ArrayList<>();

	public Place addPlace(Place place){
		places.add(place);
		return place;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public List<TR> getTransactions() {
		return transactions;
	}

	public List<Regular> getRegulars() {
		return regulars;
	}

	public List<Inhibitor> getInhibitors() {
		return inhibitors;
	}

	public TR addTransaction(TR t){
		transactions.add(t);
		return t;
	}

	public Regular addRegular(int valueAttribute, Place place, Transaction transaction, Direction direction){
		Regular r = new Regular(valueAttribute, place, transaction, direction);
		regulars.add(r);
		return r;
	}

	public Inhibitor addInhibitor(int valueAttribute, Place place, Transaction transaction, Direction direction){
		Inhibitor i = new Inhibitor(valueAttribute, place, transaction, direction);
		inhibitors.add(i);
		return i;
	}

	public List<TR> getActiveTransactions() {
		return transactions.stream()
				.filter(tr -> tr.canExecute())
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
