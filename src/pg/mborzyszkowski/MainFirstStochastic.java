package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;
import pg.mborzyszkowski.petrinet.generic.transaction.Transaction;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPetriNet;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPlace;
import pg.mborzyszkowski.petrinet.stochastic.StochasticTransactionDecorator;

public class MainFirstStochastic {

    public static void main(String[] args) {
        int S  = 999;
        int I  = 1;
        int R  = 0;

        StochasticPetriNet petriNet =  new StochasticPetriNet();
        StochasticPlace s = petriNet.addPlace(new StochasticPlace("S", S));
        ITransaction<StochasticPlace> infection = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction<>("infection"), 0.00025));
        StochasticPlace i = petriNet.addPlace(new StochasticPlace("I", I));
        ITransaction<StochasticPlace> recovery = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction<>("recovery"), 0.1));
        StochasticPlace r = petriNet.addPlace(new StochasticPlace("R", R));

        petriNet.addRegular(1, s, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, i, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(2, i, infection, Direction.TO_PLACE);
        petriNet.addRegular(1, i, recovery, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, r, recovery, Direction.TO_PLACE);

        System.out.println(petriNet);

        for(int x = 0; x < 100; x++)
            petriNet.getTransactionToExecute().execute();

        System.out.println(petriNet);
    }

}
