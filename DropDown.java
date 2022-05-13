package Week4.Day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[]args)
	{
		//setup the driver
		WebDriverManager.chromedriver().setup();
		//Chromedriver
		ChromeDriver driver= new ChromeDriver();
		//Load url
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		//maximaize the screen
		driver.manage().window().maximize();
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement findElement1 = driver.findElement(By.id("dropdown1"));
		Select DropDown1 = new Select(findElement1);
		//Dropdown1 selenium
		DropDown1.selectByVisibleText("Selenium");
		WebElement findElement2 = driver.findElement(By.name("dropdown2"));
		Select dropdown2 = new Select(findElement2);
		dropdown2.selectByValue("2");
		WebElement findElement3 = driver.findElement(By.id("dropdown3"));
		Select dropdown3 = new Select(findElement3);
		
		WebElement findElement4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select Dropdown4 = new Select(findElement4);
		List<WebElement>Dropdownoptions = Dropdown4.getOptions();
		System.out.println("options in dropdown are" +Dropdownoptions.size());
		for(WebElement dropdownoptionval :Dropdownoptions)
		{
			System.out.println(dropdownoptionval.getText());
			
		}
			driver.findElement(By.xpath("(//select)[5]")).sendKeys("runner");
			WebElement findElement5 = driver.findElement(By.xpath("(//select[6]"));
			Select Dropdown5 = new Select(findElement5);
			Dropdown5.selectByIndex(2);
			Dropdown5.selectByIndex(3);
			List<WebElement> allSelectedOptions = Dropdown5.getAllSelectedOptions();
			for(WebElement selectedvalues :allSelectedOptions)
			{
				System.out.println(selectedvalues.getText());
			}
			driver.close();
	}
	
			}
			
			
			
		
		
		
		
