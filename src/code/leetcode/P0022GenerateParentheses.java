package code.leetcode;

import java.util.LinkedList;
import java.util.List;

public class P0022GenerateParentheses {
	public static void main(String args[]){
		P0022GenerateParentheses gp = new P0022GenerateParentheses();
		gp.generateParenthesis(3);
	}
	
	public List<String> generateParenthesis(int n) {
		List<String> list = new LinkedList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public void backtrack(List<String> list, String str, int open, int close, int max){

		if(str.length() == max*2){
			list.add(str);
			return;
		}

		if(open < max)
			backtrack(list, str+"(", open+1, close, max);
			if(close < open)
				backtrack(list, str+")", open, close+1, max);
	}
}
