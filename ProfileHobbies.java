package yangutu_wedbriver;
//import yangutu.SeleniumTests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import com.opera.core.systems.OperaDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class ProfileHobbies extends SeleneseTestNgHelper {
protected WebDriver driver;
protected LoginPag logn = null;

@Before
public void setUp() throws Exception {
	
	System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	driver = new 
	ChromeDriver();
	//InternetExplorerDriver();
	//OperaDriver();
	logn = new LoginPag(driver);
	
	String baseUrl = "http://yangutu.com/";
	//String baseUrl = "http://yangutu:usabilityrulit@dev.yangutu.com/";
	
	selenium = new WebDriverBackedSelenium(driver, baseUrl);
	selenium.setTimeout("120000");}

@Test
public void appHobbies() throws Exception {


//	try	{

//	ps2.println("+++ПРОВОДИМ ТЕСТ "+comm+" "+par+"+++");
	System.out.println("+++ПРОВОДИМ ТЕСТ profile hobbies +++");


//	logn.appLoggn("sergey@spam.su");
	selenium.open("/profile?token=2f0ee42ae866d61ac92f50ae4aca8b67");
	List<WebElement> inputs = driver.findElements(By.tagName("a"));
	System.out.println("Кол-во ссылок до = "+inputs.size());
	
	
	//selenium.captureEntirePageScreenshot(hbbslocation+"1_profile_opened.png", "");
	selenium.click("id=edit-more-link");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - save button");
		try { if (selenium.isElementPresent("id=submit")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	Thread.sleep(5000);

	
	
	selenium.click("css=input.maininputinterests");
	selenium.typeKeys("css=input.maininputinterests", "pool");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - interests");
		try { if (selenium.isElementPresent("//ul[@id='feedinterests']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedinterests']/li[2]");
	
	selenium.click("css=input.maininputactivities");
	selenium.typeKeys("css=input.maininputactivities", "swimming");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - activities");
		try { if (selenium.isElementPresent("//ul[@id='feedactivities']/li[2]/span")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedactivities']/li[2]/span");

	selenium.click("css=input.maininputsports");
	selenium.typeKeys("css=input.maininputsports", "volleyball");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedsports']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedsports']/li[2]");
	
	selenium.click("css=input.maininputgames");
	selenium.typeKeys("css=input.maininputgames", "football");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - games");
		try { if (selenium.isElementPresent("//ul[@id='feedgames']/li[3]/span/span[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedgames']/li[3]/span/span[2]");
	
	selenium.click("css=input.maininputmusic");
	selenium.typeKeys("css=input.maininputmusic", "pop");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - save button");
		try { if (selenium.isElementPresent("//ul[@id='feedmusic']/li[3]/span/span[3]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedmusic']/li[3]/span/span[3]");
	
	selenium.click("css=input.maininputmovies");
	selenium.typeKeys("css=input.maininputmovies", "pop");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - save button");
		try { if (selenium.isElementPresent("//ul[@id='feedmovies']/li[3]/span")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedmovies']/li[3]/span");

	selenium.click("css=input.maininputtelevision");
	selenium.typeKeys("css=input.maininputtelevision", "discover");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - tv");
		try { if (selenium.isElementPresent("//ul[@id='feedtelevision']/li")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedtelevision']/li");
	
	selenium.click("css=input.maininputbooks");
	selenium.typeKeys("css=input.maininputbooks", "histor");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - books");
		try { if (selenium.isElementPresent("//ul[@id='feedbooks']/li[3]/span/span[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedbooks']/li[3]/span/span[2]");

	selenium.click("css=input.maininputwebsites");
	selenium.typeKeys("css=input.maininputwebsites", "www");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedwebsites']/li/span/span[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedwebsites']/li/span/span[2]");
	
	selenium.click("css=input.maininputfood");
	selenium.typeKeys("css=input.maininputfood", "food");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedfood']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedfood']/li[2]");

/*	selenium.click("css=input.maininputplaces");
	selenium.type("css=input.maininputplaces", "ci");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedplaces']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedplaces']/li[2]");

	selenium.click("css=input.maininputbrands");
	selenium.type("css=input.maininputbrands", "ro");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedbrands']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedbrands']/li[2]");

	selenium.click("css=input.maininputpeople");
	selenium.type("css=input.maininputpeople", "people");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedpeople']/li[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedpeople']/li[2]");

*/	selenium.click("css=input.maininputteams_athletes");
	selenium.typeKeys("css=input.maininputteams_athletes", "barce");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedteams_athletes']/li[3]/span/span[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedteams_athletes']/li[3]/span/span[2]");
	
	selenium.click("css=input.maininputpolitics");
	selenium.typeKeys("css=input.maininputpolitics", "go");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - likes");
		try { if (selenium.isElementPresent("//ul[@id='feedpolitics']/li[2]/span/span[2]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//ul[@id='feedpolitics']/li[2]/span/span[2]");
	
  for (int second = 0;; second++) {
	if (second >= 60) fail("timeout - save button");
	try { if (selenium.isElementPresent("id=submit")) break; } catch (Exception e) {}
	Thread.sleep(1000);
    }
	selenium.click("id=submit");

	Thread.sleep(8000);
	List<WebElement> inputs2 = driver.findElements(By.tagName("a"));
	System.out.println("Кол-во ссылок после  = "+inputs2.size());
	System.out.println("Добавлено из 12 = "+(inputs2.size()-inputs.size()));
	if (inputs2.size()>inputs.size())
	{
	System.out.println("+PROFILE - HOBBIES | PASSED");
	}
	else System.out.println("+PROFILE - HOBBIES | FAILED - no new hobbies");
//	} catch	(Throwable e)	{System.out.println("Ошибка: "+e);}
	}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}
	
		