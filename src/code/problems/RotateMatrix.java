package code.leetcode;

import java.util.Scanner;

public class RotateMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int y = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[y][y];
        for(int i = 0; i < y; i++) {
        	String row = sc.nextLine();
        	String[] numbers = row.split(" ");
        	if(numbers.length > y || numbers.length < y){
        		System.out.println("ERROR");
        		System.exit(0);
        	}
            for(int j=0;j<y;j++){
            	matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        int[][] result = rotate(matrix);
        printMatrix(result);
	}

	public static void printMatrix(int[][] matrix) {
		int y = matrix.length;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] rotateOne(int[][] matrix) {
		int x = matrix.length;
		int y = x;
		int row = 0;
		int col = 0;

		while (row < x && col < y) {

			if (row + 1 == x){
				break;
			}

			int initial = matrix[row + 1][col];
			int current = 0;

			for (int i = col; i < y; i++) {
				current = matrix[row][i];
				matrix[row][i] = initial;
				initial = current;
			}
			row++;

			for (int i = row; i < x; i++) {
				current = matrix[i][y - 1];
				matrix[i][y - 1] = initial;
				initial = current;
			}
			y--;

			if (row < x) {
				for (int i = y - 1; i >= col; i--) {
					current = matrix[x - 1][i];
					matrix[x - 1][i] = initial;
					initial = current;
				}
			}
			x--;

			if (col < y) {
				for (int i = x - 1; i >= row; i--) {
					current = matrix[i][col];
					matrix[i][col] = initial;
					initial = current;
				}
			}
			col++;
		}
		return matrix;
	}
}
