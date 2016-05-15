package code.leetcode;

import java.io.*;
import java.util.*;

public class ManhattanDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = 0;
        int[][] matrix = null;
        boolean noMatrix = true;
        for(int i = 0; i < n; i++) {
        	String row = sc.nextLine();
        	String[] numbers = row.split(" ");
        	if(noMatrix){
        		m = numbers.length;
        		matrix = new int[n][m];
        		noMatrix = false;
        	}
            for(int j=0;j<m;j++){
            	matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        int k = Integer.parseInt(sc.nextLine());
		boolean result = checkDistanceWithinK(matrix,k);
		if(result){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
	
	public static boolean checkDistanceWithinK(int[][] matrix, int k) {
		int n = matrix.length;
		int m = matrix[0].length;
		//k = Math.min(k, n*m);
		Map<Integer, LinkedList<int[]>> elements = new HashMap<Integer, LinkedList<int[]>>();
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				int currentElement = matrix[i][j];
				if(elements.containsKey(currentElement)){
					List<int[]> positions = elements.get(currentElement);
					ListIterator iterator = positions.listIterator();
					while(iterator.hasNext()){
						int[] position = (int[])iterator.next();
						int mDistance = Math.abs(i - position[0])+Math.abs(j - position[1]);
						if(mDistance <= k){
							return true;
						}
					}
					elements.get(currentElement).add(new int[]{i, j});
				}else{
					elements.put(currentElement, new LinkedList<int[]>());
					elements.get(currentElement).add(new int[]{i, j});
				}
			}
		}
		return false;
	}
	
	public static boolean checkDuplicateWithinK(int[][] mat, int k){
		class Cell{
			int row;
			int col;
			public Cell(int r, int c){
				this.row = r;
				this.col = c;
			}
		}
		
		int n = mat.length;
		int m = mat[0].length;
		k = Math.min(k, n*m);
		
		//map from distance to cell postions of the matrix
		Map<Integer, Set<Cell>> slidingWindow = new HashMap<Integer, Set<Cell>>();
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(slidingWindow.containsKey(mat[i][j])){
					for(Cell c : slidingWindow.get(mat[i][j])){
						int manhattanDist = Math.abs(i - c.row)+Math.abs(j - c.col);
						
						if(manhattanDist <= k){
							return true;
						}
						
						if(i - c.row > k){
							slidingWindow.remove(c);
						}
					}
					
					slidingWindow.get(mat[i][j]).add(new Cell(i, j));
				}
				else{
					slidingWindow.put(mat[i][j], new HashSet<Cell>());
					slidingWindow.get(mat[i][j]).add(new Cell(i, j));
				}
			}
		}
		
		return false;
	}
}
