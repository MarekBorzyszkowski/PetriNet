package pg.mborzyszkowski.petrinet.generic.edge;

import pg.mborzyszkowski.petrinet.generic.place.Place;
import pg.mborzyszkowski.petrinet.generic.transaction.ITransaction;

public class Edge<PL extends Place> {
	private int valueAttribute;

	private PL place;
	private ITransaction transaction;
	private Direction direction;

	public Edge(int valueAttribute, PL place, ITransaction transaction, Direction direction) {
		this.valueAttribute = valueAttribute;
		this.place = place;
		this.transaction = transaction;
		this.direction = direction;
		if(direction == Direction.TO_PLACE)
			transaction.addOutgoing(this);
		if(direction == Direction.TO_TRANSACTION)
			transaction.addIncoming(this);
	}

	public Edge(PL place, ITransaction transaction, Direction direction) {
		this(1, place, transaction, direction);
	}

	public int getValueAttribute() {
		return valueAttribute;
	}

	public Place getPlace() {
		return place;
	}

	public ITransaction getTransaction() {
		return transaction;
	}

	public Direction getDirection() {
		return direction;
	}

	public boolean canExecute() {
		if(direction.equals(Direction.TO_TRANSACTION))
			return place.getNumberOfTokens().doubleValue() >= this.valueAttribute;
		else if(direction.equals(Direction.TO_PLACE))
			return true;
		else
			return false;
	}

	public void execute() {
		if(direction.equals(Direction.TO_TRANSACTION))
			place.setNumberOfTokens(place.getNumberOfTokens().doubleValue() - valueAttribute);
		if(direction.equals(Direction.TO_PLACE))
			place.setNumberOfTokens(place.getNumberOfTokens().doubleValue() + valueAttribute);
	}

	@Override
	public String toString() {
		return "value=" + valueAttribute +
				", place=" + place.getName() +
				", transaction=" + transaction.getName() +
				", direction=" + direction ;
	}

}
