package yangutu_wedbriver;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class RiseBalance extends SeleneseTestNgHelper {
protected WebDriver driver;
//protected LoginPag logn = null;

@Before
public void setUp() throws Exception {
	
	System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
	driver = new 
	ChromeDriver();
	//InternetExplorerDriver();
	//OperaDriver();
	//logn = new LoginPag(driver);
	
	String baseUrl = "http://yangutu.com/";
	//String baseUrl = "http://yangutu:usabilityrulit@dev.yangutu.com/";
	
	selenium = new WebDriverBackedSelenium(driver, baseUrl);
	selenium.setTimeout("120000");}

@Test
public void appRiseBal() throws Exception {


	
	//try	{

	System.out.println("+++ÏÐÎÂÎÄÈÌ ÒÅÑÒ risebalance+++");

	selenium.open("http://yangutu.com/admin/login/login");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("css=img.floatLeft")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.type("id=f_auth_login", "admin");
	selenium.type("id=f_auth_pass", "*******");
	selenium.click("css=input[type=\"checkbox\"]");
	selenium.click("css=img.floatLeft");
	Thread.sleep(10000);
	selenium.open("/coins?token=2f0ee42ae866d61ac92f50ae4aca8b67");
	//selenium.open("http://yangutu.com/coins");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("//input[@value='Buy More']")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("//input[@value='Buy More']");
	Thread.sleep(9000);
	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src=\"https://yangutu.com/payment/form/pm/cc/fid/0/resource/undefined\"]"))); 
	
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("//*[contains(text(),'Payment Information')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	selenium.click("css=div.selectedTxt");
	selenium.click("link=100 coins for $0.05");
//	selenium.click("link=100 coins for $3.00");
	selenium.click("id=card_number");
	selenium.type("id=card_number", "4012888888881881");
	selenium.type("id=card_name", "Sergey");
	selenium.type("id=card_cvv", "994");
	selenium.click("//form[@id='ccard-form']/table[2]/tbody/tr[6]/td[2]/div/div/div");
	selenium.click("link=01");
	selenium.click("//td[2]/div[2]/div/div");
	selenium.click("link=2016");
	selenium.type("id=first_name", "Sergey");
	selenium.type("id=last_name", "Test-Buy-Coins");
	selenium.type("id=email", "sergey211@gmail.com");
	selenium.type("id=street", "Jilunouskaga");
	selenium.type("id=city", "Minsk");
	selenium.type("id=state", "Minsk");
	selenium.type("id=zip", "220082");
	selenium.click("//td[4]/div/div/div");
	selenium.click("link=Belarus");
	selenium.type("id=phone", "375281232323");
	selenium.click("//input[@value='Confirm and Pay']");
	Thread.sleep(10000);
	System.out.println("+RISEBALANCE | PASSED");
 	//} catch	(Throwable e)	{ps.println("!rise balance | FAILED: "+e);
	}
	}
	

		