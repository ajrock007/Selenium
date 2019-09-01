package check;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.Excel;

public class LoginTest extends Base {
	
	
	@Test(dataProvider="getData")
	public void Login(String sno,String username, String password, String expected, String result) {
		driver=initializeDriver();
		driver.get("http://www.demo.guru99.com/v4/");
		HomePageObjects hp = new HomePageObjects(driver);
		hp.getUsername().sendKeys(username);
		hp.getPassword().sendKeys(password);
		hp.getLoginButton().click();
		Boolean check;
		check=driver.findElement(By.xpath("//marquee[contains(text(),'Welcome')]")).isDisplayed();
		if(check) {
			System.out.println("Login is successful");
		}
		else
			System.out.println("Login failed");
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		Excel exl = new Excel();
		return exl.readExcel("C:\\Users\\TOSHIBA\\Guru\\data.xlsx");
	}

}
