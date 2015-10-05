package code.algorithms;

public class GregoryLiebniz {

	public static void main(String[] args) {
		GregoryLiebniz gregoryLiebniz = new GregoryLiebniz();
		System.out.println(gregoryLiebniz.pi());
	}

	private double pi() {
		double pi = 0;
		boolean toggle = true;
		for(int i=1;i<=10000001;i+=2){
			if(toggle)
				pi += 1/(double)i;
			else
				pi -= 1/(double)i;
			toggle = !toggle;
		}
		return pi*4;
	}
}
