package Week4.Day2;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.time.Duration;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[]args) throws IOException, InterruptedException
	{
		//setup the driver
		WebDriverManager.chromedriver().setup();
		//Chromedriver
		ChromeDriver driver= new ChromeDriver();
		//Load url
		driver.get("https://www.amazon.in/");
		//maximaize the screen
		driver.manage().window().maximize();
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//search as oneplus 9 pro 
		driver.findElement(By.id("searchtextbox")).sendKeys("oneplus 9pro",Keys.ENTER);
		//Get the price of the first product
		String ProductPrice=driver.findElement(By.xpath("(//div[@class=a-section'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("Product Price");
		System.out.println(driver.findElement(By.xpath("//div//span[text()='RESULT']//following::span[contains(text(),stars')][1]")).getText());
		driver.findElement(By.xpath("//div//span[text()='Results']//following::h2[1]//a")).click();
		List<String>windowHandleslist2=new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(windowHandleslist2.get(1));
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		File snapfile = new File("./snaps/Amazon.png");
		FileUtils.copyFile(srcfile,snapfile);
		if(FileUtils.getFile(snapfile).exists())
		{
			System.out.println("screenshot is taken");
		}
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(1000);
		String cartvalue =  driver.findElement(By.xpath("//span//b[contains(text(),'cart total')]//following::span")).getText();
		if(cartvalue.replaceAll("\\D","").contains(ProductPrice.replaceAll("//D",  "")))
		{
			System.out.println("Cart price is matched");
		}
		driver.quit();
		
		}
}