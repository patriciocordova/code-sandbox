package code.structures;

public class Node<T> {
	public Node next;
	public T element;
	
	public Node(T element){
		this.element = element;
	}
	
	@Override
	public String toString(){
		return element.toString();
	}
}
