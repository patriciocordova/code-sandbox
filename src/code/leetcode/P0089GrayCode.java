package code.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P0089GrayCode {

	public static void main(String[] args) {
		P0089GrayCode gc = new P0089GrayCode();
		System.out.println(gc.grayCode(3));
	}
	
	public List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1<<n; i++){
	    	//System.out.println(i);
	    	//System.out.println(Integer.toBinaryString(i >> 1));
	    	//System.out.println();
	    	result.add(i ^ i>>1);
	    }
	    return result;
	}
}
