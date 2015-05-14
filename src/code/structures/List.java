package code.structures;

public class List<T> {
	Node<T> start;
	Node<T> end;
	
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
}
