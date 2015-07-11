package code.structures.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import com.sun.security.jgss.ExtendedGSSContext;

public class Graph<T extends Comparable<T>> {
	ArrayList<Vertex<T>> verteces;
	ArrayList<Edge<T>> edges;
	
	public Graph() {
		verteces = new ArrayList<>();
		edges = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.connect(1,2);
		g.connect(2,4);
		g.connect(2,3);
		g.connect(4,3);
		g.connect(1,5);
		g.connect(5,3);
		g.dfs(1);
	}
	
	public void dfs(T element){
		Vertex<T> start = findVertex(new Vertex<T>(element));
		if(start!=null){
			dfsSearch(start);
		}
	}
	
	private Vertex<T> findVertex(Vertex<T> vertex) {
		int index = Collections.binarySearch(verteces, vertex);
		if(index >= 0){
			return verteces.get(index);
		}
		return null;
	}
	
	private Edge<T> findEdge(Edge<T> edge) {
		int index = Collections.binarySearch(edges, edge);
		if(index >= 0){
			return edges.get(index);
		}
		return null;
	}
	
	public void dfsSearch(Vertex<T> vertex){
		vertex.visited = true;
		for (Vertex<T> adjacent : vertex.adjacencies) {
			if(!adjacent.visited){
				dfsSearch(adjacent);
			}
		}
		System.out.println(vertex.value);
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
		Vertex<T> vertex = findVertex(new Vertex<>(element));
		if(vertex != null){
			return vertex;
		}else{
			verteces.add(new Vertex<T>(element));
			return vertex;
		}
	}
}
