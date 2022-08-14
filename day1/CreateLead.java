package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		
		WebElement elementUsername = driver.findElement(By.id("username"));
		elementUsername.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.name("PASSWORD"));
		elementPassword.sendKeys("crmsfa");
		
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		
		WebElement elementWelcome = driver.findElement(By.tagName("h2"));
		String text = elementWelcome.getText();
		System.out.println(text);
		
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		
		WebElement elementLeads = driver.findElement(By.linkText("Leads"));
		elementLeads.click();
		
		WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		
		WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
		elementCompanyName.sendKeys("TCS");
		
		WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
		elementFirstName.sendKeys("Karthika");
		
		WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
		elementLastName.sendKeys("V");
		
		WebElement elementSourcedd = driver.findElement(By.id("createLeadForm_dataSourceId"));
		elementSourcedd.sendKeys("Employee");
		
		WebElement elementIndustrydd = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd = new Select(elementIndustrydd);
		dd.selectByIndex(2);
		
		WebElement elementOwenershipdd = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd1 = new Select(elementOwenershipdd);
		dd1.selectByVisibleText("Partnership");
		
		WebElement elementMarketingdd = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dd2 = new Select(elementMarketingdd);
		dd2.selectByValue("CATRQ_CAMPAIGNS");
		
		WebElement elementDepartment = driver.findElement(By.id("createLeadForm_departmentName"));
		elementDepartment.sendKeys("IT");
		
		WebElement elementEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
		elementEmail.sendKeys("karthika86kk@gmail.com");
		
		WebElement elementStatedd3 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd3 = new Select(elementStatedd3);
		dd3.selectByVisibleText("New York");
		
		WebElement elementCreate = driver.findElement(By.name("submitButton"));
		elementCreate.click();
		
		String currentTitle= driver.getTitle();
		System.out.println(currentTitle);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
