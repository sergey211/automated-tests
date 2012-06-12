package yangutu_wedbriver;
//import java.io.File;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class Icebrakers extends SeleneseTestNgHelper {
	
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
		
		//String baseUrl = "http://yangutu:usabilityrulit@dev.yangutu.com/";
		String baseUrl = "http://yangutu.com/";
		
		selenium = new WebDriverBackedSelenium(driver, baseUrl);}
		

@Test
public void appIcebr() throws Exception {
	
	
	//String usertochk = "alekta01"; //mailforspam
	String usertochk = "alektasp"; //spam.su
	
	boolean spamsu = false;
	if (usertochk == "alektasp")
	{spamsu=true;}
	
	Random rand1 = new Random();
      System.out.println("Проверяем Айсбрейкеры");
     // logn.appLoggn("serg02@mailforspam.com");
  	  System.out.println("Открываем страницу юзера");
  	  selenium.open("/"+usertochk+"?token=2f0ee42ae866d61ac92f50ae4aca8b67");
  	  System.out.println("Ищем ссылку на отправку айсбрейкера");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - link send icebr at profile");
			try { if (selenium.isElementPresent("//li[2]/input")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		System.out.println("Кликаем по ней");
		selenium.click("//li[2]/input");
		System.out.println("Ждем попапа");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - questions form");
			try { if (selenium.isElementPresent("css=div.selectedTxt")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(7000);
		selenium.click("css=div.selectedTxt");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - link=Communication");
			try { if (selenium.isElementPresent("link=Communication")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		selenium.click("link=Communication");
		Thread.sleep(5000);
		for (int second = 0;; second++) {
		
			if (second >= 50) fail("timeout - link send icebr at profile");
			try { 
				int randice = rand1.nextInt(22);
				randice++;
				int iceid = randice+150;
				System.out.println(iceid);
				driver.findElement(By.xpath("//input[@name='questionId' and @value='"+iceid+"']")).click(); break; } catch (Exception e) {}
			
		}
		
		Thread.sleep(4000);
		String questn = selenium.getText("selected-q-text");
		System.out.println(questn);
		System.out.println("Жмем - отправить");
		selenium.click("id=ice-ask");
		System.out.println("Нажали, ждем подтверждения что айсбрейкер отправлен");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - successfully sent ");
			try { if (selenium.isTextPresent("successfully sent")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		
    
    	 if (spamsu) 
    	 {
    	 System.out.println("Проверяем емейл на spam.su");}	 
    	 else System.out.println("Проверяем емейл на mailforspam.com");
		System.out.println("Открываем почтовый ящик");
		System.out.println("Ждём письма от Yangutu");
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout - letter absent at email box");
			try { 
				if (spamsu)
				{selenium.open("http://"+usertochk+".spam.su");}
				else
				{selenium.open("http://mailforspam.com/mail/"+usertochk);}
				Thread.sleep(5000);
				if 
				(selenium.isTextPresent("You have new icebreaker questions!")) break; 
				if 
				(selenium.isTextPresent("The requested URL could not be retrieved")) {
				System.out.println("The requested URL could not be retrieved");
				break;
			}
  	  
    } catch
    (Throwable e) {}
	Thread.sleep(1000);}
		selenium.click("//*[contains(text(),'You have new icebreaker questions!')]");
		System.out.println("Открываем письмо, кликаем на кнопку Ответить на айсбрейкеры");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - button answer icebr in letter not found");
			try { if (selenium.isElementPresent("//img[contains(@src,'img/buttons/blue_answericebreaker.png')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		selenium.click("//img[contains(@src,'yangutu.com/img/buttons/blue_answericebreaker.png')]");
		System.out.println("Ожидаем открытия страницы с полученными айсбрейкерами");
		Thread.sleep(5000);
		for (int second = 0;; second++) {
			if (second >= 30) fail("timeout opening page from letter");
			try { if (selenium.isTextPresent(questn)) 
			//	System.out.println(questn);
				break; } catch (Exception e) {}
			Thread.sleep(1000);}
		Thread.sleep(7000);
		System.out.println("+ICEBREAKERS | PASSED");
    //}catch(Throwable e) { System.out.println("!ICEBRAKERS | FAILED : "+e);}
    }	@After
	public void tearDown() throws Exception {
    	selenium.stop();
    	}
    }

  
  	  	
		
	
	


		