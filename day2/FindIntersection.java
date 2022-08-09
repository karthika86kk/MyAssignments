package week1.day2;

import java.util.Arrays;

public class FindIntersection {
	public static void main(String[] args) {
		int[] arr1 = {3,2,11,4,6,7};
		int[] arr2 = {1,2,8,4,9,7};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int length1 = arr1.length;
		int length2 = arr2.length;
		for (int i=0; i<length1; i++)
		{
			for(int j=0; j< length2;  j++)
			{
				if(arr1[j] == arr2[i])
				{
					System.out.println(arr1[j]);
				}
			}
		}
	}
	

}
