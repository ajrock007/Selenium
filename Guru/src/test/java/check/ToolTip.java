package check;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class ToolTip {
	
	@Test(enabled=false)
	public void toolTipTest() {
		
		/*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		FirefoxOptions op = new FirefoxOptions();
		op.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver(op);*/
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/social-icon.html");
		//find all elements of the social links
		List<WebElement> socialIcons = driver.findElements(By.xpath("//div[@class='soc-ico show-round']/a"));
		Iterator<WebElement> it = socialIcons.iterator();
		//user iterator to navigate each icon and assert the text.
		SoftAssert soft = new SoftAssert();
		while(it.hasNext()) {
			WebElement icon = it.next();
			String check = icon.getAttribute("title");
			if(check.equalsIgnoreCase("facebook")) {
				soft.assertEquals(check, "facebook");;
				
			}
			else if (check.equalsIgnoreCase("Mail")) {
				soft.assertEquals(check, "Mail");
			}
			else if (check.equalsIgnoreCase("Google+")) {
				soft.assertEquals(check, "google+");
			}
			else if (check.equalsIgnoreCase("YOutube")) {
				soft.assertEquals(check, "YouTube");
			}
			else if (check.equalsIgnoreCase("Github")) {
				soft.assertEquals(check, "Github");
			}
			else if (check.equalsIgnoreCase("rss")) {
				soft.assertEquals(check, "Rss");
			}
			else {
				System.out.println("Icon title doesnt match wiht any given text");
			}
			
		}
		soft.assertAll();
	}
	
	@Test(enabled=true)
	public void toolTipAction() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tooltip-and-double-click/");
		
		Actions a = new Actions(driver);
		WebElement hover = driver.findElement(By.id("tooltipDemo"));
		WebElement tooltip = driver.findElement(By.cssSelector("span[class=tooltiptext]"));
		System.out.println(tooltip.isDisplayed());
		System.out.println(tooltip.getText());
		Assert.assertEquals("",tooltip.getText());
		Thread.sleep(2000);
		a.moveToElement(hover).build().perform();
		System.out.println(tooltip.isDisplayed());
		System.out.println(tooltip.getText());
		Assert.assertEquals("We ask for your age only for statistical purposes.", tooltip.getText());
		driver.close();
		driver=null;
		
	}

}
