package code.leetcode;

import java.util.Arrays;


/*
 * 300. Longest Increasing Subsequence
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class P0300LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] array = {0,8,8,4,-2,12,2,10,6,14,1,9,5,13,3,11,7,15};
		P0300LongestIncreasingSubsequence lis = new P0300LongestIncreasingSubsequence();
		System.out.println(lis.lis(array));
	}
	
	public int lis(int[] sequence){
		int[] solution = new int[sequence.length];
		int max = 0;
		int position = 0;
		for(int i=0;i<sequence.length;i++){
			position = Arrays.binarySearch(solution, 0, max, sequence[i]);
			if(position < 0){
				position = -(position+1);
			}
			if(max == position || solution[position] > sequence[i]){
				solution[position] = sequence[i];
			}
			if(position+1>max){
				max++;
			}
		}
		return max;
	}
}
