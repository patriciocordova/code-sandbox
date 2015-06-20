package code.tests;

import org.junit.Test;

import code.Chapter2;
import code.Chapter1;
import code.structures.NodeList;
import static org.junit.Assert.*;

public class Chapter2Test {
	@Test
	public void testFindToLast() {
		NodeList<Integer> lista = new NodeList();
		lista.addElement(1);
		lista.addElement(2);
		lista.addElement(3);
		lista.addElement(4);
		lista.addElement(5);
		lista.addElement(6);
		lista.addElement(7);
		lista.addElement(8);
		assertEquals(Chapter2.findToLast(lista,0).element,new Integer(8));
	}
	
	@Test
	public void testDeleteMiddleNode(){
		NodeList<Integer> list = new NodeList();
		list.addElement(1);
		list.addElement(2);
		list.addElement(3);
		list.addElement(4);
		list.addElement(5);
		list.addElement(6);
		list.addElement(7);
		list.addElement(8);
		//assertEquals(deleteMiddleNode(4, list));
	}
	
	@Test
	public void testIsPalindrome(){
		NodeList<Integer> list = new NodeList();
		list.addElement(1);
		list.addElement(2);
		list.addElement(3);
		list.addElement(4);
		list.addElement(3);
		list.addElement(2);
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		list.addElement(2);
		list.addElement(3);
		list.addElement(3);
		list.addElement(2);
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		list.addElement(2);
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		list.addElement(1);
		list.addElement(2);
		assertEquals(Chapter2.isPalindrome(list),false);
		list = new NodeList();
		list.addElement(null);
		assertEquals(Chapter2.isPalindrome(list),true);
		list = new NodeList();
		assertEquals(Chapter2.isPalindrome(list),false);
	}
}
