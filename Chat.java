package yangutu_wedbriver;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;

import yangutu.Barrier;
//import yangutu.SeleniumTests;


public class Chat 
extends SeleneseTestNgHelper 
{
	

	
	 protected WebDriver driver;
	 protected LoginPag logn = null;



	@Before

	
	
	 public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        driver = new 
        ChromeDriver();
        //OperaDriver();
        //InternetExplorerDriver();
       // FirefoxDriver();
        logn = new LoginPag(driver);
		//driver = new FirefoxDriver();  
        
    //   String baseUrl = "http://yangutu:usabilityrulit@dev.yangutu.com/";
		String baseUrl = "http://yangutu.com/";
		
	    selenium = new WebDriverBackedSelenium(driver, baseUrl);
	    selenium.setTimeout("120000");
	}
	
	@Test
    public void appChat() throws Exception {

	//String usertochk = "alekta01"; //mailforspam
	String usertochk = "alektasp"; //spam.su
	
	boolean spamsu = false;
	if (usertochk == "alektasp")
	{spamsu=true;}
	Random rand = new Random();
	int randnum = rand.nextInt();
	int n = 1000000;
	randnum = rand.nextInt(n+1);
	
	

	    System.out.println("Проводим проверку чата");
	    System.out.println("Открываем страницу пользователя");
	

	
	//try { 
		
		
		
//		logn.appLoggn("serg02@mailforspam.com");

	    selenium.open("/"+usertochk+"?token=2f0ee42ae866d61ac92f50ae4aca8b67");	
	    //selenium.open("/"+usertochk);

    for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - send message (site)");
		try { if (selenium.isElementPresent("//div[4]/div/div/input")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	System.out.println("Кликаем на Send message");
//	selenium.captureEntirePageScreenshot(chtlocation+"1_opened_user.png", "");
		//selenium.click("link=Send message");
	Thread.sleep(3000);	
	
	selenium.click("//div[4]/div/div/input");
		
	Thread.sleep(1500);
	if (selenium.isTextPresent("Fill in these required fields")) 
		{Barrier bar = new Barrier(selenium); 
		bar.method();
		Thread.sleep(3000);
		selenium.click("link=Send message");}
		
//		ps2.println("Ожидаем загрузки чата");
		System.out.println("Ожидаем загрузки чата");
		Thread.sleep(3000);
		
		
	//	selenium.click("id=chat-now");
	    for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - id = reply is absent");
		try { if (selenium.isElementPresent("id=reply")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	    for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - id = chat_input is absent");
			try { if (selenium.isElementPresent("id=chat_input_text")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

    Thread.sleep(7000);
//	selenium.captureEntirePageScreenshot(chtlocation+"2_opened_chat.png", "");
	System.out.println("Кликаем на инпут");
	selenium.click("id=chat_input_text");
	
//	RandomInt randnum = new RandomInt();
	Thread.sleep(2000);
	System.out.println("Вводим сообщение: Hello! How are you? This is message = "+randnum);
	selenium.typeKeys("id=chat_input_text", "Hello! How are you? This is message = "+randnum);
//	selenium.captureEntirePageScreenshot(chtlocation+"3_message_wrote_"+randnum+".png", "");
	Thread.sleep(3000);
	System.out.println("Жмем на Отправить");
	selenium.click("id=reply");

		Thread.sleep(15000);
   // 	selenium.captureEntirePageScreenshot(chtlocation+"4_message_sent_"+randnum+".png", "");
		System.out.println("Убеждаемся что сообщение отображено");
		verifyTrue(selenium.isTextPresent("Hello! How are you? This is message = "+randnum)); 
		System.out.println("Закрываем чат");
		selenium.click("css=img.cls4"); 
		Thread.sleep(8000);
		System.out.println("Открываем почтовый ящик, проверяем письмо");
		String lang = null;
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout - letter absent at email box");
			try { 
				if (spamsu)
				{selenium.open("http://"+usertochk+".spam.su");}
				else
				selenium.open("http://mailforspam.com/mail/"+usertochk);
				Thread.sleep(5000);
				if 
				(selenium.isTextPresent("You have one new chat message!")) 
				{lang = "en";	
			    break;} 
				if 
				(selenium.isTextPresent("The requested URL could not be retrieved")) {
					//ps.println("The requested URL could not be retrieved");
					System.out.println("The requested URL could not be retrieved");
				break;}
				if 
				(selenium.isTextPresent("У Вас новое сообщение в чате!")) 
				{lang = "ru";	
			    break;} 
			
			} 
			catch 
			
			
			(Exception e) {}
			
			Thread.sleep(1000);}
		    System.out.println("Язык письма: "+lang);
		    if (lang == "en")
			selenium.click("//*[contains(text(),'You have one new chat message!')]");
			if (lang == "ru")
			selenium.click("//*[contains(text(),'У Вас новое сообщение в чате!')]");
			
	//		ps2.println("Открываем письмо, кликаем на кнопку прочесть сообщение");
			System.out.println("Открываем письмо, кликаем на кнопку прочесть сообщение");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - button to open message in letter is absent");
				try { if (selenium.isElementPresent("//img[contains(@src,'yangutu.com/img/buttons/blue_readmessage.png')]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Thread.sleep(2000);
   		    selenium.click("//img[contains(@src,'yangutu.com/img/buttons/blue_readmessage.png')]");
 		    System.out.println("Ожидаем открытия чата с проверкой сообщения с числом "+randnum);
  	//		ps2.println("Ожидаем открытия чата с проверкой сообщения с числом "+randnum);
	//		String str = "absentos";
 		    for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - message with "+randnum+" is absent");
				try { 
					if (selenium.isTextPresent(""+randnum)) 
				//	if (selenium.isTextPresent("Hello! How are you? This is message = "+randnum)) 
				//	if	(selenium.isElementPresent("//*[contains(text(),'Hello! How are u? This is message ='+randnum)]"))
				//	if	(selenium.isElementPresent("//*[contains(text()'Hello! How are you? This is message = "+randnum+"')]"))
										
						break; } catch (Exception e) {}
				
			//if	(selenium.isElementPresent("//*[contains(text(),'Hello! How are u? This is message ='+randnum)]"))
				
				Thread.sleep(1000);}

	
	
 		   System.out.println("+CHAT | PASSED");
	//ps.println("+chat "+usertochat+" | PASSED");

 //   } catch    (Throwable e)   { System.out.println("!CHAT | FAILED: "+e);}}
	}	 

	@After
	public void tearDown() throws Exception {
	selenium.stop();
	}
}


