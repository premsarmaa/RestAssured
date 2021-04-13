package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FDCalculatorPage {
	
	public WebDriver driver;

	public FDCalculatorPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "paymframe")
	private WebElement calculatorFrame;
	
	@FindBy(id = "ddlTypeOfFixedDeposit")
	private WebElement typeOfFD;

	@FindBy(id = "loanAmount")
	private WebElement loanAmount;
	
	@FindBy(id = "idDays")
	private WebElement days;
	
	@FindBy(id = "tenureDay")
	private WebElement tenureDays;
	
	@FindBy(id = "spnMaturityValue")
	private WebElement maturityValue;
	
	@FindBy(id = "spnAIAmount")
	private WebElement interestAmount;
	
	@FindBy(xpath = "//a[@class ='Logo']")
	private WebElement Logo;

	public WebElement getCalculatorFrame() {
		return calculatorFrame;
	}

	public WebElement getTypeOfFD() {
		return typeOfFD;
	}

	public WebElement getLoanAmount() {
		return loanAmount;
	}

	public WebElement getDays() {
		return days;
	}

	public WebElement getTenureDays() {
		return tenureDays;
	}

	public WebElement getMaturityValue() {
		return maturityValue;
	}

	public WebElement getInterestAmount() {
		return interestAmount;
	}

	public WebElement getLogo() {
		return Logo;
	}
	
}
