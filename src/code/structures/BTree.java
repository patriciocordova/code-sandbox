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
		btree.print();
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
	
	public ArrayList<Integer[]> treeLayers;
	
	public void layerizeTree(BTree tree, int level, int position){
		addElementLayer(tree,level,Integer.parseInt(tree.value.toString()),position);
		if(tree.left!=null){
			layerizeTree(tree.left,level+1,(position*2));
		}
		if(tree.right!=null){
			layerizeTree(tree.right,level+1,(position*2)+1);
		}
	}
	
	public void addElementLayer(BTree tree, int level, int value, int position){
		int maxLeafs = (int) Math.pow(2,level);
		// Create new ArrayList array element after reaching a new level in the tree.
		if(treeLayers.size() < level+1){
			treeLayers.add(level,new Integer[maxLeafs]);
		}
		treeLayers.get(level)[position] = value;
		//System.out.println(level + "," + position + " " + value);
	}
	
	public void print(){
		treeLayers = new ArrayList<>();
		layerizeTree(this,0,0);
		int maxTreeWidth = (int) Math.pow(2,treeLayers.size());
		String elementsLine,branchesLine,spacing,spacingMinusOne;
		
		for(int i=0;i<treeLayers.size();i++){
			Integer[] layer = treeLayers.get(i);
			int layerSpace = maxTreeWidth / layer.length;
			spacing = new String(new char[layerSpace/2]).replace("\0", " ");
			spacingMinusOne = spacing.substring(0,spacing.length()-1);
			elementsLine="";
			branchesLine="";
			for(int j = 0;j<layer.length;j++){
				String branchDirection = (j%2 == 0)?"/":"\\";
				if(layer[j]!=null){
					branchesLine += spacing + branchDirection + spacingMinusOne;
					elementsLine += spacing + layer[j] + spacingMinusOne;
				}
				else{
					branchesLine += " " + spacing + spacingMinusOne;
					elementsLine += " " + spacing + spacingMinusOne;
				}
			}
			
			System.out.println(branchesLine + "\n" +elementsLine);
		}
	}
}
