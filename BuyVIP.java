package yangutu_wedbriver;



import com.thoughtworks.selenium.SeleneseTestNgHelper;


import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BuyVIP extends 
SeleneseTestNgHelper
{
	
	private WebDriver driver;
	@Before
	public void setUp() throws Exception {
		
	
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        driver = new 
        ChromeDriver();
     //   InternetExplorerDriver();
     //   SafariDriver();
     //   InternetExplorerDriver();
     //   OperaDriver();
  
 
		
		String baseUrl = "http://yangutu.com/";
	    selenium = new WebDriverBackedSelenium(driver, baseUrl);
	    selenium.setTimeout("120000");
}
//@Ignore	
@Test


public void testBuyVIP() throws Exception {

	payPayPal payp = new payPayPal();
	payVisa paycc = new payVisa();
	appLogin login = new appLogin(); 
	appBuyVIP buy = new appBuyVIP(); 
	loginAdmin logadmin = new loginAdmin();
    loginDevPayPal logdevp = new loginDevPayPal();
    
    logadmin.method();
	selenium.open("http://yangutu.com/debug/test/abcdef?usa=bil&x=delvip");
	logdevp.method();
 	login.method("2112@open.by");
	System.out.println("Покупаем VIP через тестовый paypal");
	buy.method();	
	payp.method("sergey_1305294903_per@gmail.com", "*****");
	System.out.println("(TEST PAYPAL)");	
    selenium.open("/logout");
    login.method("54@open.by");
	System.out.println("Покупаем VIP через реальный paypal");
	buy.method();
	payp.method("******", "*****");
	//System.out.println("VIP real paypal complete");
	System.out.println("(REAL PAYPAL)");	
	selenium.open("/logout");
	selenium.open("http://yangutu.com/debug/test/abcdef?usa=bil&x=delvip");
	login.method("54@open.by");
    System.out.println("Покупаем VIP через тестовую кредитную карту");
	buy.method();
	paycc.method("4012888888881881", "01", "2016");
	System.out.println("(TEST VISA)");	
    selenium.open("/logout");
	login.method("2112@open.by");
    System.out.println("Покупаем VIP через реальную кредитную карту");
	buy.method();
	paycc.method("*******", "**", "****");
	System.out.println("(REAL VISA)");	
}



class loginAdmin
   {

	public final void method() throws Exception
	    {
		System.out.println("Логинимся в админку");
		selenium.open("/admin/");
		Thread.sleep(8000);

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=img.floatLeft")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.type("id=f_auth_login", "admin");
		selenium.type("id=f_auth_pass", "*******");
		selenium.click("css=input[type=\"checkbox\"]");
		selenium.click("css=img.floatLeft");
		selenium.waitForPageToLoad("30000");
		System.out.println("Залогинились в админку");
	    }
	}

class payVisa{
	
	 public final void method(String number, String month, String year) throws Exception
   {
		 	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src=\"https://yangutu.com/payment/form/pm/cc/fid/29/resource\"]"))); 
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=card_number")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

		    Thread.sleep(7000);
			selenium.type("id=card_number", number);
			selenium.type("id=card_name", "Aliaksandr Siarheyeu");
			selenium.type("id=card_cvv", "***");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//form[@id='ccard-form']/table[2]/tbody/tr[6]/td[2]/div/div/div")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("//form[@id='ccard-form']/table[2]/tbody/tr[6]/td[2]/div/div/div");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link="+month)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("link="+month);
			selenium.click("//td[2]/div[2]/div/div");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link="+year)) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
	        selenium.click("link="+year);
			selenium.type("id=first_name", "Aliaksandr");
			selenium.type("id=last_name", "Siarheyeu");
			selenium.type("id=street", "******");
			selenium.type("id=email","sergey211@gmail.com");
			selenium.type("id=city","Minsk");
			selenium.type("id=state", "Minsk");
			selenium.type("id=zip", "******");
			selenium.type("id=phone", "3333333333");
			selenium.click("//div[7]/input");
			Thread.sleep(10000);
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Profile")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			verifyFalse(selenium.isElementPresent("link=Upgrade"));
			if (selenium.isElementPresent("link=Upgrade"))
			{System.out.print("VIP BY VISA IS NOT ACTIVATED - ");}
			else System.out.print("VIP by visa | PASSED ");
   }
}

class payPayPal{
	
	 public final void method(String login, String pass) throws Exception
    {
		 
			selenium.click("css=img[alt=\"PayPal\"]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("xpath=(//input[@value=''])[4]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("xpath=(//input[@value=''])[4]");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=submitLogin")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.type("id=login_email", login);
			selenium.type("id=login_password", pass);
			selenium.click("id=submitLogin");
	    	for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isTextPresent("You're almost done")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isTextPresent("0.01")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			System.out.println("You're almost done");
			WebElement element;
			element = driver.findElement(By.xpath("//input[@class = 'button primary default parentSubmit noAnimation']"));
			Thread.sleep(7000);
			element.click();
	
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Profile")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			verifyFalse(selenium.isElementPresent("link=Upgrade"));
			if (selenium.isElementPresent("link=Upgrade"))
			{System.out.print("VIP BY PAYPAL IS NOT ACTIVATED - ");}
			else System.out.print("VIP by paypal | PASSED ");
					
			
    }
}	 

class loginDevPayPal{
	
	 public final void method() throws Exception
    {
			selenium.open("https://developer.paypal.com/");

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=login_email")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			selenium.type("id=login_email", "sergey211@gmail.com");
			selenium.type("id=login_password", "12341234a");
			selenium.click("name=submit");
			selenium.waitForPageToLoad("30000");
		 
    }
}	 

class appBuyVIP{
	
	 public final void method() throws Exception
     {
	        //selenium.open("/profile");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Upgrade")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("link=Upgrade");
			selenium.waitForPageToLoad("30000");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=pf-29")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		    selenium.open("http://yangutu.com/payments/vip");
			selenium.click("id=pf-29");
			Thread.sleep(5000);
			selenium.click("id=buy-vip");		 
			for (int second = 0;; second++) {
				if (second >= 100) fail("timeout");
				try { if (selenium.isElementPresent("css=img[alt=\"PayPal\"]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		//	Thread.sleep(10000);

/*	    
        Вывести все имена ифреймов
        
 		System.out.println("Get iframe name 1 :");
		String innerValue = selenium.getEval("selenium.browserbot.getCurrentWindow().$('iframe')[6].src;");
		System.out.println("Iframe name is: " +innerValue);

*/		

//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src=\"https://yangutu.com/payment/form/pm/cc/fid/29/resource\"]"))); 
	
		
/*		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		for (WebElement x : inputs) 
	    {
	    String x2 = x.getAttribute("id");
	    System.out.println("input id = "+x2);
	    String x3 = x.getAttribute("name");
	    System.out.println("input name = "+x3);
	    }
*/

			
     }
}

class appLogin{
	  public final void method(String par) throws Exception
      {
	System.out.println("Открываем главную страницу");
  	selenium.open("/login?lang=en");
  	System.out.println("Логинимся юзером "+par);
		String pass1 = selenium.getExpression("111111");
		driver.findElement(By.xpath("(//input[@id='f_auth_login'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='f_auth_login'])[2]")).sendKeys(par);
		driver.findElement(By.xpath("(//input[@id='f_auth_pass'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='f_auth_pass'])[2]")).sendKeys(pass1);
		driver.findElement(By.xpath("(//input[@id='login_form_submit_spc'])[2]")).click();

}}


@After
public void tearDown() throws Exception {
//selenium.stop();
}
}
