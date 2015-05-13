package code.structures;

public class List {
	Node start;
	
	public void addElement(int element) {
		if(start == null){
			start = new Node(element);
		}else{
			Node current = start;
			while(current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(new Node(element));
		}
	}
}
