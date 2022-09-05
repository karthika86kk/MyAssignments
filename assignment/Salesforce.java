package week4.assignment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
	public static void main(String[] args) throws Exception {
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
		
		//Get the title
		String title=driver.getTitle();
		System.out.println("The Page Title:"+title);
		
		//Get back to the parent window
		driver.switchTo().window(listWindows.get(0));
		
		//.close the browser
		driver.quit();
		                                                                                                                                                                                                                                                           
	}

}
