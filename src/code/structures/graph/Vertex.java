package code.structures.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {
	T value;
	boolean visited;
	ArrayList<Vertex<T>> adjacencies;
	
	public Vertex(T element){
		this.value = element;
		boolean visited = false;
		this.adjacencies = new ArrayList<Vertex<T>>();
	}
	
	public void addAdjacency(Vertex<T> v){
		int index = Collections.binarySearch(adjacencies, v);
		if(index == -1){
			adjacencies.add(v);
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