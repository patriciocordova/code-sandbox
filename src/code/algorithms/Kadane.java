package code.algorithms;

public class Kadane {

	public static void main(String[] args) {
		Kadane kadane = new Kadane();
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int max_sum = kadane.maxSubArraySum(a, a.length);
		System.out.println(max_sum);
	}

	private int max(int x, int y) {
		return (y > x) ? y : x;
	}

	private int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0], i;
		int curr_max = a[0];

		for (i = 1; i < size; i++) {
			curr_max = max(a[i], curr_max + a[i]);
			max_so_far = max(max_so_far, curr_max);
		}
		return max_so_far;
	}
}
