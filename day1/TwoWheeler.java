package week1.day1;

public class TwoWheeler {
	int noOfWheels=2;
	short noOfMirrors=2;
	long chassisNumber=23456789L;
	boolean isPunctured= false;
	String bikeName= "Honda";
	double runningKM =230000;
	public static void main(String[] args) {
		
		TwoWheeler tw= new TwoWheeler();
		System.out.println("TwoWheeler Particulars:");
		System.out.println();
		System.out.println("Bikename :" +tw.bikeName);
		System.out.println("KM Driven :" +tw.runningKM);
		System.out.println("No. of Wheels :" +tw.noOfWheels);
		System.out.println("No. of Mirrors :" +tw.noOfMirrors);
		System.out.println("Chasis No. :" +tw.chassisNumber);
		System.out.println("Is Punctured :" +tw.isPunctured);
		
		

		
		
	}

}
