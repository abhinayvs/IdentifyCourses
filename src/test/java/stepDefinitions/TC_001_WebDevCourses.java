package stepDefinitions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WebDevCourses;
import testBase.DriverSetup;

public class TC_001_WebDevCourses {

	public WebDriver driver = DriverSetup.driver;
	File sourceFile;
	File targetFile;

	WebDevCourses webcourse = new WebDevCourses(driver);

	@Given("open the Website coursera")
	public void open_the_Website_coursera() {
		// The website is already opened in the @Before hook
	}

	@When("Search for {string} courses")
	public void search_for_courses(String searchCourse) throws InterruptedException {

		webcourse.searchCourses(searchCourse);

	}

	@When("filter for Beginners level & English Language courses")
	public void filter_for_beginners_level_english_language_courses() throws InterruptedException {

		webcourse.filtering();

	}

	@Then("extract the course names, total learning hours & rating for first two courses")
	public void extract_the_course_names_total_learning_hours_rating_for_first_two_courses() {

		webcourse.extractCourses();

	}
}
