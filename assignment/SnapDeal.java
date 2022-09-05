package week4.assignment;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {

		// Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Go to Mens Fashion

		WebElement elementMenFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions elementMouseOverFashion = new Actions(driver);
		elementMouseOverFashion.moveToElement(elementMenFashion).perform();

		// Go to Sports Shoes
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();

		// Get the count of the sports shoes
		String textCount = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();

		System.out.println("Total Number of Sport Shoes:" + textCount);

		// Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);

		// Get the list of price before Sorting in list
		List<WebElement> elementSortBefore = driver
				.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));

		List<Integer> elementSortBeforeList = new ArrayList<Integer>();

		for (WebElement ele1 : elementSortBefore) {
			elementSortBeforeList.add(Integer.valueOf(ele1.getText().replace("Rs. ", "").replace(",", "")));
		}

		System.out.println("List before sorting:" + elementSortBeforeList);

		// Sort by Low to High
		driver.findElement(By.xpath("//i[contains(@class,'expand-arrow sort-arrow')]")).click();
		driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']/ul/li[2]")).click();

		Thread.sleep(3000);

		// Get the list of price after sorting
		List<WebElement> elementSortAfter = driver
				.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
		List<Integer> elementSortAfterList = new ArrayList<Integer>();
		for (WebElement ele1 : elementSortAfter) {
			elementSortAfterList.add(Integer.valueOf(ele1.getText().replace("Rs. ", "").replace(",", "")));
		}

		System.out.println("List After Sorting:" + elementSortAfterList);

		// Check if the items displayed are sorted correctly

		Collections.sort(elementSortBeforeList);

		if (elementSortBeforeList.equals(elementSortAfterList)) {
			System.out.println("The Price is sorted Correctly");
		} else
			System.out.println("The Price is not sorted");

		// Select the price range (900-1200)

		WebElement elementFrom = driver.findElement(By.xpath("//input[@name='fromVal']"));
		elementFrom.clear();
		elementFrom.sendKeys("469");

		WebElement elementTo = driver.findElement(By.xpath("//input[@name='toVal']"));
		elementTo.clear();
		elementTo.sendKeys("1200");

		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

		// Filter with color Navy

		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();

		// verify the all applied filters
		List<WebElement> elementVerifyFilters = driver.findElements(By.xpath("//div[@class='navFiltersPill']/a"));
		String text1 = elementVerifyFilters.get(0).getText();
		String text2 = elementVerifyFilters.get(1).getText();
		if (text1.equals("Rs. 469 - Rs. 1200") || text2.contains("Navy")) {
			System.out.println("Filters applied");
		} else
			System.out.println("Filters not applied");

		// Mouse Hover on first resulting Training shoes
		Thread.sleep(3000);
		WebElement elementFirstPrt = driver
				.findElement(By.xpath("(//div[@class='sort-list hidden']/following-sibling::section/div)[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(elementFirstPrt).perform();

		// click QuickView button
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]")).click();

		// Print the cost and the discount percentage
		Thread.sleep(3000);

		String textPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		Thread.sleep(3000);
		String textPercent = driver.findElement(By.xpath("//span[@class='payBlkBig']/following-sibling::span")).getText();
		System.out.println("The Price of Shoe:" + textPrice);
		System.out.println("The Discounted Percentage:" + textPercent);

		// Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/Shoe.png");

		FileUtils.copyFile(source, dest);

		// Close the current window
				driver.close();
	
	}

}
