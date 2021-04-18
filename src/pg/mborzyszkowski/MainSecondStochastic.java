package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.Continuous.ContinuousTransaction;
import pg.mborzyszkowski.petrinet.Direction;
import pg.mborzyszkowski.petrinet.Place;
import pg.mborzyszkowski.petrinet.Transaction;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPetriNet;
import pg.mborzyszkowski.petrinet.stochastic.StochasticTransaction;

public class MainSecondStochastic {

    public static void main(String[] args) {
        int S  = 999;
        int I  = 1;
        int R  = 0;
        int V  = 0;

        StochasticPetriNet petriNet =  new StochasticPetriNet();
        Place s = petriNet.addPlace(new Place("S", S));
        Transaction infection = petriNet.addTransaction(new StochasticTransaction("infection", 0.00025));
        Place i = petriNet.addPlace(new Place("I", I));
        Transaction recovery = petriNet.addTransaction(new StochasticTransaction("recovery", 0.1));
        Place r = petriNet.addPlace(new Place("R", R));
        Place v = petriNet.addPlace(new Place("V", V));
        Transaction vaccination = petriNet.addTransaction(new StochasticTransaction("vaccination", 0.01));
        Transaction vinfection = petriNet.addTransaction(new StochasticTransaction("vinfection", 0.0000375));

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
