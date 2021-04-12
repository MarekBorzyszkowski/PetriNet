package pg.mborzyszkowski.petrinet;

import java.util.*;

public class Transaction extends Node{
	private double parameter;

	private List<Edge> incoming = new ArrayList<>();
	private List<Edge> outgoing = new ArrayList<>();

	public Transaction(String name, double parameter) {
		super(name);
		this.parameter = parameter;
	}
}
