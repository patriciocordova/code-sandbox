package code.structures.graph;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> {
	T element;
	ArrayList<Edge<T>> edges;
	
	public Vertex(T element){
		this.element = element;
		this.edges = new ArrayList<>();
	}
}
