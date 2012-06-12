package yangutu_wedbriver;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.SeleneseTestNgHelper;





@SuppressWarnings("unused")
public class RegRandom extends 
SeleneseTestNgHelper
{
	
	private WebDriver driver;
	@Before
	//Class
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        driver = new 
        ChromeDriver();
	    // OperaDriver();
	    // ChromeDriver();
	 String baseUrl = "http://yangutu.com/";
	 selenium = new WebDriverBackedSelenium(driver, baseUrl);	
	 selenium.setTimeout("300000");}

//@Ignore
@Test
public void appRegRand() throws Exception {

  boolean spamsu = true;

 
	Random rand = new Random();
	int randnum = rand.nextInt();
	int n = 1000;
	randnum = rand.nextInt(n+1);
  

		if (spamsu == true)
		{System.out.println("Регистрируем пользователя test"+randnum+"@spam.su");}
	    else
 	    {System.out.println("Регистрируем пользователя test"+randnum+"@mailforspam.com");}

    	System.out.println("Открываем главную страницу");
		selenium.open("http://yangutu.com?lang=en");
		

		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - reg popup");
			try { if (selenium.isElementPresent("css=input.rendez_startbut.ygPopup")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(5000);
		selenium.click("css=input.rendez_startbut.ygPopup");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - sign in button");
			try { if (selenium.isElementPresent("//form[@id='signupform']/div[8]/input")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(5000);
		
		System.out.println("Вводим е-мейл");
		if (spamsu == true)
			{selenium.type("email", "test"+randnum+"@spam.su");}
		else
		{selenium.type("email", "test"+randnum+"@mailforspam.com");}
		System.out.println("Вводим имя");
		selenium.type("first_name", "elena");
		System.out.println("Вводим пароль");
		selenium.type("password", "111111");
		System.out.println("Вводим дату рождения");
		selenium.click("//form[@id='signupform']/div[3]/div[2]/div/div[2]/div/div");
		selenium.click("//a[contains(text(),'January')]");
  		selenium.click("//form[@id='signupform']/div[3]/div[2]/div/div/div/div");
		selenium.click("link=4");
		selenium.click("//form[@id='signupform']/div[3]/div[2]/div/div[3]/div/div");
   		selenium.click("link=1910");
		selenium.click("name=interestedto[]");
		selenium.click("id=select-from-list");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Belarus")) break; } catch (Exception e) {System.out.println(e);}
			Thread.sleep(1000);
		}

		selenium.click("link=Belarus");
		
		System.out.println("Выбираем регион");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Minskaya Voblasts'")) break; } catch (Exception e) {System.out.println(e);}
			Thread.sleep(1000);
		}
		
		System.out.println("Выбираем область");
    	selenium.click("link=Minskaya Voblasts'");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Minsk")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		System.out.println("Выбираем город");
		selenium.click("link=Minsk");
		selenium.click("id=cityOk");
		
		Thread.sleep(2000);
		System.out.println("Жмём кнопку для продолжения");
		selenium.click("//form[@id='signupform']/div[8]/input");
		Thread.sleep(2000);

		if (selenium.isTextPresent("already exists"))
				{
			
			randnum = rand.nextInt(n+1);
			if (spamsu == true)
			{System.out.println("Уже существует, поэтому пробуем test"+randnum+"@spam.su");
			selenium.type("email", "test"+randnum+"@spam.su");}
		    else
	 	    {System.out.println("Уже существует, поэтому пробуем test"+randnum+"@mailforspam.com");
	 	     selenium.type("email", "test"+randnum+"@mailforspam.com");}
			Thread.sleep(2000);
			System.out.println("Жмём кнопку для продолжения");
			selenium.click("//form[@id='signupform']/div[8]/input");
				}
				
				
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - resend button");
			try { if (selenium.isElementPresent("document.forms[2].elements[0]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		System.out.println("Открываем почтовый ящик");
		for (int second = 0;; second++) {
			if (second >= 20) fail("timeout - letter is absent");
			try { 
				
				if (spamsu == true)
				{selenium.open("http://test"+randnum+".spam.su");}
				else
				{selenium.open("http://mailforspam.com/mail/test"+randnum+"/");}
				Thread.sleep(5000);
				if 
				(selenium.isElementPresent("//*[contains(text(),'Please confirm your email address')]")) 
					
			break;
			
				if 
				(selenium.isTextPresent("The requested URL could not be retrieved")) {
					System.out.println("The requested URL could not be retrieved");
					break;}
				
			} 
			catch 
			
			
			(Exception e) {}
			System.out.println("Ждём письма от Yangutu");
			Thread.sleep(1000);}
			selenium.click("//*[contains(text(),'Please confirm your email address')]");
			System.out.println("Открываем письмо, кликаем на ссылку активации");
			for (int second = 0;; second++) {
				if (second >= 200) fail("timeout - text in letter is absent");
				try { if (selenium.isTextPresent("Congratulations on joining Yangutu")) break; } catch (Exception e) {}
				Thread.sleep(1000);}
		   	    selenium.click("//a[contains(@href, 'yangutu.com/signup/confirm')]");
	   System.out.println("Переходим к поиску");
     
		       		Thread.sleep(10000);				    
	    System.out.println("+RegRandomEmail | PASSED");
			if (spamsu == true)
			{//ps.println("+register test"+randnum+"@spam.su | PASSED");
			} else
			{
				//ps.println("+register" +randnum+"@mailforspam.com | PASSED");
			}

	//} catch (Throwable e){ps.println("!register | FAILED: "+e);}
	}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}

	