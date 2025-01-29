package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.DriverSetup;


public class TC_002_LearningLanguages {

	
	public List<WebElement> languagesEle;
	public List<WebElement> levelEle;
	
	public WebDriver driver = DriverSetup.driver;
	
	@Given("open the Website again coursera")
	public void open_the_website_again(){
		 // The website is already opened in the @Before hook
	}
	
	@When("Search for {string} in search box")
	public void search_for_in_search_box(String searchCourse) {
		driver.findElement(By.id("search-autocomplete-input")).sendKeys(searchCourse);
		driver.findElement(By.id("search-autocomplete-input")).sendKeys(Keys.ENTER);
	}

	@When("Extract all the languages with total count")
	public void extract_all_the_languages_with_total_count() {
	   driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[2]/div[2]/button/span")).click();
		languagesEle = driver.findElements(By.xpath("//div[@data-testid='search-filter-group-Language']//div[@class='css-q5d1os']//div[@class='css-1xi2dvh']"));
	    System.out.println("Number of Languages are: "+languagesEle.size());
	}

	@When("Extract  different levels with its total count")
	public void extract_different_levels_with_its_total_count() {
		
		levelEle = driver.findElements(By.xpath("//div[@data-testid='search-filter-group-Level']//div[@class='css-5ji5n2']//div[@class='css-1xi2dvh']"));
		System.out.println("Number of Levels are: "+levelEle.size());
		
	}

	@Then("Display them")
	public void display_them() {
	    
		System.out.println("-----Printing All languages---------");
		for(WebElement ele:languagesEle) {
			System.out.println(ele.getText());
		}
		System.out.println("-----Printing All Levels------");
		for(WebElement ele:levelEle) {
			System.out.println(ele.getText());
		}
		
		
	}

	
}