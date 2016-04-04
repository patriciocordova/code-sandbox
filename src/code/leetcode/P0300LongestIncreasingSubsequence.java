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
		int[] array = {0,8,4,-2,12,2,10,6,14,1,9,5,13,3,11,7,15};
		lengthOfLIS(array);
	}
	
	public static int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            //System.out.println("dp["+i+"]="+x + " \tlen:" + len);
            if(i == len) len++;
        }

        return len;
    }
}
