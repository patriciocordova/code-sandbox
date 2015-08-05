package code.structures;

import java.util.Iterator;

public class NodeList<T> implements Iterator {
	Node<T> start;
	Node<T> current;
	Node<T> end;
	boolean traveled;
	
	public NodeList() {
		traveled = false;
	}
	
	public void addElement(T element) {
		if(start == null){
			start = new Node<T>(element);
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
		if(current != null){
			return true;
		}else{
			if(traveled == false){
				if(start!=null){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Node<T> next() {
		if(current == null && traveled == false){
			current = start;
			traveled = true;
		}
		Node<T> toReturn = current;
		current = (current != null)? current.next : null;
		return toReturn;
	}
	
	public void rewind(){
		current = null;
		traveled = false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
