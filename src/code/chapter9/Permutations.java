package code.chapter9;

import java.util.ArrayList;

/*
 * 9.5 Write a method to compute all permutations of a string.
 */
public class Permutations {
	public static void main(String[] args) {
		permutations("hola");
	}
	
	public static void permutations(String text) {
		ArrayList<String> letters = new ArrayList<>();
		for(int i=0;i<text.length();i++){
			letters.add(text.charAt(i)+"");
		}
		createPermutations(letters,"");
	}
	
	public static void createPermutations(ArrayList<String> letters, String permutation) {
		if(letters.size() == 0){
			System.out.println(permutation);
			return;
		}
		for(int i=0;i<letters.size();i++){
			String element = letters.remove(i);
			createPermutations(letters, permutation+element);
			letters.add(i, element);
		}
	}
}
