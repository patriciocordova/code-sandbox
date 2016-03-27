package code.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */

public class P0003LongestSubstring {

	public static void main(String[] args) {
		P0003LongestSubstring ls = new P0003LongestSubstring();
		System.out.println(ls.lengthOfLongestSubstring("abcadefbgahiafgf"));
		System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(ls.lengthOfLongestSubstring("bbbbbb"));
		System.out.println(ls.lengthOfLongestSubstring(""));
	}
	
	public int lengthOfLongestSubstring(String s) {
		HashMap<String,Integer> letters = new HashMap<String,Integer>();
		int start = 0, max = 0, next = 0, currentLength = 0;
		String letter = "";
		
		for(int i=0;i<s.length();i++){
			letter = String.valueOf(s.charAt(i));
			if(letters.containsKey(letter)){
				next = letters.get(letter) + 1;
				if(next > start){
					start = next;
				}
			}
			letters.put(letter, i);
			currentLength = i - start + 1;
			if(currentLength>max){
				max = currentLength;
			}
		}
		
		return max;
    }

}
