package yangutu_wedbriver;
//import yangutu.SeleniumTests;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.SeleneseTestNgHelper;



public class ProfilePersInfo extends SeleneseTestNgHelper {
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
public void appPers() throws Exception {

/*	String tstlocation = "c:\\tests\\";	
	File f = new File(tstlocation+"persinfo");
	try{
		if(f.mkdir())
		System.out.println("Directory Created");
		else
		System.out.println("Directory is not created");
		}catch(Exception e){
		e.printStackTrace();
		}
	String persinflocation = tstlocation+"persinfo\\";
*/	//try
	//{
	System.out.println("+++ПРОВОДИМ ТЕСТ persinfo+++");
//	ps2.println("Открываем главную страницу приложения");
	System.out.println("Открываем главную страницу приложения");

	/*
	PersonalInfo pers = new PersonalInfo(); 
	pers.method();
	*/


//	logn.appLoggn("sergey@spam.su");
	selenium.open("/profile?token=2f0ee42ae866d61ac92f50ae4aca8b67");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("id=edit-basic-link")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}
	Thread.sleep(3000);
	//selenium.captureEntirePageScreenshot(persinflocation+"1_personal_info.png", "");
	selenium.click("id=edit-basic-link");
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("id=submit")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

	Thread.sleep(5000);
	for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (selenium.isElementPresent("//form[@id='userPersonalInformation']/div[2]/div[3]/div[2]/div/div")) break; } catch (Exception e) {}
		Thread.sleep(1000);
	}

//	selenium.click("//form[@id='userPersonalInformation']/div[2]/div[3]/div[2]/div/div");
//	selenium.click("link=February");
	selenium.click("//form[@id='userPersonalInformation']/div[2]/div[3]/div[2]/div/div");
	selenium.click("link=3");
	selenium.click("//form[@id='userPersonalInformation']/div[2]/div[3]/div[2]/div[2]/div");
	selenium.click("link=July");
	selenium.click("//form[@id='userPersonalInformation']/div[2]/div[3]/div[2]/div[3]/div");
	selenium.click("link=1982");
	selenium.click("//form[@id='userPersonalInformation']/div[2]/div[4]/div[2]/div/div");
	selenium.click("link=Christian");
	selenium.click("id=languages-333");
	selenium.click("//form[@id='userPersonalInformation']/div[4]/div/div[2]/div/div");
	selenium.click("link=Single");
	selenium.click("//form[@id='userPersonalInformation']/div[4]/div[2]/div[2]/div/div");
	selenium.click("link=Never married");
	selenium.click("//form[@id='userPersonalInformation']/div[4]/div[3]/div[2]/div/div");
	selenium.click("link=No");
	selenium.click("//form[@id='userPersonalInformation']/div[4]/div[4]/div[2]/div/div");
	selenium.click("link=Disagree");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div/div[2]/div/div");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div/div[2]/div/div");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div/div[2]/div/div");
	selenium.click("link=White / Caucasian");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[6]");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[2]/div[2]/div/div");
	selenium.click("link=171 cm");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[3]/div[2]/div/div");
	selenium.click("link=63 kg");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[4]/div[2]/div/div");
	selenium.click("link=Athletic");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[5]/div[2]/div/div");
	selenium.click("link=Black");
	selenium.click("//form[@id='userPersonalInformation']/div[6]/div[6]/div[2]/div/div");
	selenium.click("link=Blue");
	selenium.click("//form[@id='userPersonalInformation']/div[8]/div/div[2]/div/div");
	selenium.click("link=Dormitory");
	selenium.click("//form[@id='userPersonalInformation']/div[8]/div[2]/div[2]/div/div");
	selenium.click("//form[@id='userPersonalInformation']/div[8]/div[2]/div[2]/div/div[2]/ul/li[3]/a");
	selenium.click("id=pets-482");
	selenium.click("id=pets-485");
	selenium.click("id=pets-487");
	selenium.click("//form[@id='userPersonalInformation']/div[8]/div[7]/div[2]/div/div");
	selenium.click("link=Up to $10,000 per year");
	selenium.click("//form[@id='userPersonalInformation']/div[10]/div/div[2]/div/div");
	selenium.click("link=No formal education");
	selenium.click("//form[@id='userPersonalInformation']/div[10]/div[2]/div[2]/div/div");
	selenium.click("link=Biological sciences");
	selenium.click("//form[@id='userPersonalInformation']/div[10]/div[3]/div[2]/div/div");
	selenium.click("link=Clerical/administrative");
	selenium.click("//form[@id='userPersonalInformation']/div[12]/div/div[2]/div/div");
	selenium.click("link=Many times a day");
	selenium.click("id=drinkprefer-799656");
	selenium.click("id=drinkprefer-799658");
	selenium.click("id=drinkprefer-799661");
	selenium.click("id=drinkprefer-799663");
	selenium.click("//form[@id='userPersonalInformation']/div[12]/div[3]/div[2]/div/div");
	selenium.click("xpath=(//a[contains(text(),'Many times a day')])[2]");
	selenium.click("id=dontLikeSmokers");


	//selenium.captureEntirePageScreenshot(persinflocation+"2_personal_info_edited.png", "");
	selenium.click("id=submit");
	Thread.sleep(7000);
	//selenium.captureEntirePageScreenshot(persinflocation+"3_personal_info_saved.png", "");



	System.out.println("+PROFILE - PERSONAL INFORMATION | PASSED");
	
	//ps.println("+persinfo | PASSED");
	//} catch	(Throwable e)	{	System.out.println("Ошибка: "+e);	
	}
@After
public void tearDown() throws Exception {
selenium.stop();
}
}	