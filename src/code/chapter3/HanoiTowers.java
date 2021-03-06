package code.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HanoiTowers {

	public Stack<Integer> towerA;
	public Stack<Integer> towerB;
	public Stack<Integer> towerC;
	public int numDisks;
	public int maxDiskSize;
	
	public HanoiTowers(){
		towerA = new Stack<>();
		towerB = new Stack<>();
		towerC = new Stack<>();
		numDisks = 0;
		maxDiskSize = 0;
	}
	
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
		hanoiTowers.solve("A","C","B");
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
				drawTowers();
			}else{
				solveTowers(finish,pivot,start,mover);
			}
		}else{
			solveTowers(start,pivot,finish,mover-1);
			solveTowers(start,finish,pivot,1);
			solveTowers(pivot,finish,start,mover-1);
		}
	}
	
	public void solve(String start, String finish, String pivot) {
		Stack<Integer> startTower = getTowerByLetter(start);
		Stack<Integer> finishTower = getTowerByLetter(finish);
		Stack<Integer> pivotTower = getTowerByLetter(pivot);
		solveTowers(startTower, finishTower, pivotTower, startTower.size());
	}
	
	public Stack<Integer> getTowerByLetter(String letter){
		switch (letter) {
			case "A":
				return towerA;
			case "B":
				return towerB;
			case "C":
				return towerC;
			default:
				return null;
		}
	}
	
	public void addDisks(List<Integer> disks, String letter) {
		Stack<Integer> tower = getTowerByLetter(letter);
		
		for (Integer disk : disks) {
			tower.push(disk);
			numDisks++;
			if(disk > maxDiskSize){
				maxDiskSize = disk;
			}
		}
	}
	
	public String[] getDrawingArray(Stack<Integer> tower) {
		String[] rows = new String[numDisks];
		String spacing = new String(new char[numDisks]).replace("\0", " ");
		String halfDisk = spacing;
		
		for(int i=0;i<numDisks;i++){
			rows[i] = halfDisk + "|" + halfDisk;
		}
		
		int numRows = 0;
		for (Integer diskSize : tower) {
			int blankSpaces = maxDiskSize - diskSize;
			spacing = new String(new char[blankSpaces]).replace("\0", " ");
			halfDisk = new String(new char[diskSize]).replace("\0", "_");
			rows[numDisks-numRows-1] = spacing + halfDisk + diskSize + halfDisk + spacing;
			numRows++;
		}
		return rows;
	}
	
	public void drawTowers(){
		String[] tA = getDrawingArray(towerA);
		String[] tB = getDrawingArray(towerB);
		String[] tC = getDrawingArray(towerC);
		
		for(int i =0;i<numDisks;i++){
			System.out.println(tA[i] + " " + tB[i] + " " + tC[i]);
		}
		
		String separator = new String(new char[((numDisks*2)+2)*3]).replace("\0", "=");
		System.out.println(separator);
	}
}
