package week1.day2;

public class MyCalculator {
	
	public static void main(String[] args) {
		Calculator obj= new Calculator();
		int sum= obj.add(25, 25, 25);
		System.out.println(sum);
		int subraction= obj.sub(50, 20);
		System.out.println(subraction);
		double product= obj.mul(50, 50);
		System.out.println(product);
		float div= obj.div(50, 10);
		System.out.println(div);
	}

}
