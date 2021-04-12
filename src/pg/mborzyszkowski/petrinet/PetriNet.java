package pg.mborzyszkowski.petrinet;

import java.util.*;

public class PetriNet {

	private List<Place> places = new ArrayList<>();
	private List<Transaction> transactions = new ArrayList<>();
	private List<Regular> regulars = new ArrayList<>();
	private List<Inhibitor> inhibitors = new ArrayList<>();

	public Place addPlace(String name, int numberOfTokens){
		Place p = new Place(name,numberOfTokens);
		places.add(p);
		return p;
	}

	public Transaction addTransaction(String name, double parameter){
		Transaction t = new Transaction(name, parameter);
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
