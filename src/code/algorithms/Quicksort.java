package code.algorithms;

public class Quicksort {
	
	public static void main(String[] args) {
		Quicksort quicksort = new Quicksort();
		int[] array = {-2,30,20,-3, 4, -1, -2, 1,30,30,0,30, 5, -3,-10,-11,-12,10,11,12,1,-1,8};
		quicksort.sort(array, 0, array.length-1);
		System.out.println(array);
	}
	
	private void sort(int[] array,int start,int end){
		int m = partition(array,start,start,end);
		if(start<m-1)
			sort(array,start,m-1);
		if(m+1 < end)
			sort(array,m+1,end);
	}
	
	private int partition(int[] array,int i,int j,int m) {
		while(j<m){
			if(array[j] <= array[m]){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
			j++;
		}
		int temp = array[i];
		array[i] = array[m];
		array[m] = temp;
		return i;
	}
}
