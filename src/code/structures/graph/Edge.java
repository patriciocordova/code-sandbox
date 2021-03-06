package code.structures.graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
	Vertex<T> a;
	Vertex<T> b;
	String pair;
	
	public Edge(Vertex<T> a, Vertex<T> b) {
		if(a.compareTo(b)<0){
			this.a = a;
			this.b = b;
			pair = a+"|"+b;
		}else{
			this.a = b;
			this.b = a;
			pair = b+"|"+a;
		}
	}
	
	@Override
	public int compareTo(Edge<T> e) {
		return pair.compareToIgnoreCase(e.pair);
	}
}
