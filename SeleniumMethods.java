package selenium;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumMethods {

	public static void main(String[] args) throws Exception {
		// WebDriver interface
		WebDriver driver = new FirefoxDriver();
		// enter url
		driver.navigate().to("");
		driver.findElement(By.name("")).sendKeys("");
		// input data
		driver.findElement(By.name("")).sendKeys("");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// click activity
		driver.findElement(By.name("")).click();
		// Blind Wait
		Thread.sleep(2000);
// Explicit wait..
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("")));
		// fluent wait..
		Wait<WebDriver> wait2 = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		WebElement element = wait.until(driver1 -> driver.findElement(By.name("")));
//screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("target");
		Files.copy(src, dest);
		System.out.println("screenshot successfull");
		driver.quit();
// Actionmethods
		Actions obj = new Actions(driver);
// mouse hover
		obj.moveToElement(driver.findElement(By.id("")));
// right Click
		obj.contextClick(driver.findElement(By.id("")));
// drag and drop
		WebElement source = driver.findElement(By.id(""));
		WebElement target = driver.findElement(By.id(""));
		obj.dragAndDrop(source, target).perform();
//keyboard action
		obj.keyDown(Keys.CONTROL).sendKeys("").keyUp(Keys.CONTROL).perform();
//SelectMethod
		WebElement dropDown=driver.findElement(By.name("i"));
Select sc=new Select(dropDown);
sc.selectByContainsVisibleText("");
sc.selectByIndex(0);
sc.selectByValue("");
sc.deselectByIndex(0);
sc.deSelectByContainsVisibleText("");
sc.deselectByValue("");
sc.deselectAll();
sc.getAllSelectedOptions();
sc.getOptions();
sc.getFirstSelectedOption();
	}
}