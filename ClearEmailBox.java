package yangutu_wedbriver;



import com.thoughtworks.selenium.SeleneseTestNgHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClearEmailBox extends SeleneseTestNgHelper {
	protected WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new 
        ChromeDriver();
		String baseUrl = "http://alektasp.spam.su/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void clearspamsu() throws Exception {
		selenium.open("/");	
		for (int second = 1;second<10; second++) {

			if (selenium.isElementPresent("link=Удалить")) 
			{selenium.click("link=Удалить");
			System.out.println("Нажали удалить "+second+" раз");
			Thread.sleep(3000);}
			else 
			{	System.out.println("Sector clear");
				break;
			}	
		}
		}
	

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}