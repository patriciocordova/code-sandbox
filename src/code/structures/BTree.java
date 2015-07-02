package code.structures;

public class BTree<T> {

	public static void main(String[] args) {
		BTree<Integer> btree = new BTree<>(2);
		btree.add(1);
		btree.add(3);
		btree.add(5);
		btree.add(7);
		btree.add(2);
		btree.add(4);
		btree.add(6);
		btree.postOrder();
	}
	
	Integer value;
	BTree<T> left;
	BTree<T> right;
	
	public BTree(Integer value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void add(Integer add){
		if(add > value){
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
			left.inOrder();
		}
		if(right!=null){
			right.inOrder();
		}
	}
	
	public void postOrder(){
		System.out.println(value);
		if(left!=null){
			left.inOrder();
		}
		if(right!=null){
			right.inOrder();
		}
	}
}
