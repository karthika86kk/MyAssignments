package week4.assignment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerService {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter username,password and login
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");		
		driver.findElement(By.id("password")).sendKeys("Password#123");		
		driver.findElement(By.id("Login")).click();
		
		
		//click on the learn more option in the Mobile publisher
		
		driver.findElement(By.xpath("//span[text()='Learn More']//parent::button")).click();
		
		//Switch to the next window using Windowhandles.
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> listWindows=new ArrayList<String>(windowHandles);		
		driver.switchTo().window(listWindows.get(1));
		

		//click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//Clilck on Products and Mousehover on Service 
		
		Shadow dom=new Shadow(driver);
		WebElement elementProduct=dom.findElementByXPath("//span[text()='Products']");
		elementProduct.click();		
		WebElement elementService=dom.findElementByXPath("//span[text()='Service']/parent::div");
		Actions act=new Actions(driver);
		act.moveToElement(elementService).build().perform();
		
		// Click on Customer Services
		WebElement elementCustSer =dom.findElementByXPath("//a[text()='Customer Service']");
		elementCustSer.click();

		//Get the names Of Services Available 
		
		List<WebElement> elementServices=driver.findElements(By.xpath("//a[text()='Customer Service']/following-sibling::ul/li"));
		
		System.out.println("=============================");
		System.out.println("Customer Services Available:");
		System.out.println("=============================");
		for(int i=0;i<elementServices.size();i++)
		{
			System.out.println(elementServices.get(i).getText());
		}
		
	    //Verify the title
		
	        String title=driver.getTitle();
	        System.out.println();
	        if(title.contains("Customer Service"))
	        {
	        	System.out.println("You have landed on Page:"+title);
	        }
		
		Thread.sleep(3000);
		driver.quit();

	}


}
