package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;
import pg.mborzyszkowski.petrinet.generic.transaction.Transaction;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPetriNet;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPlace;
import pg.mborzyszkowski.petrinet.stochastic.StochasticTransactionDecorator;

public class MainSecondStochastic {

    public static void main(String[] args) {
        int S  = 999;
        int I  = 1;
        int R  = 0;
        int V  = 0;

        StochasticPetriNet petriNet =  new StochasticPetriNet();
        StochasticPlace s = petriNet.addPlace(new StochasticPlace("S", S));
        ITransaction infection = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction("infection"), 0.00025));
        StochasticPlace i = petriNet.addPlace(new StochasticPlace("I", I));
        ITransaction recovery = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction("recovery"), 0.1));
        StochasticPlace r = petriNet.addPlace(new StochasticPlace("R", R));
        StochasticPlace v = petriNet.addPlace(new StochasticPlace("V", V));
        ITransaction vaccination = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction("vaccination"), 0.01));
        ITransaction vinfection = petriNet.addTransaction(new StochasticTransactionDecorator(new Transaction("vinfection"), 0.0000375));

        petriNet.addRegular(1, s, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, i, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(2, i, infection, Direction.TO_PLACE);
        petriNet.addRegular(1, i, recovery, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, r, recovery, Direction.TO_PLACE);
        petriNet.addRegular(1, s, vaccination, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, v, vaccination, Direction.TO_PLACE);
        petriNet.addRegular(1, v, vinfection, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, i, vinfection, Direction.TO_TRANSACTION);
        petriNet.addRegular(2, i, vinfection, Direction.TO_PLACE);

        System.out.println(petriNet);

        for(int x = 0; x < 100; x++)
            petriNet.getTransactionToExecute().execute();

        System.out.println(petriNet);
    }

}
