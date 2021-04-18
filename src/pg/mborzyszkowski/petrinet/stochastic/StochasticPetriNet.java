package pg.mborzyszkowski.petrinet.stochastic;

import pg.mborzyszkowski.petrinet.PetriNet;
import pg.mborzyszkowski.petrinet.simple.Transaction;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//
public class StochasticPetriNet extends PetriNet<StochasticTransactionDecorator> {

	public StochasticTransactionDecorator getTransactionToExecute(){
		List<StochasticTransactionDecorator> transactions = this.getActiveTransactions();
		List<Double> lambdas = this.getActiveTransactions().stream()
				.map(trx -> trx.getLambda())
				.collect(Collectors.toList());
		double sumAllLambdas = lambdas.stream().reduce(0.0, (x, y) -> x+y);
		double randNumber = new Random().nextDouble() * sumAllLambdas;
		int index = 0;
		double sumLambdas = 0;
		for(Double lbd : lambdas){
			if(sumLambdas <= randNumber && randNumber < sumLambdas + lbd)
				break;
			else{
				sumLambdas += lbd;
				index++;
			}
		}
		return transactions.get(index);
	}


	public StochasticTransactionDecorator addTransaction(String name, double parametr) {
		StochasticTransactionDecorator t = new StochasticTransactionDecorator(new Transaction(name), parametr);
		super.addTransaction(new StochasticTransactionDecorator(new Transaction(name), parametr));
		return t;
	}

	@Override
	public String toString() {
		return "StochasticPetriNet{} " + super.toString();
	}
}
