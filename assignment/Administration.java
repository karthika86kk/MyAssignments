package week4.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Administration {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.titleContains("Home | Salesforce"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Learn More']/parent::button")).click();
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		String title = driver.getTitle();
		System.out.println("Landed to: "+title);
		
		//Mouse hover on Learning On Trailhead
				Shadow dom=new Shadow(driver);
				WebElement elementLearning=dom.findElementByXPath("//span[text()='Learning']");
				elementLearning.click();		
				WebElement elementLearingOnTrail=dom.findElementByXPath("//span[text()='Learning on Trailhead']/parent::div");
				Actions act=new Actions(driver);
				act.moveToElement(elementLearingOnTrail).build().perform();
				
				//Clilck on Salesforce Certifications
				WebElement elementSalesforceCert =dom.findElementByXPath("//a[text()='Salesforce Certification']");		
				dom.scrollTo(elementSalesforceCert);		
				elementSalesforceCert.click();
				
				//Administrator Certifications
				List<WebElement>  elementAdminCert=driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
				int count=elementAdminCert.size();
				System.out.println("===================================");
				System.out.println("Administrator Certifications:");
				System.out.println("===================================");
				for (int i=0;i<count;i++)
				{
					System.out.println(elementAdminCert.get(i).getText());
				}
				
				
				//Click on Ceritification Administrator
				driver.findElement(By.xpath("//a[text()='Administrator']")).click();
				
				//Verify the Certifications available for Administrator ,Certifications should be displayed
				
			
				String text=driver.findElement(By.xpath("//div[contains(@class,'certification-banner_title')]")).getText();
				System.out.println( );
			   //System.out.println(text);
				if(text.equals("Administrator"))
				{
					System.out.println("You are in Administrator Certification page");
				}
				
				Thread.sleep(3000);
			
			driver.quit();
	
		
		
	}
}
