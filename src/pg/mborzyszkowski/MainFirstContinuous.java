package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.continuous.ContinuousPetriNet;
import pg.mborzyszkowski.petrinet.continuous.ContinuousPlace;
import pg.mborzyszkowski.petrinet.generic.edge.Direction;
import pg.mborzyszkowski.petrinet.continuous.ContinuousTransactionDecorator;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;
import pg.mborzyszkowski.petrinet.generic.transaction.Transaction;

public class MainFirstContinuous {

    public static void main(String[] args) {
        double S  = 999;
        double I  = 1;
        double R  = 0;

        ContinuousPetriNet petriNet =  new ContinuousPetriNet();
        ContinuousPlace s = petriNet.addPlace(new ContinuousPlace("S", S));
        ITransaction infection = petriNet.addTransaction(new ContinuousTransactionDecorator(new Transaction("infection"), 0.00025));
        ContinuousPlace i = petriNet.addPlace(new ContinuousPlace("I", I));
        ITransaction recovery = petriNet.addTransaction(new ContinuousTransactionDecorator(new Transaction("recovery"), 0.1));
        ContinuousPlace r = petriNet.addPlace(new ContinuousPlace("R", R));

        petriNet.addRegular(1, s, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, i, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(2, i, infection, Direction.TO_PLACE);
        petriNet.addRegular(1, i, recovery, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, r, recovery, Direction.TO_PLACE);

        System.out.println(petriNet);

        for(int x = 0; x < 100; x++)
            petriNet.executeContinousTransactions();

        System.out.println(petriNet);
    }

}
