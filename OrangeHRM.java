package day0909;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day0909.ExtentReportManager.class)
public class OrangeHRM {
	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	void testLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class=\"orangehrm-login-branding\"]"));
		if (logo.isDisplayed()) {
			System.out.println("Displayed Company Logo");
			Assert.assertTrue(logo.isDisplayed());
		} else {
			System.out.println("Not Displayed");
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2, enabled = false)
	void testAppUrl() {
		String actUrl = driver.getCurrentUrl();
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(actUrl, expUrl);

	}

	@Test(priority = 3)
	void testHomePageTitle() {
		String actTitle = driver.getTitle();
		String expTitle = "OrangeHR";
		Assert.assertEquals(actTitle, expTitle);

	}

	@AfterClass
	void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
