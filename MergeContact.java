package Week4.Day2;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[]args)
	{
		//setup the driver
		WebDriverManager.chromedriver().setup();
		//Chromedriver
		ChromeDriver driver= new ChromeDriver();
		//Load url
		driver.get("http://leaftaps.com/opentaps/control/login");
		//maximaize the screen
		driver.manage().window().maximize();
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		 driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		  driver.findElement(By.className("decorativeSubmit")).click();
		    driver.findElement(By.linkText("CRM/SFA")).click();
		    //click on contacts Button
		    driver.findElement(By.linkText("Contacts")).click();
		    // Click on Merge Contacts using Xpath Locator
		    driver.findElement(By.linkText("Merge Contacts")).click();
		    driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'][1]")).click();
		     Set<String> windowHandles = driver.getWindowHandles();
		    List<String> windowHandleslist= new ArrayList<String>(windowHandles);
		    String secondwindow = windowHandleslist.get(1);
		    driver.switchTo().window(secondwindow);
		    driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]//td[1]//a")).click();
		    driver.switchTo().window(secondwindow);
		    driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'])[2]")).click();
		    Set<String> windows1 = driver.getWindowHandles();
		    List<String> windows=new ArrayList<String>(windows1);
		    driver.switchTo().window(windows.get(1));
		    driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]//td[1]//a")).click();
		    driver.switchTo().window(secondwindow);
		    driver.findElement(By.xpath("//a[@class='butonDangerous']")).click();
		    // Accept the Alert
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    System.out.println(driver.getTitle());
		    // Verify the title of the page
		    if(driver.getTitle().contains("view contact"))
		    {
		    	System.out.println("the contact was successfull");
		    }  
}
}