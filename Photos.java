package yangutu_wedbriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;


import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class Photos extends  SeleneseTestNgHelper {
	
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
		selenium.setTimeout("120000");}
		
@Test
public void appPhotos() throws Exception {


	   {
	       	

		    System.out.println("Проводим проверку загрузки фото");
		//  logn.appLoggn("serg02@mailforspam.com");
		//	selenium.click("link=Profile");
		    selenium.open("/profile?token=2f0ee42ae866d61ac92f50ae4aca8b67");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - add photo link not found");
				try { if (selenium.isElementPresent("css=div.addphoto > span")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		    Thread.sleep(3000);
		    boolean levph = false;
		    if (selenium.isElementPresent("//img[@width='65' and @height='89']"))
		    {
		    System.out.println("Удаляем левую фотку");
		    selenium.click("//img[@width='65' and @height='89']");	
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - 'edit' not found");
				try { if (selenium.isElementPresent("link=Edit this photo")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
			selenium.click("link=Edit this photo");
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - 'delete' after 'edit' not found");
				try { if (selenium.isElementPresent("id=ph-delete")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("id=ph-delete");
			Thread.sleep(2000);
			selenium.click("css=img[alt=\"Close\"]");
			if (selenium.isElementPresent("//img[@width='65' and @height='89']"))
			{System.out.println("Все равно еще осталась");
			levph = true;}
			else System.out.println("Удалили");
		    }
			
		    
			selenium.click("css=div.addphoto > span");

			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Classic uploader")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			selenium.click("link=Classic uploader");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("name=Filedata")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			//WARNING: You should be using attachFile to set the value of a file input element
		//	selenium.click("name=Filedata");
		//	File file = new File ("D:\\Tagged M\\ M 0478.jpg");
		//	selenium.attachFile("name=Filedata", "D:\\Tagged M\\ M 0478.jpg");
			selenium.type("name=Filedata", "D:\\Tagged M\\ M 0478.jpg");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//input[@value='Upload']")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			selenium.click("//input[@value='Upload']");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=html4_upload_finish")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(3000);
			selenium.click("id=html4_upload_finish");
			selenium.refresh();
			if (selenium.isElementPresent("//img[@width='65' and @height='89']"))
			{
			System.out.println("Успешно добавлена");}
			else System.out.println("Не добавлена!");
			selenium.click("//img[@width='216px']");
			Thread.sleep(5000);
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - next photo link not found");
				try { if (selenium.isElementPresent("css=a[title=\"Next photo\"] > span")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			Thread.sleep(3000);
			selenium.click("css=a[title=\"Next photo\"] > span");
			Thread.sleep(5000);
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - 'edit' after 'next' not found");
				try { if (selenium.isElementPresent("link=Edit this photo")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
			selenium.click("link=Edit this photo");
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout - 'delete' after 'edit' not found");
				try { if (selenium.isElementPresent("id=ph-delete")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("id=ph-delete");
			Thread.sleep(2000);
			selenium.click("css=img[alt=\"Close\"]");
			Thread.sleep(3000);
			if ((selenium.isElementPresent("//img[@width='65' and @height='89']"))&&(levph == false))	
			{System.out.println("Фотка не удалилась!");
			}
			else System.out.println("Фотка успешно удалена");
			System.out.println("+PHOTOS | PASSED"); 
	//   } catch  (Throwable e)  {ps.println("!photos | FAILED : "+e);

	}}

@After
public void tearDown() throws Exception {
selenium.stop();
}
}
		