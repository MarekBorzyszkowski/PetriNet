package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.continuous.ContinuousPetriNet;
import pg.mborzyszkowski.petrinet.Direction;
import pg.mborzyszkowski.petrinet.Place;
import pg.mborzyszkowski.petrinet.continuous.CountinuousTransactionDecorator;
import pg.mborzyszkowski.petrinet.simple.ITransaction;
import pg.mborzyszkowski.petrinet.simple.Transaction;

public class MainFirstContinuous {

    public static void main(String[] args) {
        int S  = 999;
        int I  = 1;
        int R  = 0;

        ContinuousPetriNet petriNet =  new ContinuousPetriNet();
        Place s = petriNet.addPlace(new Place("S", S));
        ITransaction infection = petriNet.addTransaction(new CountinuousTransactionDecorator(new Transaction("infection"), 0.00025));
        Place i = petriNet.addPlace(new Place("I", I));
        ITransaction recovery = petriNet.addTransaction(new CountinuousTransactionDecorator(new Transaction("recovery"), 0.1));
        Place r = petriNet.addPlace(new Place("R", R));

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
