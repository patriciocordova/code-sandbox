package code.structures.graph;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
	Vertex<T> a;
	Vertex<T> b;
	
	public Edge(Vertex<T> a, Vertex<T> b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Edge<T> e) {
		if(a.element.compareTo(e.a.element) == 0 && b.element.compareTo(e.b.element) == 0){
			return 0;
		}else{
			if(b.element.compareTo(e.a.element) == 0 && a.element.compareTo(e.b.element) == 0){
				return 0;
			}else{
				return -1;
			}
		}
	}
}
