package code.structures;

import java.util.ArrayList;

public class BTree<T extends Comparable<T>> {

	public static void main(String[] args) {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(1);
		btree.add(0);
		btree.add(1);
		btree.add(1);
		btree.add(1);
		btree.add(3);
		btree.add(5);
		btree.add(7);
		btree.add(2);
		btree.add(4);
		btree.add(6);
		//btree.inOrder();
		print(btree);
	}
	
	T value;
	BTree<T> left;
	BTree<T> right;
	
	public BTree(T value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void add(T add){
		if(add.compareTo(value) >= 0){
			if(right == null){
				right = new BTree<>(add);
			}else{
				right.add(add);
			}
		}else{
			if(left == null){
				left = new BTree<>(add);
			}else{
				left.add(add);
			}
		}
	}

	public void inOrder(){
		if(left!=null){
			left.inOrder();
		}
		System.out.println(value);
		if(right!=null){
			right.inOrder();
		}
	}
	
	public void preOrder(){
		System.out.println(value);
		if(left!=null){
			left.preOrder();
		}
		if(right!=null){
			right.preOrder();
		}
	}
	
	public void postOrder(){
		System.out.println(value);
		if(left!=null){
			left.postOrder();
		}
		if(right!=null){
			right.postOrder();
		}
	}
	
	public static void preOrder(BTree tree, int level, int posicion){
		addValue(level,Integer.parseInt(tree.value.toString()),posicion);
		if(tree.left!=null){
			preOrder(tree.left,level+1,(posicion*2));
		}
		if(tree.right!=null){
			preOrder(tree.right,level+1,(posicion*2)+1);
		}
	}
	
	public static void addValue(int level,int value, int position){
		int numElements = (int) Math.pow(2,level);
		if(nodes.size() < level+1){
			nodes.add(level,new Integer[numElements]);
		}
		nodes.get(level)[position] = value;
		System.out.println(level + "," + position + " " + value);
	}
	
	public static ArrayList<Integer[]> nodes;
	public static void print(BTree tree){
		nodes = new ArrayList<>();
		preOrder(tree,0,0);
		int max = (int) Math.pow(2,nodes.size());
		String spacing;
		for(int i=0;i<nodes.size();i++){
			Integer[] row = nodes.get(i);
			int space = max / row.length;
			spacing = new String(new char[space/2]).replace("\0", " ");
			System.out.print(spacing);
			String toPrint = spacing;
			for(int j = 0;j<row.length;j++){
				String toAppend = "";
				if(j%2 == 0){
					toAppend = "/";
				}else{
					toAppend = "\\";
				}
				if(row[j]!=null){
					toPrint += row[j] + spacing + spacing.substring(0,spacing.length() - 1);
					System.out.print(toAppend + spacing + spacing.substring(0,spacing.length() - 1));
				}
				else{
					toPrint += " " + spacing + spacing.substring(0,spacing.length() - 1);
					System.out.print(" " + spacing);
					System.out.print(spacing.substring(0,spacing.length() - 1));
				}
			}
			System.out.println();
			System.out.println(toPrint);
		}
	}
}
