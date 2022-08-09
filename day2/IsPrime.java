package week1.day2;

public class IsPrime {
	public static void main(String[] args) {
		int num=29, i ,count=0;
		for(i=2; i<num; i++)
		{
			if(num%i == 0)
			{
				count++;
				break;
			}
		}
		if(count==0)
			System.out.println("\n It is a Prime Number");
		else
			System.out.println("\n It is not a Prime Number");
	}

}
