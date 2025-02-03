package stepDefinitions;

import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LearningLangs;
import testBase.DriverSetup;


public class TC_002_LearningLanguages {

	
	public List<WebElement> languagesEle;
	public List<WebElement> levelEle;
	
	public WebDriver driver = DriverSetup.driver;
	
	LearningLangs lang = new LearningLangs(driver);
	
	@Given("open the Website again coursera")
	public void open_the_website_again(){
		 // The website is already opened in the @Before hook
	}
	
	@When("Search for {string} in search box")
	public void search_for_in_search_box(String searchCourse) throws InterruptedException {
		lang.searchLang(searchCourse);
	}

	@When("Extract all the languages with total count")
	public void extract_all_the_languages_with_total_count() {
	   lang.extractLangs();
	}

	@When("Extract  different levels with its total count")
	public void extract_different_levels_with_its_total_count() {
		lang.extractLevels();
	}

	@Then("Display them")
	public void display_them() {
	    
		lang.printLangs();
		
		lang.printLevels();
	}

	
}