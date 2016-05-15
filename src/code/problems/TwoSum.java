package code.leetcode;
import java.util.Arrays;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		int sum = target-1,index1=0,index2=0;
		for(int i=0; i<nums.length; i++){
			int num1 = nums[i];
			if(num1>target){
				continue;
			}
			for(int j=i+1; j<nums.length; j++){
				int num2 = nums[j];
				sum = num1 + num2;
				if(num2>target || sum > target){
					continue;
				}
				
				if(sum == target){
					index1 = i;
					index2 = j;
					i = nums.length;
					break;
				}
			}
		}
		
		return new int[]{index1,index2};
    }
}
