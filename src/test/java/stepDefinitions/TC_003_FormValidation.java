package stepDefinitions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.DriverSetup;

public class TC_003_FormValidation {

    public WebDriver driver = DriverSetup.driver;

    @Given("opening the url coursera")
    public void opening_the_url() {
        // The website is already opened in the @Before hook
    }

    @When("click on For Universities")
    public void click_on_for_universities() {
        driver.findElement(By.linkText("For Universities")).click();
    }

    @When("click on Solutions")
    public void click_on_solutions() {
        driver.findElement(By.linkText("Solutions")).click();
    }

    @When("Select any course")
    public void select_any_course() {
        driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[1]/div/div[1]/a/p")).click();
    }

    @When("Filling form with invalid email as {string}")
    public void filling_form_with_invalid_email_as(String email) {
        driver.findElement(By.id("FirstName")).sendKeys("John");
        driver.findElement(By.id("LastName")).sendKeys("Doe");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Phone")).sendKeys("9063977584");

        WebElement inst_type = driver.findElement(By.id("Institution_Type__c"));
        Select selectInst = new Select(inst_type);
        selectInst.selectByVisibleText("University/4 Year College");

        driver.findElement(By.id("Company")).sendKeys("TestCompany");

        WebElement jobRole = driver.findElement(By.id("Title"));
        Select selectJob = new Select(jobRole);
        selectJob.selectByVisibleText("CEO");

        WebElement dept = driver.findElement(By.id("Department"));
        Select selectDept = new Select(dept);
        selectDept.selectByVisibleText("International");

        WebElement needs = driver.findElement(By.id("What_the_lead_asked_for_on_the_website__c"));
        Select selectNeeds = new Select(needs);
        selectNeeds.selectByVisibleText("Courses for myself");

        WebElement country = driver.findElement(By.id("Country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("Canada");

        WebElement state = driver.findElement(By.id("State"));
        Select selectState = new Select(state);
        selectState.selectByVisibleText("ON");

        driver.findElement(By.xpath("//*[@id=\"mktoForm_1512\"]/div[50]/span/button")).click();
    }

    @Then("capturing the error message")
    public void capturing_the_error_message() {
        WebElement error_ele = driver.findElement(By.id("ValidMsgEmail"));
    	String error_msg = error_ele.getText();
        System.out.println(error_msg);
        File sourceFile = error_ele.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir")+"\\Screenshots\\errorMsg.png");
        sourceFile.renameTo(targetFile);
        
    }
}
