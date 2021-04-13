package TestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import FunctionalLibrary.MethodLibrary;
import Utilities.Base;

public class TestCase01{
	
	static WebDriver driver = null;
	Base base = null;
	
	MethodLibrary ml = null;
	
	@BeforeClass
	public void beforeClass() throws IOException {

		base = new Base();
		driver = base.initializeDriver();
		ml = new MethodLibrary(driver);
		
	}
	
	@Test
	public void ICICI() throws IOException, InterruptedException {
		
		ml.getIntoFrame();
		ml.selectFDType();
		ml.enterAmount();
		ml.getCalculatedDetails();
		ml.clickOnTenure();
		ml.fillDays();
		ml.getUpdatedCalculatedDetails();
		ml.writeExcel();
		ml.clickLogo();
		Base.getScreenshot("HomePage");
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
