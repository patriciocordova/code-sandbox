package code.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanoiTowers {

	public static void main(String[] args) {
		List<Integer> disks = new ArrayList<Integer>();
		disks.add(7);
		disks.add(6);
		disks.add(5);
		disks.add(4);
		disks.add(3);
		disks.add(2);
		disks.add(1);
		HanoiTowers hanoiTowers = new HanoiTowers();
		hanoiTowers.addDisks(disks, "A");
		hanoiTowers.solve("A","C","B",disks.size());
	}
	
	public Stack<Integer> towerA;
	public Stack<Integer> towerB;
	public Stack<Integer> towerC;
	public int numDisks;
	public int maxDisk;
	public int cont;
	
	public HanoiTowers(){
		towerA = new Stack<>();
		towerB = new Stack<>();
		towerC = new Stack<>();
		numDisks = 0;
		maxDisk = 0;
		cont = 0;
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
	public void solveTowers(Stack<Integer> start, Stack<Integer> finish, Stack<Integer> pivot, int mover) {
		if(mover == 1){
			if(finish.isEmpty() || finish.peek() > start.peek()){
				finish.push(start.pop());
				printTowers("");
			}else{
				solveTowers(finish,pivot,start,mover);
			}
		}else{
			solveTowers(start,pivot,finish,mover-1);
			solveTowers(start,finish,pivot,1);
			solveTowers(pivot,finish,start,mover-1);
		}
	}
	
	public void solve(String start, String finish, String pivot, int numDisks) {
		Stack<Integer> startT = getTowerByLetter(start);
		Stack<Integer> finishT = getTowerByLetter(finish);
		Stack<Integer> pivotT = getTowerByLetter(pivot);
		solveTowers(startT, finishT, pivotT, numDisks);
	}
	
	public Stack<Integer> getTowerByLetter(String letter){
		switch (letter) {
		case "A":
			return towerA;
			break;
		case "B":
			return towerB;
			break;
		case "C":
			return towerC;
			break;
		default:
			return null;
			break;
		}
	}
	
	public void addDisks(List<Integer> disks, String towerLetter) {
		Stack<Integer> tower = getTowerByLetter(towerLetter);
		
		for (Integer disk : disks) {
			tower.push(disk);
			numDisks++;
			if(disk > maxDisk){
				maxDisk = disk;
			}
		}
	}
	
	public String[] getTowerDrawArray(Stack<Integer> tower, int numElements, int maxSize) {
		int numRows = 0;
		String[] bottomRows = new String[numElements];
		String spacing = new String(new char[numElements]).replace("\0", " ");
		String halfDisk = spacing + "|" + spacing;
		for(int i=0;i<numElements;i++){
			bottomRows[i] = halfDisk;
		}
		for (Integer integer : tower) {
			int offset = maxSize - integer;
			spacing = new String(new char[offset]).replace("\0", " ");
			halfDisk = new String(new char[integer]).replace("\0", "_");
			bottomRows[numElements-numRows-1] = spacing + halfDisk + integer + halfDisk + spacing;
			numRows++;
		}
		return bottomRows;
	}
	
	public void printTowers(String indent){
		String[] tA = getTowerDrawArray(towerA, numDisks, maxDisk);
		String[] tB = getTowerDrawArray(towerB, numDisks, maxDisk);
		String[] tC = getTowerDrawArray(towerC, numDisks, maxDisk);
		
		for(int i =0;i<numDisks;i++){
			System.out.println(indent + tA[i] + " " + tB[i] + " " + tC[i]);
		}
		
		String spacing = new String(new char[((numDisks*2)+2)*3]).replace("\0", "=");
		System.out.println(spacing);
	}
}
