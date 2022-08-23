package orgsystem;

public class AxisBank extends BankInfo{

	public void deposit(int x)
	{
		System.out.println("Current Balance : "+x);
	}
	
	public static void main(String[] args) {
		AxisBank axis = new AxisBank();
		BankInfo bank = new BankInfo();
		axis.saving();
		axis.fixed(4.8);
		axis.deposit(350000);
		bank.deposit(50000);
	}
}
