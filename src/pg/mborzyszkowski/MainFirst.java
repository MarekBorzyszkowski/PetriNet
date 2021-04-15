package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.*;
import pg.mborzyszkowski.petrinet.stochastic.StochasticPetriNet;
import pg.mborzyszkowski.petrinet.stochastic.StochasticTransaction;

import java.util.List;

public class MainFirst {

    public static void main(String[] args) {
        /**
         * Run params:
         *      args[1] = S
         *      args[2] = I
         *      args[3] = R
         */
        StochasticPetriNet petriNet =  new StochasticPetriNet();
        Place s = petriNet.addPlace("S", Integer.parseInt(args[1]));
        Transaction infection = petriNet.addTransaction(new StochasticTransaction("infection", 0.00025));
        Place i = petriNet.addPlace("I", Integer.parseInt(args[2]));
        Transaction recovery = petriNet.addTransaction(new StochasticTransaction("recovery", 0.1));
        Place r = petriNet.addPlace("R", Integer.parseInt(args[3]));

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
