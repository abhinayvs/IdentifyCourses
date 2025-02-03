package utilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class Screenshot {

	File srcFile,dstFile;
	
	WebDriverWait wait;
	
	public void getScreenshot(WebDriver driver,WebElement webele,String fileName) throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webele));
		srcFile = webele.getScreenshotAs(OutputType.FILE);
		dstFile = new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName);
		srcFile.renameTo(dstFile);
		
	}
	
	public void takeScreenshot(WebDriver driver,String fileName) throws InterruptedException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		Thread.sleep(3000);
		srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		dstFile =  new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName);
		srcFile.renameTo(dstFile);
	}
	
}
