package FlipkartExecute;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartLogin {
	WebDriver driver=null;
	
	String display="Showing 1 – 18 of 513 results for latest laptops";
	
	
	@Test
	public void FlipkartSignIN() throws Exception{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//a[contains(@href,'/account/login?ret=/')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[contains(@class,'_2zrpKA')])[1]")).sendKeys("8748083765");
		driver.findElement(By.xpath("(//input[contains(@class,'_2zrpKA')])[2]")).sendKeys("MAGUSHAI1");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]/span")).click();
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[contains(@class,'LM6RPg')]")).sendKeys("latest Laptops");
		driver.findElement(By.xpath("//button[contains(@class,'vh79eN')]")).click();
		WebElement e = driver.findElement(By.xpath("//span[contains(text(),'Showing 1 –')]"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String text=e.getText();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(text);
		if(text.equalsIgnoreCase(display))
		{
			System.out.println("Displayed the search");
		}
		
		WebElement e1 = driver.findElement(By.xpath("//span[text()='Women']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(e1).perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='zi6sUf']/div/ul/li[4]/ul/li/ul/li[4]/ul/li[10]/a/span[text()='Accessories']")).click();
		
		WebElement e2 = driver.findElement(By.xpath("(//div[@class='_3aQU3C'])[2]"));
		WebElement e3 = driver.findElement(By.xpath("//div[@class='_1A0dov']/div[2]/div[5]"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		act.clickAndHold(e2).perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		act.moveToElement(e3).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='_1XdvSH _17zsTh']/div/div/div)[1]/div/div[4]/section/div[2]/div[1]/div[6]/div/div/label/div[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='_2xw3j-']/div/div[3]/div/div[3]/div[2]/div[1]/a[2]")).click();
		
		String mainWindow=driver.getWindowHandle();
		Set<String>SecondWindow=driver.getWindowHandles();
		
		for(String s:SecondWindow){
			System.out.println(s);
			
			if(!s.equals(mainWindow))
			{
				driver.switchTo().window(s);
				String title = driver.getTitle();
				
				Assert.assertTrue(title.contains("Wildcraft karakoram 60-Blue Rucksack - 60 L  (Blue)"));
				System.out.println(title);
				if(title.equalsIgnoreCase("Wildcraft karakoram 60-Blue Rucksack - 60 L  (Blue)")){
					System.out.println("Succesfully in the page");
				}
				else
				{
					System.out.println("Not in the page");
				}
				
				driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Remove']")).click();
				WebElement e4 = driver.findElement(By.xpath("//span[text()='Your Shopping Cart is empty']"));
				Assert.assertTrue(e4.isDisplayed());
				System.out.println(e4);
				driver.close();
					
				
			}
			
			driver.switchTo().window(mainWindow);
			Thread.sleep(4000);
			driver.close();
		}
		
		
			
		
		
		
	}
	
	
}
