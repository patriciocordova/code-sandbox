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
}
