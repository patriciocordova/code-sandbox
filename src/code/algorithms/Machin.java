package code.algorithms;

public class Machin {
	
	public static void main(String[] args) {
		Machin machin = new Machin();
		System.out.println(machin.pi());
	}
	
	private double arctan(double number) {
		double arctan = 0;
		boolean toggle = true;
		for(int i=1;i<=100001;i+=2){
			if(toggle)
				arctan += Math.pow(number, i)/(double)i;
			else
				arctan -= Math.pow(number, i)/(double)i;
			toggle = !toggle;
		}
		return arctan;
	}
	
	private double pi() {
		return 4*4*arctan(1.0/5.0)-4*arctan(1.0/239.0);
	}
}
