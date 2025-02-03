package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ValidateForm;
import testBase.DriverSetup;

public class TC_003_FormValidation {

    public WebDriver driver = DriverSetup.driver;
    ValidateForm form = new ValidateForm(driver);

    @Given("opening the url coursera")
    public void opening_the_url() {
        // The website is already opened in the @Before hook
    }

    @When("click on For Universities")
    public void click_on_for_universities() {
        form.setUni();
    }

    @When("click on Solutions")
    public void click_on_solutions() {
       form.setSolution();
    }

    @When("Select any course")
    public void select_any_course() {
    	form.setCourse();
    }

    @When("Filling form with invalid email as {string}")
    public void filling_form_with_invalid_email_as(String email) {
        form.setFirstName();
        form.setLastName();
        form.setEmail(email);
        form.setPhone();
        form.setInstitute();
        form.setCompany();
        form.setTitle();
        form.setDepartment();
        form.setNeeds();
        form.setCountry();
        form.setState();
        form.submit();
    }

    @Then("capturing the error message")
    public void capturing_the_error_message() throws InterruptedException {

    	String error_msg = form.getErrorMsg();
        System.out.println(error_msg);
    }
}
