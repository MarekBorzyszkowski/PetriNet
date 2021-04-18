package pg.mborzyszkowski.petrinet.continuous;

import pg.mborzyszkowski.petrinet.*;
import pg.mborzyszkowski.petrinet.simple.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ContinuousPetriNet extends PetriNet<CountinuousTransactionDecorator> {


	public CountinuousTransactionDecorator addTransaction(String name, double parametr) {
		CountinuousTransactionDecorator t = new CountinuousTransactionDecorator(new Transaction(name), parametr);
		super.addTransaction(t);
		return t;
	}

	public void executeContinousTransactions(){
		List<Regular> regularsForPlace;
		List<Double> derivatives = new ArrayList<>();
		CountinuousTransactionDecorator t;
		double mult = 0;
		int idx = 0;
		for(Place pl : getPlaces()) {
			regularsForPlace = new ArrayList<>();
			for (Regular reg : getRegulars()){
				if ((reg.getPlace()) == pl)
					regularsForPlace.add(reg);
			}
			derivatives.add(0.0);
			for (Regular reg : regularsForPlace){
				t = (CountinuousTransactionDecorator) reg.getTransaction();
				mult = 1.0;
				for(Edge edge : t.getIncoming())
					mult *= edge.getPlace().getNumberOfTokens();
				mult *= t.getParameter()*reg.getValueAttribute();
				if(reg.getDirection().equals(Direction.TO_PLACE)){
					derivatives.set(idx, derivatives.get(idx) + mult);
				}
				else if(reg.getDirection().equals(Direction.TO_TRANSACTION)) {
					derivatives.set(idx, derivatives.get(idx) - mult);
				}
			}
			idx++;
		}
		idx = 0;
		for(Place pl : getPlaces()) {
			if(derivatives.get(idx) + pl.getNumberOfTokens() >= 0)
				pl.setNumberOfTokens(derivatives.get(idx) + pl.getNumberOfTokens());
			else
				pl.setNumberOfTokens(0);
			idx++;
		}
	}

	@Override
	public String toString() {
		return "ContinuousPetriNet{} " + super.toString();
	}
}
