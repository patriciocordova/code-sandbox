package code.structures.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class Graph<T extends Comparable<T>> {
	HashMap<T,Vertex<T>> verteces;
	ArrayList<Edge<T>> edges;
	
	public Graph() {
		verteces = new HashMap<>();
		edges = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.connect(1,2);
		g.connect(2,4);
		g.connect(2,3);		
		g.dfs(1);
	}
	
	public void dfs(T element){
		Vertex<T> start = verteces.get(element);
		if(start!=null){
			dfsSearch(start);
		}
	}
	
	public void dfsSearch(Vertex<T> vertex){
		System.out.println(vertex.value);
		vertex.visited = true;
		for (Entry<T, Vertex<T>> adjacent : vertex.adjacencies.entrySet()) {
			if(!adjacent.getValue().visited){
				dfsSearch(adjacent.getValue());
			}
		}
	}
	
	public void connect(T a, T b){
		if(a.compareTo(b) == 0){
			 return;
		}
		
		Vertex<T> vertexA = addVertex(a);
		Vertex<T> vertexB = addVertex(b);
		addEdge(vertexA, vertexB);
	}
	
	public Edge<T> addEdge(Vertex<T> a, Vertex<T> b){
		Edge<T> edge = findEdge(new Edge(a,b));
		if(edge != null){
			return edge;
		}else{
			edge = new Edge<>(a, b);
			a.addAdjacency(b);
			b.addAdjacency(a);
			edges.add(edge);
			return edge;
		}
	}
	
	public Vertex<T> addVertex(T element){
		Vertex<T> vertex = findVertex(element);
		if(vertex != null){
			return vertex;
		}else{
			verteces.put(element,new Vertex<T>(element));
			return vertex;
		}
	}
	
	public Edge<T> findEdge(Edge<T> e){
		int index = Collections.binarySearch(edges, e);
		if(index > 0){
			return edges.get(index);
		}
		return null;
	}
	
	public Vertex<T> findVertex(T element){
		return verteces.get(element);
	}
}
