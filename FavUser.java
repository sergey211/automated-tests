package yangutu_wedbriver;
//import yangutu.SeleniumTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class FavUser extends SeleneseTestNgHelper {
	protected WebDriver driver;
	protected LoginPag logn = null;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new 
		ChromeDriver();
		logn = new LoginPag(driver);
		String baseUrl = "http://yangutu.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.setTimeout("120000");}
//@Ignore
	@Test
public void appFav() throws Exception {
	 

//	logn.appLoggn("sergey@spam.su");
	selenium.open("http://yangutu.com/alektasp?token=2f0ee42ae866d61ac92f50ae4aca8b67");

	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to add to favorites not found");
		try { if (selenium.isElementPresent("//input[@value='Add to favorites']")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	selenium.click("//li[5]/input");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to add to favorites not found");
		try { if (selenium.isElementPresent("//*[contains(text(),'Alekta was added to favorites')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	
	Thread.sleep(5000);
	selenium.open("http://yangutu.com/favorites");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to add to favorites not found");
		try { if (selenium.isElementPresent("//a[contains(@href,'alektasp')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//a[contains(@href,'alektasp')]");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to remove from favorites not found");
		try { if (selenium.isElementPresent("//input[@value='Remove from favorites']")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//li[6]/input");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to add to favorites not found");
		try { if (selenium.isElementPresent("//*[contains(text(),'Alekta was removed')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	
	selenium.open("http://yangutu.com/favorites");
	if (selenium.isElementPresent("//a[contains(@href,'alektasp')]")==false);
	{System.out.println("+FAVORITES | PASSED"); }

//} catch (Throwable e){System.out.println("!add to fav | FAILED : "+e);}
}
	@After
	public void tearDown() throws Exception {
	selenium.stop();
	}
	}