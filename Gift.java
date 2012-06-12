package yangutu_wedbriver;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;

public class Gift extends SeleneseTestNgHelper {
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
	
	@Test

public void appGift() throws Exception {


	
//try {	

//	LoginPage login = new LoginPage(selenium);

	logn.appLoggn("sergey@spam.su");
	
	selenium.open("/alektasp");
	
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link to add gift not found");
		try { if (selenium.isElementPresent("//img[contains(@src,'vgift_00.jpg')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	selenium.click("//img[contains(@src,'vgift_00.jpg')]");
//	selenium.waitForPageToLoad("30000");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link romance gifts not found");
		try { if (selenium.isElementPresent("link=Romance")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	Thread.sleep(5000);
/*	selenium.captureEntirePageScreenshot(giftlocation+"1_all_gifts_opened.png", "");
	selenium.click("link=Romance");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"2_romance_gifts_opened.png", "");
	selenium.click("link=Toys");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"3_toys_gifts_opened.png", "");
	selenium.click("link=Jewelry");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"4_jewelry_gifts_opened.png", "");
	selenium.click("link=Jokes");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"5_jokes_gifts_opened.png", "");
	selenium.click("link=Flowers");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"6_flowers_gifts_opened.png", "");
	selenium.click("link=Food and drinks");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"7_food_gifts_opened.png", "");
	selenium.click("link=Sport and hobbies");
	Thread.sleep(2000);
	selenium.captureEntirePageScreenshot(giftlocation+"8_sport_gifts_opened.png", "");
	selenium.click("link=All");
	Thread.sleep(2000);
*/	
    
	Random rand = new Random();
	int randnum = rand.nextInt(86+1);
	
	selenium.click("//li["+randnum+"]/a/img");
//	selenium.click("//img[contains(@src,'/img/gift/vgift_13.jpg')]");
	Thread.sleep(2000);
	
	
	selenium.type("//*[@id='vgift-text']", "Hello "+randnum+"!");
	//selenium.captureEntirePageScreenshot(giftlocation+"9_gift_chozen.png", "");
	selenium.click("//input[@value='Send your gift now!']");
/*	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link romance gifts not found");
		try { if (selenium.isElementPresent("id=paymentButton")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	selenium.click("id=paymentButton");
	
*/	Thread.sleep(7000);
	if (selenium.isElementPresent("//input[@value='Buy Now']")) 
		{selenium.click("//input[@value='Buy Now']");
	    Thread.sleep(7000);
		}

	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - gift present");
		try { if (selenium.isElementPresent("//img[contains(@src,'/img/gift/vgift_"+randnum+".jpg')]")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	System.out.println("Подарок отображен на странице");
	if (selenium.isElementPresent("//img[contains(@src,'/img/gift/vgift_1.jpg')]"))
	{System.out.println("левый тоже отображен на странице");}
	System.out.println("Открываем почтовый ящик");
	for (int second = 0;; second++) {
		if (second >= 20) fail("timeout - letter is absent");
		try { 
			selenium.open("http://alektasp.spam.su");
			Thread.sleep(5000);
			if 
			(selenium.isElementPresent("//*[contains(text(),'Somebody sent you a virtual gift at')]")) 
			{	System.out.println("Письмо найдено, открываем");	
			break;}
			if 
			(selenium.isTextPresent("The requested URL could not be retrieved")) {
			System.out.println("The requested URL could not be retrieved");
			break;}
		} 
		catch 
		(Exception e) {}
		System.out.println("Ждём письма от Yangutu");
		Thread.sleep(1000);}
		selenium.click("//*[contains(text(),'Somebody sent you a virtual gift at')]");
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - button unwrap");
			try { if (selenium.isElementPresent("//img[contains(@src,'/img/buttons/unwrap.png')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		System.out.println("Кнопку нашли, ищем строку с цифрой "+randnum);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - text + random");
			try { if (selenium.isTextPresent("Hello "+randnum)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		System.out.println("Текстовое сообщение в письме правильное");
		selenium.click("//img[contains(@src,'/img/buttons/unwrap.png')]");
		System.out.println("Кликнули по кнопке в письме");
		Thread.sleep(5000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - text sent a gift");
			//try { if (selenium.isElementPresent("//*[contains(text(),'Sent a virtual gift to you')]")) break; } catch (Exception e) {}
			try { if (selenium.isTextPresent("Sent a virtual gift to you")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		System.out.println("Открыли страницу с данным сигналом");
		
 // ps.println("+gifts | PASSED"); 
  System.out.println("+GIFTS | PASSED"); 
//} catch (Throwable e){	System.out.println("Gifts | FAILED : "+e);}
}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}
	