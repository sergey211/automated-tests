package yangutu_wedbriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class ProfileTraits extends  SeleneseTestNgHelper {
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
		selenium.setTimeout("180000");}

@Test
public void appTraits() throws Exception {

  	   System.out.println("+++ПРОВОДИМ ТЕСТ TRAITS+++");
  	//   logn.appLoggn("sergey@spam.su");
  	   selenium.open("/profile?token=2f0ee42ae866d61ac92f50ae4aca8b67");
     	
   //  	selenium.click("link=Profile");
 		for (int second = 0;; second++) {
 			if (second >= 60) fail("timeout - link 'edit' not found");
 			try { if (selenium.isElementPresent("id=edit-about-link")) break; } catch (Exception e) {}
 			Thread.sleep(1000);
 		}
 		Thread.sleep(4000);
 		String traits = selenium.getText("//div[@id='about-info-div']/div[2]/div[4]/div/div[2]");
 		System.out.println("Изначально черты: "+traits);
 		selenium.click("id=edit-about-link");
 		for (int second = 0;; second++) {
 			if (second >= 60) fail("timeout - cancel button not found");
 			try { if (selenium.isElementPresent("css=div.description > a.cancel")) break; } catch (Exception e) {}
 			Thread.sleep(1000);
 		}

 		Thread.sleep(5000);
 		selenium.click("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div/ul/li[3]");
 		Thread.sleep(2000);
 		selenium.click("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div/ul/li[3]");

 		selenium.click("id=submit");
 		Thread.sleep(8000);
 		traits = selenium.getText("//div[@id='about-info-div']/div[2]/div/div[4]/div/div[2]");
 		System.out.println("После добавления черты: "+traits);
 		selenium.click("id=edit-about-link");
 		for (int second = 0;; second++) {
 			if (second >= 60) fail("timeout - setfrm not found");
 			try { if (selenium.isElementPresent("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div[2]/ul/li[2]")) break; } catch (Exception e) {}
 			Thread.sleep(1000);
 		}
 		Thread.sleep(4000);
 		selenium.click("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div[2]/ul/li[2]");
 		Thread.sleep(2000);
 		selenium.click("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div[2]/ul/li[2]");
 		Thread.sleep(3000);
 		selenium.click("id=submit");
 		Thread.sleep(3000);
 		for (int second = 0;; second++) {
 			if (second >= 60) fail("timeout - setfrm not found");
 			try { if (selenium.isElementPresent("//div[contains(text(), 'ffectionate')]")) break; } catch (Exception e) {}
 		//	try { if (selenium.isElementPresent("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div[2]/ul/li[2]")) break; } catch (Exception e) {}
 			Thread.sleep(1000);
 		}
 		Thread.sleep(3000);
 		traits = selenium.getText("//div[contains(text(), 'ffectionate')]");
 		//traits = selenium.getText("//form[@id='userAboutMe']/div[4]/div[2]/div[2]/div/div[2]/ul/li[2]");
 		System.out.println("После удаления черты: "+traits);
		System.out.println("+PROFILE - TRAITS | PASSED");
   //	} catch  	(Throwable e)   	{System.out.println("Ошибка: "+e);}
}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}
		