package week1.day1;

public class NegativeToPositive {
	public static void main(String[] args) {
		int num= -25;
				if(num<0) {
					num=num-num-num;
					System.out.println("Converted Positive no. is :" +num);
					
				}
				else 
				{
					System.out.println(num+ "is a Positive no. only");
				}
	}

}
