package code.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P0040CombinationSumII {

	public static void main(String[] args) {
		P0040CombinationSumII csii = new P0040CombinationSumII();
		csii.combinationSumII(new int[]{10,1,2,7,6,1,5},8);
	}
	
	public List<List<Integer>> combinationSumII(int[] elems, int target){
		Arrays.sort(elems);
		List<List<Integer>> solution = new LinkedList<List<Integer>>();
		generateCombinations(elems, 0, target, new LinkedList<Integer>(), solution);
		System.out.println(solution.toString());
		return solution;
	}

	public void generateCombinations(int[] elems, int start, int target, List<Integer> curr, List<List<Integer>> solution){
		for(int i = start; i < elems.length; i++){
			if (i > start && elems[i] == elems[i-1]) continue;
			if(target == 0){
				solution.add(new LinkedList<Integer>(curr));
				break;
			}
			int number = elems[i];
			if(i < elems.length - 1 && target - number < 0){
				break;
			}
			curr.add(curr.size(), number);
			generateCombinations(elems, i+1, target - number, curr, solution);
			curr.remove(curr.size()-1);
		}
	}
}
