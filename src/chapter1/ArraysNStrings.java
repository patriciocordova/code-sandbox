package chapter1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.sun.corba.se.spi.extension.ZeroPortPolicy;

public class ArraysNStrings {
	public static void main(String args[]){
		System.out.println(zeroeMatrix(new int[][]{{1,2,3,4,4},{12,13,8,0,4},{11,2,15,3,4},{1,0,8,1,4},{1,9,8,1,4}}));
	}
	
	//1.1. Implement an algorithm to determine if a string has all unique characters. What
	//if you cannot use additional data structures?
	public static boolean hasUniqueChars(String input){
		if(input == null) return true;
		HashSet<String> uniques = new HashSet<>();
		for(int i=0;i<input.length();i++){
			if(!uniques.contains(input.charAt(i)+"")){
				uniques.add(input.charAt(i)+"");
			}else{
				return false;
			}
		}
		return true;
	}
	
	//1.1. Implement an algorithm to determine if a string has all unique characters. What
	//if you cannot use additional data structures?
	public static boolean hasUniqueChars2(String input){
		if(input == null) return true;
		boolean[] uniques = new boolean[1000];
		for(int i=0;i<input.length();i++){
			if(!uniques[Character.getNumericValue(input.charAt(i))]){
				uniques[Character.getNumericValue(input.charAt(i))] = true;
			}else{
				return false;
			}
		}
		return true; 
	}
	
	//1.3 Given two strings, write a method to decide if one is a permutation of the other.
	public static boolean isPermutation(String original, String permutation){
		if(original == null && permutation == null) return true;
		if((original == null && permutation != null) || (original != null && permutation == null)) return false;
		if(original.length() != permutation.length()) return false;
		
		HashMap<String, int[]> together = new HashMap<>();
		
		for(int i=0;i<original.length();i++){
			String charAt = original.charAt(i)+"";
			if(!together.containsKey(charAt)){
				together.put(charAt, new int[]{1,0});
			}else{
				int[] both = together.get(charAt);
				both[0] = both[0]+1;
				together.put(charAt, both);
			}
		}
		
		for(int i=0;i<permutation.length();i++){
			String charAt = permutation.charAt(i)+"";
			if(!together.containsKey(charAt)){
				return false;
			}else{
				int[] both = together.get(charAt);
				both[1] = both[1]+1;
				together.put(charAt, both);
			}
		}
		
		for (int[] both : together.values() ) {
			if(both[0] != both[1]){
				return false;
			}
		}
		
		return true;
	}
	
	
	//1.4 Write a method to replace all spaces in a string with'%20'. You may assume that
	//the string has sufficient space at the end of the string to hold the additional
	//characters, and that you are given the "true" length of the string. (Note: if implementing
	//in Java, please use a character array so that you can perform this operation
	//in place.)
	//EXAMPLE
	//Input: "Mr John Smith
	//Output: "Mr%20Dohn%20Smith"
	public static String replaceByPer20(String input){
		if(input == null) return "%20";
		
		char[] string = input.toCharArray();
		
		for (int i=0;i<string.length;i++) {
			if(string[i] == ' '){
				string[i] = '%';
				for(int j=string.length - 1;j>i+2;j--){
					if(j<string.length){
						string[j] = string[j-2];
					}
				}
				if(i+1 < string.length){
					string[i+1] = '2';
				}
				if(i+2 < string.length){
					string[i+2] = '0';
				}
				i=i+2;
			}
		}
		
		return new String(string);
	}
	
	//1.5 Implement a method to perform basic string compression using the counts
	//of repeated characters. For example, the string aabcccccaaa would become
	//a2blc5a3. If the "compressed" string would not become smaller than the original
	//string, your method should return the original string.
	public static String compress(String input) {
		if(input == null || input.compareTo("")==0) return input;
		StringBuffer compressedBuffer = new StringBuffer();
		int currentCount = 1;
		String current, next;
		
		for (int i = 0; i < input.length(); i++) {
			current = input.charAt(i)+"";
			next = (i+1 < input.length())?input.charAt(i+1)+"":"";
			if(current.compareToIgnoreCase(next)==0){
				currentCount++;
			}else{
				compressedBuffer.append(current);
				compressedBuffer.append(currentCount);
				currentCount=1;
			}
		}
		
		String compressed = compressedBuffer.toString();
		return (compressed.length() < input.length())? compressed : input;
	}
	
	//1.6 Given an image represented by an NxN matrix, where each pixel in the image is
	//4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
	//place?
	public static int[][] rotate(int[][] image) {
		int previous,keep;
		int k=0,x,y,newLength = image.length;
		while(k<newLength){
			newLength = newLength - k - 1;
			for (int m = 0; m < newLength; m++) {
				x = k;
				y = k;
				previous = image[x][y];
				for (int j = 0; j < newLength; j++) {
					keep = image[x][y+1];
					image[x][y+++1] = previous;
					previous = keep;
				}
				y=newLength+k;
				for (int j = 0; j < newLength; j++) {
					keep = image[x+1][y];
					image[x+++1][y] = previous;
					previous = keep;
				}
				x=newLength+k;
				for (int j = 0; j < newLength; j++) {
					keep = image[x][y-1];
					image[x][y---1] = previous;
					previous = keep;
				}
				y=k;
				for (int j = 0; j < newLength; j++) {
					keep = image[x-1][y];
					image[x---1][y] = previous;
					previous = keep;
				}
			}
			k++;
		}
		
		return image;
	}
	
	
	// Prints a matrix of NxN size in a visible/understandable way.
	public static void printMatrix(int[][] matrix) {
		int length = matrix.length;
		String size = length*length + "";
		
		
		for(int i=0;i<matrix.length;i++){
			for (int j = 0; j < matrix.length; j++) {
				int repeat = size.length() - (matrix[i][j]+"").length();				
				System.out.print(new String(new char[repeat]).replace("\0", " ") + matrix[i][j]);
				if(j+1<matrix.length){
					System.out.print("|");
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	//1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row
	//and column are set to 0.
	public static int[][] zeroeMatrix(int[][] matrix) {
		printMatrix(matrix);
		
		//Get the zero positions.
		ArrayList<int[]> zeroPositions=new ArrayList<>();
		for(int i=0;i<matrix.length;i++){
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j]==0){
					zeroPositions.add(new int[]{i,j});
				}
			}
		}
		
		//Get the unique rows and columns.
		TreeSet<Integer> rows = new TreeSet<>();
		TreeSet<Integer> cols = new TreeSet<>();
		for (Iterator iterator = zeroPositions.iterator(); iterator.hasNext();) {
			int[] position = (int[]) iterator.next();
			rows.add(position[0]);
			cols.add(position[1]);
		}
		
		//Zero rows.
		for(int i=0;i<rows.size();i++){
			for (Iterator iterator = rows.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				for (int j = 0; j < matrix[integer].length; j++) {
					matrix[integer][j] = 0;
				}
			}
		}
		
		//Zero columns.
		for(int i=0;i<cols.size();i++){
			for (Iterator iterator = cols.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][integer] = 0;
				}
			}
		}
		
		printMatrix(matrix);
		return matrix;
	}
}
