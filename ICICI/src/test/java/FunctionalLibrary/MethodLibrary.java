package FunctionalLibrary;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import PageObjects.FDCalculatorPage;
import Utilities.DataInputProvider;
import Utilities.WritetoExcel;

public class MethodLibrary {
	
	WebDriver driver;
	FDCalculatorPage fdCalc = null;
	String[][] inputData = DataInputProvider.getSheet("InputData");
	Map<String, String>  outputData = new HashMap<String, String>();
	
	public MethodLibrary(WebDriver driver) {
		
		this.driver = driver;
		fdCalc = new FDCalculatorPage(driver);
	}

	public void getIntoFrame() {
		
		for(int i=0; i<7; i++) {
			
			new Actions(driver).sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		
		driver.switchTo().frame(fdCalc.getCalculatorFrame()); 
	}
	
	public void selectFDType() throws InterruptedException {
		
		//new Actions(driver).moveToElement(fdCalc.getTypeOfFD()).build().perform();
		Thread.sleep(3000);
		new Select(fdCalc.getTypeOfFD()).selectByVisibleText(inputData[0][0]);
	}
	
	public void enterAmount() throws InterruptedException {
		
		Thread.sleep(2000);
		fdCalc.getLoanAmount().clear();
		Thread.sleep(2000);
		fdCalc.getLoanAmount().sendKeys(inputData[0][1]);
		
	}
	
	public void getCalculatedDetails() throws InterruptedException {
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		String maturityValue = fdCalc.getMaturityValue().getText();
		String interestAmount = fdCalc.getInterestAmount().getText();
		
		outputData.put("Maturity Value", maturityValue);
		outputData.put("Interest Amount", interestAmount);
	}
	
	public void clickOnTenure() throws InterruptedException {
		
		Thread.sleep(2000);
		fdCalc.getDays().click();
	}
	
	public void fillDays() throws InterruptedException {
		
		Thread.sleep(2000); 
		fdCalc.getTenureDays().clear();
		Thread.sleep(2000);
		fdCalc.getTenureDays().sendKeys(inputData[0][2]);
		
	}
	
	public void getUpdatedCalculatedDetails() throws InterruptedException {
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		String maturityValue = fdCalc.getMaturityValue().getText();
		String interestAmount = fdCalc.getInterestAmount().getText();
		
		outputData.put("Updated Maturity Value", maturityValue);
		outputData.put("Updated Interest Amount", interestAmount);
	}
	
	
	  public void writeExcel() throws IOException {
	  
	  WritetoExcel.writeToExcel(outputData, "OutputData"); 
	  }
	 
	public void clickLogo() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		new Actions(driver).sendKeys(Keys.PAGE_UP).build().perform();
		fdCalc.getLogo().click();
		
	}
	
}
