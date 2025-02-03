package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Screenshot;

public class ValidateForm {

	WebDriver driver;
	
	Screenshot screenshot = new Screenshot();

	public ValidateForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "For Universities")
	WebElement uniEle;

	@FindBy(linkText = "Solutions")
	WebElement solBtn;

	@FindBy(xpath = "//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div/div/div/div[1]/div/div[1]/a/p")
	WebElement courseEle;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Phone")
	WebElement phone;

	@FindBy(id = "Institution_Type__c")
	WebElement inst_type;

	@FindBy(id = "Company")
	WebElement company;

	@FindBy(id = "Title")
	WebElement jobRole;

	@FindBy(id = "Department")
	WebElement dept;

	@FindBy(id = "What_the_lead_asked_for_on_the_website__c")
	WebElement needs;

	@FindBy(id = "Country")
	WebElement country;

	@FindBy(id = "State")
	WebElement state;

	@FindBy(id = "ValidMsgEmail")
	WebElement error_ele;

	public void setUni() {
		uniEle.click();
	}

	public void setSolution() {
		solBtn.click();
	}

	public void setCourse() {
		courseEle.click();
	}

	public void setFirstName() {
		firstName.sendKeys("John");
	}

	public void setLastName() {
		lastName.sendKeys("Doe");
	}

	public void setEmail(String emailText) {
		email.sendKeys(emailText);
	}

	public void setPhone() {
		phone.sendKeys("9063977584");
	}

	public void setInstitute() {
		Select selectInst = new Select(inst_type);
		selectInst.selectByVisibleText("University/4 Year College");
	}

	public void setCompany() {
		company.sendKeys("TestCompany");
	}

	public void setTitle() {
		Select selectJob = new Select(jobRole);
		selectJob.selectByVisibleText("CEO");
	}

	public void setDepartment() {
		Select selectDept = new Select(dept);
		selectDept.selectByVisibleText("International");
	}

	public void setNeeds() {
		Select selectNeeds = new Select(needs);
		selectNeeds.selectByVisibleText("Courses for myself");
	}

	public void setCountry() {
		Select selectCountry = new Select(country);
		selectCountry.selectByVisibleText("Canada");
	}

	public void setState() {
		Select selectState = new Select(state);
		selectState.selectByVisibleText("ON");
	}
	
	public void submit() {
		driver.findElement(By.xpath("//*[@id=\"mktoForm_1512\"]/div[50]/span/button")).click();
	}

	public String getErrorMsg() throws InterruptedException {
		String error_msg = error_ele.getText();
		screenshot.getScreenshot(driver,error_ele, "errorMsg.png");
		return error_msg;
	}
}
