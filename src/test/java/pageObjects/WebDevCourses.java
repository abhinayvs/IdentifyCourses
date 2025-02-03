package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Screenshot;

public class WebDevCourses {

    public WebDriver driver;
   
    Screenshot screenshot = new Screenshot();
    
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	@FindBy(id="search-autocomplete-input") 
	WebElement searchInput;
	
	@FindBy(xpath="//*[@id=\"react-autowhatever-1\"]/div[2]/ul")
	WebElement searchRecommendations;
	
	@FindBy(xpath="//*[@id=\"cds-react-aria-17\"]")
	WebElement beginnerLevelCheckbox;
	
	@FindBy(xpath="//*[@id='cds-react-aria-49']")
	WebElement englishLanguageCheckbox;
	
	@FindBy(xpath="//h3[contains(@class,'cds-CommonCard-title')]")
	List<WebElement> allCoursesTitles;
	
	@FindBy(xpath="//*[contains(@class,'cds-CommonCard-metadata')]")
	List<WebElement> allCoursesDuration;
	
	@FindBy(xpath="//*[contains(@class, 'cds-CommonCard-ratings')]")
	List<WebElement> allCoursesRatings;
	

	
	public WebDevCourses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchCourses(String courses) throws InterruptedException {
		searchInput.sendKeys(courses);
		screenshot.getScreenshot(driver,searchInput, "webdevSearchField.png");
//		wait.until(ExpectedConditions.visibilityOfAllElements(allCoursesTitles));
//		screenshot.takeScreenshot(driver, "webdevCourses.png");
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void filtering() throws InterruptedException {
//		driver.findElement(By.xpath("//*[text()='English'][1]")).click();
//		driver.findElement(By.xpath("//*[text()='Beginner'][1]")).click();
		beginnerLevelCheckbox.click();
        englishLanguageCheckbox.click();
        screenshot.takeScreenshot(driver, "webdevCourses.png");
	}
	
	public void extractCourses() {
    	
        for (int i = 1; i < 3; i++) {
            System.out.println("Course name: " + allCoursesTitles.get(i).getText());
            System.out.println("Duration: " + allCoursesDuration.get(i).getText().split("·")[2]);
            System.out.println("Ratings: " + allCoursesRatings.get(i).getText().split(", ")[1].split("·")[0]);
        }
	}
	
}
