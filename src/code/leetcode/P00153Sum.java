package code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * */
public class P00153Sum {
	public static void main(String[] args){
		P00153Sum threeSum = new P00153Sum();
		threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
	}
	
	public List<List<Integer>> threeSum(int[] A) {
	    List<List<Integer>>res = new ArrayList<List<Integer>>();
	    if (A == null || A.length == 0)
	        return res;
	    Arrays.sort(A);
	    for (int i = 0; i < A.length; i++) {
	        if (i - 1 >= 0 && A[i] == A[i - 1]) continue;// Skip equal elements to avoid duplicates

	        int left = i + 1, right = A.length - 1; 
	        while (left < right) {// Two Pointers
	            int sum = A[i] + A[left] + A[right];
	            if (sum == 0) { 
	                res.add(Arrays.asList(A[i], A[left], A[right]));
	                while (left + 1 < right && A[left] == A[left+1])// Skip equal elements to avoid duplicates
	                    left++;
	                while (right -1 > left && A[right] == A[right-1])// Skip equal elements to avoid duplicates
	                    right--;
	                left++; 
	                right--;
	            } else if (sum < 0) { 
	                left++;
	            } else {
	                right--;
	            }
	        }
	    }
	    return res;
	}
}
