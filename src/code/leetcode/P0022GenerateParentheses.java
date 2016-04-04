package code.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P0022GenerateParentheses {

	public static void main(String[] args) {
		P0022GenerateParentheses gp = new P0022GenerateParentheses();
		System.out.println(gp.generateParenthesis(3).toString());
	}
	
	public List<String> generateParenthesis(int num){
		List<String> result = new LinkedList<String>();
		bracktrackParentheses(0,0,num,"",result);
		return result;
	}
	
	public void bracktrackParentheses(int left, int right, int max, String current, List<String> result){
		if(left < max){
			bracktrackParentheses(left+1, right, max, current + "(", result);
		}
		if(right < max && right < left){
			bracktrackParentheses(left, right+1, max, current + ")", result);
		}
		if(left == right && right == max){
			result.add(current);
		}
	}
}
