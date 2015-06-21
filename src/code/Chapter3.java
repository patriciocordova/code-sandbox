package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Chapter3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> disks = new ArrayList<Integer>();
		disks.add(4);
		disks.add(3);
		disks.add(2);
		disks.add(1);
		Chapter3 c3 = new Chapter3();
		c3.addDisks(disks, c3.towerA);
		c3.move(c3.towerA,c3.towerC,c3.towerB);
		//c3.move(c3.towerB,c3.towerC,c3.towerA);
		System.out.println("");
	}
	
	public Stack<Integer> towerA;
	public Stack<Integer> towerB;
	public Stack<Integer> towerC;
	
	public Chapter3(){
		towerA = new Stack<>();
		towerB = new Stack<>();
		towerC = new Stack<>();
	}
	
	
	/*
	In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
	different sizes which can slide onto any tower. The puzzle starts with disks sorted
	in ascending order of size from top to bottom (i.e., each disk sits on top of an
	even larger one). You have the following constraints:
	(1) Only one disk can be moved at a time.
	(2) A disk is slid off the top of one tower onto the next tower.
	(3) A disk can only be placed on top of a larger disk.
	Write a program to move the disks from the first tower to the last using stacks.
	*/
	public void move(Stack<Integer> start, Stack<Integer> finish, Stack<Integer> pivot) {
		while(!start.isEmpty()){
			if(finish.isEmpty() || (finish.peek() > start.peek())){
				finish.push(start.pop());
			}else{
				move(finish,pivot,start);
			}
			printTower(towerA, 4, 4);
			printTower(towerB, 4, 4);
			printTower(towerC, 4, 4);
			System.out.println("****************");
		}
	}
	
	public void addDisks(List<Integer> disks, Stack<Integer> tower) {
		for (Integer disk : disks) {
			tower.push(disk);
		}
	}
	
	public void printTower(Stack<Integer> tower, int numElements, int maxSize) {
		String print = "";
		int numRows = 0;
		for (Integer integer : tower) {
			numRows++;
			int offset = maxSize - integer;
			String spacing = new String(new char[offset]).replace("\0", " ");
			String halfDisk = new String(new char[integer]).replace("\0", "_");
			print = spacing + halfDisk + "|" + halfDisk + spacing + "\n" + print;
		}
		String newRow = "";
		if(numRows<numElements){
			int rowsLeft = numElements - numRows;
			String spacing = new String(new char[maxSize]).replace("\0", " ");
			newRow = new String(new char[rowsLeft]).replace("\0", spacing + "|"+ spacing + "\n");
		}
		System.out.println(newRow + print + "=======" + "\n");
	}
}
