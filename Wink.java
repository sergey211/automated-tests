package yangutu_wedbriver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class Wink extends SeleneseTestNgHelper {
	
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
	
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.setTimeout("180000");}
		
//@Ignore
@Test
public void appWink() throws Exception {
	//String usertochk = "alekta01"; //mailforspam
	String usertochk = "alektasp"; //spam.su
	
	boolean spamsu = false;
	if (usertochk == "alektasp")
	{spamsu=true;}
	
	System.out.println("Проводим проверку WINK");
	selenium.open("/debug/test/abcdef?usa=bil&x=wink");
  //  logn.appLoggn("serg02@mailforspam.com");
    	System.out.println("Открываем страницу юзера");
		selenium.open("/"+usertochk+"?token=2f0ee42ae866d61ac92f50ae4aca8b67");
		System.out.println("Ищем ссылку на винк");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//li/input")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		System.out.println("Делаем wink");
		selenium.click("//li/input");
//		if (selenium.isTextPresent("Fill in these required fields")) 
//		{Barrier bar = new Barrier(selenium); bar.method();Thread.sleep(3000);selenium.click("link=Wink");} 

/*		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("You winked at")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		System.out.println("Делаем wink еще раз");
*/
		selenium.click("//li/input");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isTextPresent("You can't wink at one and same user more than once a month")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		

  /*  	if (spamsu) 
    	{
    	System.out.println("Проверяем емейл на spam.su");}	 
    	else System.out.println("Проверяем емейл на mailforspam.com");
 		System.out.println("Открываем почтовый ящик, ждем письма");
 		String lang = null;
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout - letter absent at email box");
			try { 
			if (spamsu)
		{selenium.open("http://"+usertochk+".spam.su");}
		else
		{selenium.open("http://mailforspam.com/mail/"+usertochk);}
		Thread.sleep(5000);
		if 
		(selenium.isTextPresent("Somebody has winked at you")) 
		{	lang = "en";	
			break; }
		if 
		(selenium.isTextPresent("The requested URL could not be retrieved")) {
		System.out.println("The requested URL could not be retrieved");
		break;}
		if 
		(selenium.isTextPresent("Кто-то подмигнул Вам")) 
		{	lang = "ru";	
		break; }
		} 
		catch 
		(Exception e) {}
		Thread.sleep(1000);}
	    System.out.println("Язык письма: "+lang);
		if (lang == "en")
				selenium.click("//*[contains(text(),'Somebody has winked at you')]");
				if (lang == "ru")
				selenium.click("//*[contains(text(),'Кто-то подмигнул Вам')]");
				
			System.out.println("Письмо найдено - открываем его");
			System.out.println("Кликаем на кнопку Wink back");
			for (int second = 0;; second++) {
				if (second >= 200) fail("timeout - wink back button is absent");
				//try { if (selenium.isElementPresent("//img[contains(@src,'http://yangutu.com/img/buttons/blue_winkback.png')]")) break; } catch (Exception e) {}
				try { if (selenium.isElementPresent("//img[contains(@alt,'Wink back')]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			selenium.click("//img[contains(@alt,'Wink back')]");
			System.out.println("Ожидаем открытия профиля юзера" //+
				//	" с уведомлением что мы ему винкнули"
					);
			Thread.sleep(2000);
			for (int second = 0;; second++) {
				if (second >= 20) fail("timeout - opening profile");
				try { if (selenium.isElementPresent("//input[@value='Wink']")) break; } catch (Exception e) {}
				Thread.sleep(1000);}
			
			
 /*		    if (lang == "en"){
  			for (int second = 0;; second++) {
				if (second >= 20) fail("timeout - text i winked at");
				try { if (selenium.isTextPresent("You winked at")) break; } catch (Exception e) {}
				Thread.sleep(1000);}}
  		   
  		    if (lang == "ru"){
  	  			for (int second = 0;; second++) {
  					if (second >= 20) fail("timeout - text i winked at");
  					try { if (selenium.isTextPresent("Вы подмигнули")) break; } catch (Exception e) {}
  					Thread.sleep(1000);}}
*/		
			
  		  System.out.println("+WINK | PASSED");
   	} 
//catch	(Throwable e){ps.println("!WINK | FAILED: "+e);}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}

	