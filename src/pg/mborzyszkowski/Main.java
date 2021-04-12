package pg.mborzyszkowski;

import pg.mborzyszkowski.petrinet.Direction;
import pg.mborzyszkowski.petrinet.PetriNet;
import pg.mborzyszkowski.petrinet.Place;
import pg.mborzyszkowski.petrinet.Transaction;

public class Main {

    public static void main(String[] args) {
        PetriNet petriNet = new PetriNet();
        Place s = petriNet.addPlace("S", 999);
        Transaction infection = petriNet.addTransaction("infection", 0.00025);
        Place i = petriNet.addPlace("I", 1);
        Transaction recovery = petriNet.addTransaction("recovery", 0.1);
        Place r = petriNet.addPlace("R", 0);

        petriNet.addRegular(1, s, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, i, infection, Direction.TO_TRANSACTION);
        petriNet.addRegular(2, i, infection, Direction.TO_PLACE);
        petriNet.addRegular(1, i, recovery, Direction.TO_TRANSACTION);
        petriNet.addRegular(1, r, recovery, Direction.TO_PLACE);

        System.out.println(petriNet);
    }
}
