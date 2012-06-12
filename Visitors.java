package yangutu_wedbriver;
//import yangutu.SeleniumTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class Visitors extends SeleneseTestNgHelper {
	protected WebDriver driver;
	protected LoginPag logn = null;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new 
		ChromeDriver();
		//InternetExplorerDriver();
		//driver = new OperaDriver();
		logn = new LoginPag(driver);
		String baseUrl = "http://yangutu.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.setTimeout("120000");}
@Ignore	
@Test
public void appVis() throws Exception {

	logn.appLoggn("seryoga@mail.by");
	selenium.open("http://yangutu.com/profile");
//	selenium.captureEntirePageScreenshot(vislocation+"1_my_profile.png", "");
//	selenium.open("http://yangutu.com/4180035462");
	selenium.open("http://yangutu.com/alekta01");
	selenium.open("http://yangutu.com/logout");
	logn.appLoggn("alekta@spam.su");
	selenium.open("http://yangutu.com/visitors");
	if (selenium.isElementPresent("//")) 
//	selenium.captureEntirePageScreenshot(vislocation+"2_i_am_visitor.png", "");
//	selenium.open("http://yangutu.com/logout");
	System.out.println("+VISITORS | PASSED"); 
}// catch (Throwable e){System.out.println("+visitors | FAILED : "+e);}}

@After
public void tearDown() throws Exception {
//selenium.stop();
}
}
