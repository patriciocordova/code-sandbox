package code.structures;

import java.util.Iterator;

public class ListVisit<T> implements Iterator {
	NodeVisit<T> start;
	NodeVisit<T> current;
	NodeVisit<T> end;
	
	public void addElement(Node<T> node) {
		if(start == null){
			start = new NodeVisit(node);
			current = start;
		}else{
			if(end == null){
				start.next = new NodeVisit(node);
				end = start.next;
			}else{
				end.next = new NodeVisit(node);
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
	public NodeVisit next() {
		if(current == null){
			current = start;
		}else{
			current = current.next;
		}
		return current;
	}
	
	
}
