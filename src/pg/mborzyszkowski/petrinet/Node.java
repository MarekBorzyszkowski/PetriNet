package pg.mborzyszkowski.petrinet;

public class Node {
	private String name;

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Node{" +
				"name='" + name + '\'' +
				'}';
	}
}
