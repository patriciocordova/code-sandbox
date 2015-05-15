package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import code.structures.List;
import code.structures.Node;

public class Chapter2 {
	public static void main(String[] args) {
		List<Integer> lista = new List();
		lista.addElement(1);
		lista.addElement(2);
		lista.addElement(3);
		lista.addElement(4);
		lista.addElement(5);
		lista.addElement(6);
		lista.addElement(7);
		lista.addElement(8);
		System.out.println(findToLast(lista,0).element);
	}
	
	//2.2 Implement an algorithm to find the kth to last element of a singly linked list.
	public static <T> Node<T> findToLast(List<T> elements,int k) {		
		ArrayList<Node<T>> numberedElements = new ArrayList<>();
		while(elements.hasNext()){
			Node<T> next = elements.next();
			numberedElements.add(next);
		}
		int returnIndex = numberedElements.size() - k - 1;
		if(returnIndex < 0)
			return null;
		return numberedElements.get(returnIndex);
	}
	
	//2.3 Implement an algorithm to delete a node in the middle of a singly linked list,
	//given only access to that node.
	//EXAMPLE
	//Input: the node c from the linked list a->b->c->d->e
	//Result: nothing is returned, but the new linked list looks like a- >b- >d->e
	public static <T> Node<T> deleteMiddleNode(Node<T> element) {
		if(element == null) return null;
		
		Node<T> firstPointer = element;
		Node<T> secondPointer = element.next;
		while(secondPointer.next!=null){
			firstPointer.element = secondPointer.element;
			firstPointer = secondPointer;
			secondPointer = secondPointer.next;
		}
		
	}
	
	/*
	 * 2.6 Given a circular linked list, implement an algorithm which returns the node at
	 * the beginning of the loop.
	 * DEFINITION
	 * Circular linked list: A (corrupt) linked list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list.
	 * EXAMPLE
	 * Input: A - > B - > C - > D - > E - > C [the same C as earlier]
	 * Output: C
	 */
	public static <T> Node<T> findLoop(List<T> elements) {
		HashSet<T> values = new HashSet<>();
		while(elements.hasNext()){
			Node<T> node = elements.next();
			if(!values.contains(node.element)){
				values.add(node.element);
			}else{
				return node;
			}
		}
		return null;
	}
}
