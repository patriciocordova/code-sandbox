package code.structures;

public class BTree<T extends Comparable<T>> {

	public static void main(String[] args) {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(1);
		btree.add(3);
		btree.add(5);
		btree.add(7);
		btree.add(2);
		btree.add(4);
		btree.add(6);
		btree.inOrder();
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
		if(add.compareTo(value) > 0){
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
}
