import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

	public static WebDriver driver;
	
	Logger log = Logger.getLogger(LoginPage.class);
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumAll\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");
		
	}
	@Test(priority=1)
	public void LoginPage1()
	{
		String title=driver.getTitle();
		Assert.assertEquals(title,"Free CRM #1 cloud software for any business large or small" );
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}
