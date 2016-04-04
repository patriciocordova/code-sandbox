package code.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0046Permutations {

	public static void main(String[] args) {
		P0046Permutations p = new P0046Permutations();
		System.out.println(p.permutations(new int[]{1,2,3}).toString());
	}

	public List<List<Integer>> permutations(int[] elements){
		ArrayList<Integer> list = new ArrayList<Integer>(elements.length);
		for(int i = 0; i < elements.length; i++){
			list.add(elements[i]);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permute(list,new ArrayList<Integer>(),result);
		return result;
	}

	public void permute(List<Integer> list, List<Integer> current, List<List<Integer>> result){
		for(int i = 0; i < list.size(); i++){
			List<Integer> duplicate = new ArrayList<Integer>(list);
			Integer element = duplicate.remove(i);
			current.add(element);
			if(duplicate.size() == 0){
				result.add(new ArrayList<Integer>(current));
			}else{
				permute(duplicate, current, result);
			}
			current.remove(current.size() - 1);
		}
	}
}
