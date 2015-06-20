package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

import code.structures.Node;
import code.structures.NodeList;

public class Chapter2 {
	public static void main(String[] args) {
		NodeList<Integer> list = new NodeList();
		list.addElement(1);
		list.addElement(1);
		list.addElement(2);
		list.addElement(2);
		System.out.println(isPalindrome(list));
	}
	
	//2.2 Implement an algorithm to find the kth to last element of a singly linked list.
	public static <T> Node<T> findToLast(NodeList<T> elements,int k) {		
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
	public static <T> NodeList<T> deleteMiddleNode(T element, NodeList<T> list) {
		if(element == null) return null;
		
		Node<T> firstPointer = findNode(element, list);
		if(firstPointer == null) return null;
		Node<T> secondPointer = firstPointer.next;
		while(secondPointer!=null){
			firstPointer.element = secondPointer.element;
			if(secondPointer.next == null){
				firstPointer.next = null;
				break;
			}
			firstPointer = secondPointer;
			secondPointer = secondPointer.next;
		}
		
		return list;
	}
	
	public static <T> Node<T> findNode(T element, NodeList<T> lista){
		lista.rewind();
		Node<T> currentNode;
		while(lista.hasNext()){
			currentNode = lista.next();
			if(currentNode.element == element){
				return currentNode;
			}
		}
		return null;
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
	public static <T> Node<T> findLoop(NodeList<T> elements) {
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
	
	/*
	 * 2.7 Implement a function to check if a linked list is a palindrome.
	 */
	public static <T> boolean isPalindrome(NodeList<T> elements) {
		elements.rewind();
		Node pointer = elements.next();
		boolean possiblyFoundMiddle = false;
		Stack<Node<T>> firstHalf = new Stack<>();
		
		// Add hypotethical first palindrome half to stack.
		while(pointer!= null){
			firstHalf.add(pointer);
			if(pointer.next != null && ((pointer.next.element==pointer.element) || (pointer.next.next != null && pointer.next.next.element == pointer.element))){
				pointer = (pointer.next.element==pointer.element)?pointer.next:pointer.next.next;
				possiblyFoundMiddle = true;
				break;
			}
			pointer = pointer.next;
		}
		
		// Return true if there is only one element.
		if(firstHalf.size() == 1 && possiblyFoundMiddle == false)
			return true;
		
		//Check if hypotethically second half of palindrome corresponds to first part.
		if(possiblyFoundMiddle){
			Node pop = firstHalf.pop();		
			while(pop!=null && pointer!=null && pop.element == pointer.element){
				if(firstHalf.isEmpty()){
					if(pointer.next == null){
						return true;
					}else{
						return false;
					}
				}
				pop = firstHalf.pop();
				pointer = pointer.next;
			}
		}
		
		return false;
	}
}
