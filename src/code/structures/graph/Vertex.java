package code.structures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {
	T value;
	HashMap<T,Vertex<T>> adjacencies;
	
	public Vertex(T element){
		this.value = element;
		this.adjacencies = new HashMap<T, Vertex<T>>();
	}
	
	public void addAdjacency(Vertex<T> b){
		if(!adjacencies.containsKey(b.value)){
			adjacencies.put(b.value,b);
		}
	}
	
	@Override
	public int compareTo(Vertex<T> arg0) {
		return value.compareTo(arg0.value);
	}
	
	public String toString(){
		return value.toString();
	}
}