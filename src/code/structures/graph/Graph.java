package code.structures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
		g.join(1,2);
		g.join(2,4);
		g.join(2,3);
		g.join(4,3);
		g.join(1,5);
		g.join(5,3);
		g.depthSearch(4);
	}
	
	public void depthSearch(T element){
		Vertex<T> start = findVertex(new Vertex<T>(element));
		if(start!=null){
			dfs(start);
			for (Vertex<T> vertex : verteces) {
				vertex.visited = false;
			}
		}
	}
	
	public void breadthSearch(T element){
		Vertex<T> start = findVertex(new Vertex<T>(element));
		if(start!=null){
			bfs(start);
			for (Vertex<T> vertex : verteces) {
				vertex.visited = false;
			}
		}
	}
	
	public void bfs(Vertex<T> vertex){
		Queue<Vertex<T>> queue=new LinkedList<>();
		System.out.println(vertex.value);
		vertex.visited = true;
		queue.add(vertex);
		
		while(!queue.isEmpty()){
			Vertex<T> queued = queue.poll();
			for (Vertex<T> adjacent : queued.adjacencies) {
				if(!adjacent.visited){
					System.out.println(adjacent.value);
					adjacent.visited = true;
					queue.add(adjacent);
				}
			}
		};
	}
	
	public void dfs(Vertex<T> vertex){
		System.out.println(vertex.value);
		vertex.visited = true;
		for (Vertex<T> adjacent : vertex.adjacencies) {
			if(!adjacent.visited){
				dfs(adjacent);
			}
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
		System.out.println(vertex.value);
		vertex.visited = true;
		for (Vertex<T> adjacent : vertex.adjacencies) {
			if(!adjacent.visited){
				dfsSearch(adjacent);
			}
		}
	}
	
	public void join(T a, T b){
		if(a.compareTo(b) == 0){
			 return;
		}
		
		Vertex<T> vertexA = addVertex(a);
		Vertex<T> vertexB = addVertex(b);
		addEdge(vertexA, vertexB);
	}
	
	public Edge<T> addEdge(Vertex<T> a, Vertex<T> b){
		Edge<T> edge = findEdge(new Edge<>(a,b));
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
