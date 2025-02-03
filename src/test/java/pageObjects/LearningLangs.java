package pageObjects;

import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Screenshot;

public class LearningLangs {

	WebDriver driver;
	
	Screenshot screenshot = new Screenshot();
	
	@FindBy(id="search-autocomplete-input")
	WebElement searchInput;
		 
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']//div[@class='css-q5d1os']//div[@class='css-1xi2dvh']")
	List<WebElement> languagesEle;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']//div[@class='css-5ji5n2']//div[@class='css-1xi2dvh']")
	List<WebElement> levelEle;
	
	@FindBy(xpath="//*[@id=\"main\"]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/button/span")
	WebElement showButton;
	
	public LearningLangs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public void searchLang(String searchCourse) throws InterruptedException {
		searchInput.sendKeys(searchCourse);
		screenshot.getScreenshot(driver,searchInput, "langSearchField.png");
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void extractLangs() {
//		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/button/span")).click();
		showButton.click();
		System.out.println("Number of Languages are: "+languagesEle.size());
	}
	
	public void extractLevels() {
		System.out.println("Number of Levels are: "+levelEle.size());
	}
	
	public void printLangs() {
		System.out.println("-----Printing All languages---------");
		for(WebElement ele:languagesEle) {
			System.out.println(ele.getText());
		}
	}
	
	public void printLevels() {
		System.out.println("-----Printing All Levels------");
		for(WebElement ele:levelEle) {
			System.out.println(ele.getText());
		}
	}
}
