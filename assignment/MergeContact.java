package week4.assignment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");

		// MAXIMIZE THE WINDOW
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter UserName and Password Using Id Locator
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");

		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");

		// Click on Login Button using Class Locator
		WebElement elementLoginButton = driver.findElement(By.className("decorativeSubmit"));
		elementLoginButton.click();

		// Click on CRM/SFA Link
		WebElement elementCrmSfa = driver.findElement(By.linkText("CRM/SFA"));
		elementCrmSfa.click();
		Thread.sleep(2000);

		// Click on contacts Button
		WebElement elementContact = driver.findElement(By.linkText("Contacts"));
		elementContact.click();
		Thread.sleep(2000);

		// Click on Merge Contacts using Xpath Locator
		WebElement elementMergeContact = driver.findElement(By.xpath("//ul[@class='shortcuts']/li[4]/a"));
		elementMergeContact.click();
		Thread.sleep(2000);

		// click on the from widget
		driver.findElement(By.xpath("//form[@name='MergePartyForm']/table/tbody/tr[1]/td[2]/a")).click();
		Set<String> windowFromHandles = driver.getWindowHandles();
		List<String> listFrom = new ArrayList<String>(windowFromHandles);
		driver.switchTo().window(listFrom.get(1));
		Thread.sleep(2000);
		
		// Click on First Resulting Contact
		driver.findElement(By.xpath("//div[1]/table/tbody/tr[1]/td[1]/div/a")).click();
		driver.switchTo().window(listFrom.get(0));
		Thread.sleep(2000);

		// click on the To widget
		driver.findElement(By.xpath("//form[@name='MergePartyForm']/table/tbody/tr[2]/td[2]/a")).click();
		Set<String> windowToHandles = driver.getWindowHandles();
		List<String> listTo = new ArrayList<String>(windowToHandles);
		driver.switchTo().window(listTo.get(1));
		Thread.sleep(2000);
		
		// Click on Second Resulting Contact
		driver.findElement(By.xpath("//div[2]/table/tbody/tr[1]/td[1]/div/a")).click();
		driver.switchTo().window(listTo.get(0));
		Thread.sleep(2000);
		
		// Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//form[@name='MergePartyForm']/table/tbody/tr[4]/td[2]/a")).click();

		// Accept the Alert
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		// Verify the title of the page
		System.out.println("The title of the page:" + driver.getTitle());

		
	}


}
