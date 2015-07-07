package code.structures.graph;

import java.util.ArrayList;

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
		g.addVertex(1);
	}
	
	public void connect(T a, T b){
		if(a.compareTo(b) == 0){
			 return;
		}
		
		Vertex<T> vertexA = null;
		Vertex<T> vertexB = null;
		for (Vertex<T> v : verteces) {
			if(a.compareTo(v.element)==0){
				vertexA = v;
			}
			if(b.compareTo(v.element)==0){
				vertexB = v;
			}
			if(vertexA != null && vertexB != null){
				break;
			}
		}
		
		if(vertexA == null){
			vertexA = addVertex(a);
		}
		
		if(vertexB == null){
			vertexB = addVertex(b);
		}
		
		
	}
	
	public Vertex<T> addVertex(T element){
		Vertex<T> vertex = new Vertex<>(element);
		int vertexIndex = verteces.indexOf(vertex);
		if(vertexIndex != -1){
			return verteces.get(vertexIndex);
		}else{
			verteces.add(vertex);
			return vertex;
		}
	}
	
	public Edge<T> addEdge(Vertex<T> a, Vertex<T> b) {
		Edge<T> edgeAB = new Edge<>(a, b);
		for (Edge<T> e : edges) {
			if(e.compareTo(edgeAB) == 0){
				return e;
			}
		}
		
		edges.add(edgeAB);
		return edgeAB;
	}
}
