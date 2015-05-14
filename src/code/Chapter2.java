package code;

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
		lista.addElement(3);
		lista.addElement(1);
		System.out.println(findLoop(lista).element);
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
