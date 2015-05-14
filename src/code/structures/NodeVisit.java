package code.structures;

public class NodeVisit<T> {
	Node<T> node;
	NodeVisit<T> next;
	boolean visited;
	
	public NodeVisit(Node<T> node) {
		this.node = node;
		this.visited = false;
	}
}
