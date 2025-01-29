package stepDefinitions;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.DriverSetup;

public class TC_001_WebDevCourses {

    public WebDriver driver = DriverSetup.driver;
    File sourceFile;
    File targetFile;

    @Given("open the Website coursera")
    public void open_the_Website_coursera() {
        // The website is already opened in the @Before hook
    }

    @When("Search for {string} courses")
    public void search_for_courses(String searchCourse) throws InterruptedException {
        WebElement searchInput = driver.findElement(By.id("search-autocomplete-input"));
        searchInput.sendKeys(searchCourse);
        sourceFile = searchInput.getScreenshotAs(OutputType.FILE);
        targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\searchField.png");
        sourceFile.renameTo(targetFile);
        Thread.sleep(2000);
        WebElement searchRecommendations = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1\"]/div[2]/ul"));
        sourceFile = searchRecommendations.getScreenshotAs(OutputType.FILE);
        targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\searchRecommendations.png");
        sourceFile.renameTo(targetFile);
        searchInput.sendKeys(Keys.ENTER);
    }

    @When("filter for Beginners level & English Language courses")
    public void filter_for_beginners_level_english_language_courses() {
        try {
            WebElement beginnerLevelCheckbox = driver.findElement(By.xpath("//*[@id=\"cds-react-aria-17\"]"));
            WebElement englishLanguageCheckbox = driver.findElement(By.xpath("//*[@id='cds-react-aria-49']"));
            beginnerLevelCheckbox.click();
            englishLanguageCheckbox.click();
        } catch (Exception e) {
            System.out.println("Checkbox is not clicked");
        }
    }

    @Then("extract the course names, total learning hours & rating for first two courses")
    public void extract_the_course_names_total_learning_hours_rating_for_first_two_courses() throws InterruptedException {
        Thread.sleep(2000);
    	TakesScreenshot ts = (TakesScreenshot)driver;
        sourceFile = ts.getScreenshotAs(OutputType.FILE);
        targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\courses.png");
        sourceFile.renameTo(targetFile);
    	List<WebElement> allCoursesTitles = driver.findElements(By.xpath("//h3[contains(@class,'cds-CommonCard-title')]"));
        List<WebElement> allCoursesDuration = driver.findElements(By.xpath("//*[contains(@class,'cds-CommonCard-metadata')]"));
        List<WebElement> allCoursesRatings = driver.findElements(By.xpath("//*[contains(@class, 'cds-CommonCard-ratings')]"));
        for (int i = 1; i < 3; i++) {
            System.out.println("Course name: " + allCoursesTitles.get(i).getText());
            System.out.println("Duration: " + allCoursesDuration.get(i).getText().split("·")[2]);
            System.out.println("Ratings: " + allCoursesRatings.get(i).getText().split(", ")[1].split("·")[0]);
        }
      
    }
}
