package code.structures;

import java.util.Iterator;

public class List<T> implements Iterator {
	Node<T> start;
	Node<T> current;
	Node<T> end;
	
	public void addElement(T element) {
		if(start == null){
			start = new Node<T>(element);
			current = start;
		}else{
			if(end == null){
				start.next = new Node<T>(element);
				end = start.next;
			}else{
				end.next = new Node<T>(element);
				end = end.next;
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		if(current != null) return true;
		return false;
	}

	@Override
	public Node<T> next() {
		Node<T> toReturn = current;
		if(current.next != null){
			current = current.next;
		}
		return toReturn;
	}
}
