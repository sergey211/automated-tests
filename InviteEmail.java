package yangutu_wedbriver;



import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class InviteEmail {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new 
		ChromeDriver();
		baseUrl = "http://yangutu.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		
		Random rand = new Random();
		int randnum = rand.nextInt();
		int n = 1000;
		randnum = rand.nextInt(n+1);
		driver.get(baseUrl + "/invite?token=2f0ee42ae866d61ac92f50ae4aca8b67");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//img[@alt='other tools']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//img[@alt='other tools']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.linkText("Send email invitation"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Send email invitation")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//input[@value='Send invitation']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(randnum+"@spam.su");
		driver.findElement(By.xpath("//input[@value='Send invitation']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//*[contains(text(),'has been sent')]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//img[@alt='other tools']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.xpath("//img[@alt='other tools']")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.linkText("Send email invitation"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.linkText("Send email invitation")).click();
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//input[@value='Send invitation']"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(randnum+"@spam.su");
		driver.findElement(By.xpath("//input[@value='Send invitation']")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (isElementPresent(By.xpath("//*[contains(text(),'You already sent invitation to this email')]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		for (int second = 0;; second++) {
			if (second >= 10) fail("timeout - letter absent at email box");
			try { 

				driver.get("http://"+randnum+".spam.su");
				Thread.sleep(5000);
				if 
				(isElementPresent(By.xpath("//*[contains(text(),'You were invited to Yangutu.com')]"))) break; 
		
  	  
    } catch
    (Throwable e) {}
	}
		driver.findElement(By.xpath("//*[contains(text(),'You were invited to Yangutu.com')]")).click();
			for (int second = 0;; second++) {
			if (second >= 60) fail("timeout - button accept found");
			try { if (isElementPresent(By.xpath("//img[contains(@src,'img/buttons/aceptinvit.png')]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[contains(@src,'yangutu.com/img/buttons/aceptinvit.png')]")).click();
		for (int second = 0;; second++) {
		if (second >= 60) fail("timeout - link f2f");
		try { if (isElementPresent(By.xpath("//a[contains(@href,'face-to-face')]"))) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
		
		//driver.findElement(By.xpath("//a[@href,'/face-to-face/']"));
		System.out.println("+INVITES | PASSED"); 
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
