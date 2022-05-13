package Week4.Day2;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	public static void main(String[]args)
	{
		//setup the driver
		WebDriverManager.chromedriver().setup();
		//Chromedriver
		ChromeDriver driver= new ChromeDriver();
		//Load url
		driver.get("http://www.leafground.com/pages/Window.html");
		//maximaize the screen
		driver.manage().window().maximize();
		//timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("home")).click();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println("");
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String>windowHandlesList = new ArrayList<String>(windowHandles);
		
		System.out.println("");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("");
		driver.switchTo().window(windowHandle);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.switchTo().window(windowHandlesList.get(0));
		System.out.println(driver.getCurrentUrl());
}
}

