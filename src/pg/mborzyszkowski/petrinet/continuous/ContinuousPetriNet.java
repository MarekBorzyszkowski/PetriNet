package pg.mborzyszkowski.petrinet.continuous;

import pg.mborzyszkowski.petrinet.generic.PetriNet;
import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.generic.edge.Edge;
import pg.mborzyszkowski.petrinet.generic.edge.Regular;
import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ContinuousPetriNet extends PetriNet<ContinuousTransactionDecorator, ContinuousPlace> {


	public ContinuousTransactionDecorator addTransaction(String name, double parametr) {
		ContinuousTransactionDecorator t = new ContinuousTransactionDecorator(new Transaction<ContinuousPlace>(name), parametr);
		super.addTransaction(t);
		return t;
	}

	public void executeContinousTransactions(){
		List<Regular<ContinuousPlace>> regularsForPlace;
		List<Double> derivatives = new ArrayList<>();
		ContinuousTransactionDecorator t;
		double mult = 0;
		int idx = 0;
		for(Place pl : getPlaces()) {
			regularsForPlace = new ArrayList<>();
			for (Regular<ContinuousPlace> reg : getRegulars()){
				if ((reg.getPlace()) == pl)
					regularsForPlace.add(reg);
			}
			derivatives.add(0.0);
			for (Regular<ContinuousPlace> reg : regularsForPlace){
				t = (ContinuousTransactionDecorator) reg.getTransaction();
				mult = 1.0;
				for(Edge<ContinuousPlace> edge : t.getIncoming())
					mult *= edge.getPlace().getNumberOfTokens().doubleValue();
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
			if(derivatives.get(idx) + pl.getNumberOfTokens().doubleValue() >= 0)
				pl.setNumberOfTokens(derivatives.get(idx) + pl.getNumberOfTokens().doubleValue());
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
