package code.structures.graph;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {
	T value;
	ArrayList<Vertex<T>> adjacencies;
	
	public Vertex(T element){
		this.value = element;
		this.adjacencies = new ArrayList<>();
	}
	
	@Override
	public int compareTo(Vertex<T> arg0) {
		return value.compareTo(arg0.value);
	}
	
	public String toString(){
		return value.toString();
	}
}