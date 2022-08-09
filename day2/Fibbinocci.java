package week1.day2;

public class Fibbinocci {
	public static void main(String[] args) {
		int n=11 , firstNo= 0, secondNo= 1;
		for( int i=1; i<= n; i++)
		{
			System.out.println(firstNo);
			int nextNo = firstNo + secondNo;
		    firstNo = secondNo;
		    secondNo = nextNo;
		}
		
	}

}
