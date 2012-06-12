package yangutu_wedbriver;


	
	import org.junit.*;
	
	import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.selenesedriver.FindElements;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlLink;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
*/
import com.thoughtworks.selenium.SeleneseTestNgHelper;


	   
	    public class MailCheck extends SeleneseTestNgHelper  {
		private WebDriver driver;
		private String baseUrl;
		private StringBuffer verificationErrors = new StringBuffer();
		@Before
		public void setUp() throws Exception {
			
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			driver = new 
	        ChromeDriver();
			//InternetExplorerDriver();
			//driver = new OperaDriver();
			baseUrl = "http://e.mail.ru/cgi-bin/login";
			selenium = new WebDriverBackedSelenium(driver, baseUrl);
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
			
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			String baseUrl = "https://login.live.com/";
			selenium = new WebDriverBackedSelenium(driver, baseUrl);
			selenium.setTimeout("500000");
			
		}
		//@Ignore
		@Test
		public void testMailChecks() throws Exception {
		
			MailruClear mailru = new MailruClear();
			GmailClear gmail = new GmailClear();
			HotmailClear hotmail = new HotmailClear();
	//		Hotmail2Clear hotmail2 = new Hotmail2Clear();
			YahooClear yahoo = new YahooClear();
			YandexClear yandex = new YandexClear();
			AolClear aol = new AolClear();
			RegEmail reg = new RegEmail(selenium);
		
			driver.get("http://yangutu.com//debug/test/abcdef?usa=bil&x=yangututest");
//			hotmail2.clear();

			yandex.clear();
			gmail.clear();
			mailru.clear();
			aol.clear();
			hotmail.clear();
			yahoo.clear();
			reg.appReg("yangututest@yahoo.com");
	    	reg.appReg("yangututest@hotmail.com");
			reg.appReg("yangututest@aol.com");
			reg.appReg("yangututest@yandex.ru");
			reg.appReg("yangututest@mail.ru");
			reg.appReg("yangututest@gmail.com");
			hotmail.check();
			aol.check();
			yandex.check();
			mailru.check();
			gmail.check();
			yahoo.check();
			driver.get("http://yangutu.com//debug/test/abcdef?usa=bil&x=yangututest");
	}		
			
class MailruClear{
				
				public void check()  throws Exception {
					try{
						driver.get("http://e.mail.ru/cgi-bin/msglist");	
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox link");
							try { if (isElementPresent(By.cssSelector("span.menu__item__link__text.menu__item__link__text_linear"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
						Thread.sleep(5000);

						
						if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
						{System.out.println("mail.ru | PASSED | INBOX"); }
						else
						{
							driver.findElement(By.cssSelector("#folder950 > span.menu__item__link__text.menu__item__link__text_linear")).click();
							for (int second = 0;; second++) {
								if (second >= 60) fail("timeout inbox checkbox");
								try { if (isElementPresent(By.name("mainCheck"))) break; } catch (Exception e) {}
								Thread.sleep(1000);
							}
							Thread.sleep(5000);	
							if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
							{System.out.println("mail.ru | PASSED | SPAM"); }
							else System.out.println("mail.ru | FAILED");
							
	
						}}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@mail.ru : "+e.toString()); }}
						
				
				
				
				 public void clear() throws Exception
			   {
			System.out.println("Чистим ящик на mail.ru");
			try {
			driver.get("http://e.mail.ru/cgi-bin/login");
		//	driver.findElement(By.id("mailbox__placeholder_login")).click();
			driver.findElement(By.id("login")).clear();
			driver.findElement(By.id("login")).sendKeys("yangututest");
			driver.findElement(By.id("password")).click();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("12341234a");
			driver.findElement(By.id("EnterBtn")).click();
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout inbox link");
				try { if (isElementPresent(By.cssSelector("span.menu__item__link__text.menu__item__link__text_linear"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
		//	if ((isElementPresent(By.id("id-messages-list-empty"))==false))
		//	{if("В данной папке писем нет".equals(driver.findElement(By.id("id-messages-list-empty")).getText())==false)
		//	{	
			driver.findElement(By.name("mainCheck")).click();
			driver.findElement(By.linkText("Удалить")).click();
			Thread.sleep(5000);
		//	}}
		
			driver.findElement(By.cssSelector("#folder950 > span.menu__item__link__text.menu__item__link__text_linear")).click();
			Thread.sleep(5000);
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout inbox checkbox");
				try { if (isElementPresent(By.name("mainCheck"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
			
			
//			if (isElementPresent(By.id("id-messages-list-empty"))) 
//				if ("В данной папке писем нет".equals(driver.findElement(By.id("id-messages-list-empty")).getText())==false)
//				{
			
			
	//		driver.findElement(By.id("mailru-webagent-gen-30")).click();
	//		System.out.println("Кликнули один раз по чекбоксу");
	//		Thread.sleep(2000);
	//		if ("Выделить все".equals(driver.findElement(By.id("mailru-webagent-gen-30")).getAttribute("title")))
	//		{
	//		System.out.println("Чекбокс выключен, включаем");
			driver.findElement(By.name("mainCheck")).click();
	//		}
		
	//		else{System.out.println("Чекбокс включен");}
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Удалить")).click();
			Thread.sleep(5000);
	//			}
			System.out.println("Почистили ящик на mail.ru");
			}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@mail.ru : "+e.toString()); }}}

class GmailClear{
			
	
			public void check()  throws Exception {
				try{
			
					
					
					driver.get("http://mail.google.com/");	
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox link");
						try { if (isElementPresent(By.xpath("//a[contains(text(),'Входящие')]"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(5000);
					if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
					{System.out.println("gmail.com | PASSED | INBOX"); }
					else
					{
						driver.findElement(By.xpath("//a[contains(text(),'Спам')]")).click();
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout spam checkbox");
							try { if (isElementPresent(By.name("nvp_a_dl"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
						Thread.sleep(5000);	
						if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
						{System.out.println("gmail.com | PASSED | SPAM"); }
						else System.out.println("gmail.com | FAILED");
					}
				}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@gmail.com : "+e.toString()); }}
			
			public void clear() throws Exception {
				
				System.out.println("Чистим ящик на gmail.com");
			
				
				try{
				driver.get("https://mail.google.com/mail/h/vnpyhxn9a5jp/?pli=1&zy=g&shva=1&f=1&shva=1");
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout signin");
					try { if (isElementPresent(By.id("signIn"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				driver.findElement(By.id("Email")).clear();
				driver.findElement(By.id("Email")).sendKeys("yangututest");
				driver.findElement(By.id("Passwd")).clear();
				driver.findElement(By.id("Passwd")).sendKeys("12341234a");
				driver.findElement(By.id("signIn")).click();
				
		
			     
				
			for (int second = 0;; second++) {
					if (second >= 60) fail("timeout inbox link");
					try { if (isElementPresent(By.xpath("//a[contains(text(),'Входящие')]"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
			//	System.out.println("Зашли во входящие"); 
				Thread.sleep(5000);
				 if (isElementPresent(By.xpath("//table[2]/tbody/tr/td/input")))
				 {driver.findElement(By.xpath("//table[2]/tbody/tr/td/input")).click();
			//	 System.out.println("Выбрали первый чекбокс");
				 Thread.sleep(1000);
				 
				for (int second = 2;second<10; second++) 
					
					
					if (selenium.isElementPresent("//tr["+second+"]/td/input")) {
				    	selenium.click("//tr["+second+"]/td/input");
				
 
			  //  	if (isElementPresent(By.xpath("//tr["+second+"]/td/input"))) {
			  // 	driver.findElement(By.xpath("//tr["+second+"]/td/input")).click();
			  //   	System.out.println("Выбрали чекбокс "+second);
			  //   	Thread.sleep(1000);
			    	} 
			        else {//System.out.println("Выходим из цикла"); 
			        break;}

				

				try {
					driver.findElement(By.name("nvp_a_tr")).click();
				//	System.out.println("Нажали удалить");
					Thread.sleep(5000);
				} catch (Throwable e) {System.out.println(e.toString()); }
				}
				 
				driver.findElement(By.xpath("//a[contains(text(),'Спам')]")).click();
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout spam checkbox");
					try { if (isElementPresent(By.name("nvp_a_dl"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
			//	System.out.println("Зашли в спам"); 
				Thread.sleep(5000);
				 if (isElementPresent(By.xpath("//table[2]/tbody/tr/td/input")))
				 {driver.findElement(By.xpath("//table[2]/tbody/tr/td/input")).click();
		//		 System.out.println("Выбрали в спаме первый чекбокс");
				 Thread.sleep(1000);
				 
				for (int second = 2;second<10; second++) 
	
					
					if (selenium.isElementPresent("//tr["+second+"]/td/input")) {
				    	selenium.click("//tr["+second+"]/td/input");
				
 
			  //  	if (isElementPresent(By.xpath("//tr["+second+"]/td/input"))) {
			  // 	driver.findElement(By.xpath("//tr["+second+"]/td/input")).click();
			 //    	System.out.println("Выбрали чекбокс "+second);
			 //    	Thread.sleep(1000);
					
		//	    	if (isElementPresent(By.xpath("//tr["+second+"]/td/input"))) {
		//	    	driver.findElement(By.xpath("//tr["+second+"]/td/input")).click();
			    //	System.out.println("Выбрали в спаме чекбокс "+second);
			    	} 
			        else {
			        	//System.out.println("Выходим из цикла"); 
			        break;}
				
				try {
					driver.findElement(By.name("nvp_a_dl")).click(); 
				//	System.out.println("Нажали удалить");
					Thread.sleep(5000);
				} catch (Throwable e) {}
				}

					System.out.println("Почистили ящик на gmail.com");
				}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@gmail.com : "+e.toString()); }}}

class HotmailClear {
				
				public void check()  throws Exception {
					try{
			
						
						selenium.open("http://hotmail.com");	
						Thread.sleep(5000);
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox link");
							try { if (selenium.isElementPresent("//*[contains(text(),'Входящие')]")) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
						Thread.sleep(1000);
						selenium.click("//*[contains(text(),'Входящие')]");
						selenium.selectFrame("appFrame");
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox checkbox");
							try { if (selenium.isElementPresent("id=msgChkAll")) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
			
						Thread.sleep(5000);
						if (selenium.isElementPresent("//*[contains(text(), 'Please confirm your email address')]"))
						{System.out.println("hotmail.com | PASSED | INBOX"); }
						else
						{
							
							for (int second = 0;; second++) {
								if (second >= 60) fail("timeout spam link");
								try { if (selenium.isElementPresent("//span[@class='FolderLabel'][contains (text(),'Нежелательные')]")) break; } catch (Exception e) {}
								Thread.sleep(1000);
							}
							selenium.click("//span[@class='FolderLabel'][contains (text(),'Нежелательные')]");
							Thread.sleep(5000);	
							if (selenium.isElementPresent("//*[contains(text(), 'Please confirm your email address')]"))
							{System.out.println("hotmail.com | PASSED | SPAM"); }
							else System.out.println("hotmail.com | FAILED");
						 }
						
						
						
						
				}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@yandex.ru : "+e.toString()); }}
			
	
				public void clear()  throws Exception {
					System.out.println("Чистим ящик на hotmail.com");
					try{
					selenium.open("/login.srf?wa=wsignin1.0&rpsnv=11&ct=1334915447&rver=6.1.6206.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&lc=1049&id=64855&mkt=ru-ru&cbcxt=mai&snsc=1");
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout signin");
						try { if (selenium.isElementPresent("id=idSIButton9")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					selenium.type("id=i0116", "yangututest@hotmail.com");
					selenium.type("id=i0118", "12341234a");
					selenium.click("id=idSIButton9");
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox link");
						try { if (selenium.isElementPresent("//a[contains(text(),'Hotmail')]")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					selenium.click("//a[contains(text(),'Hotmail')]");
					selenium.selectFrame("appFrame");
			/*		for (int second = 0;; second++) {
						if (second >= 60) fail("timeout");
						try { if (selenium.isElementPresent("//*[contains(text(),'У вас очень чистая папка \"Входящие\"!')]")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
             */
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox checkbox");
						try { if (selenium.isElementPresent("id=msgChkAll")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(3000);
					selenium.click("id=msgChkAll");
					selenium.click("css=#DeleteMessages > span.Label");
					Thread.sleep(5000);
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout spam link");
						try { if (selenium.isElementPresent("css=#00000000-0000-0000-0000-000000000005 > a.lnav_itemLnk. > span.Caption > span.FolderLabel")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					selenium.click("css=#00000000-0000-0000-0000-000000000005 > a.lnav_itemLnk. > span.Caption > span.FolderLabel");
					Thread.sleep(5000);
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout spam checkbox");
						try { if (selenium.isElementPresent("id=msgChkAll")) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					selenium.click("id=msgChkAll");
					selenium.click("css=#DeleteMessages > span.Label");
					Thread.sleep(5000);
					System.out.println("Почистили ящик на hotmail.com");
					}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@hotmail.com : "+e.toString()); }}}
					
class YandexClear {
				
				public void check() throws Exception {
					try{
					driver.get("http://mail.yandex.by/");	
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox checkbox");
						try { if (isElementPresent(By.cssSelector("input.b-messages-head__checkbox"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(5000);
					
					if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
					{System.out.println("yandex.ru | PASSED | INBOX"); }
					else
					{
						driver.findElement(By.linkText("Спам")).click();
						Thread.sleep(5000);
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout spam checkbox");
							try { if (isElementPresent(By.cssSelector("input.b-messages-head__checkbox"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}	
						Thread.sleep(5000);	
						if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
						{System.out.println("yandex.ru | PASSED | SPAM"); }
						else System.out.println("yandex.ru | FAILED");
						
						
						
					}
					
					}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@yandex.ru : "+e.toString()); }
					
					
					
				}
				public void clear()  throws Exception {
					
					System.out.println("Чистим ящик на yandex.ru");
					try{
					driver.get("http://mail.yandex.by/");
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout twoweeks checkbox");
						try { if (isElementPresent(By.name("twoweeks"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.id("b-mail-domik-username11")).clear();
					driver.findElement(By.id("b-mail-domik-username11")).sendKeys("yangututest");
					driver.findElement(By.id("b-mail-domik-password11")).clear();
					driver.findElement(By.id("b-mail-domik-password11")).sendKeys("12341234a");
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("input.b-mail-button__button")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox checkbox");
						try { if (isElementPresent(By.cssSelector("input.b-messages-head__checkbox"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					 Thread.sleep(3000);
					 if (isElementPresent(By.cssSelector("div.b-messages__placeholder-item"))==false)
					 {
					driver.findElement(By.cssSelector("input.b-messages-head__checkbox")).click();
					driver.findElement(By.cssSelector("img.b-ico.b-ico_delete")).click();
					Thread.sleep(3000);
					}
			
					driver.findElement(By.linkText("Спам")).click();
					Thread.sleep(5000);
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout spam checkbox");
						try { if (isElementPresent(By.cssSelector("input.b-messages-head__checkbox"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}	
					Thread.sleep(3000);
					
					 if (isElementPresent(By.linkText("Перейти в папку «Входящие»"))==false)

					{
					driver.findElement(By.xpath("//div[2]/label/input")).click();
					driver.findElement(By.cssSelector("img.b-ico.b-ico_delete")).click();
					Thread.sleep(3000);}
					System.out.println("Почистили ящик на yandex.ru");
					}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@yandex.ru : "+e.toString()); }}}
						
			
class Hotmail2Clear {
				
				public void check()  throws Exception {
				try{
					
				}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@yandex.ru : "+e.toString()); }}
					
				
				public void clear()  throws Exception {
				System.out.println("Чистим ящик на hotmail.com через webdriver");	
				try{	
					driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=11&ct=1334925356&rver=6.1.6206.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&lc=1049&id=64855&mkt=ru-ru&cbcxt=mai&snsc=1#!/mail/InboxLight.aspx?n=1727369889!n=919369624&fid=5");
		    		for (int second = 0;; second++) {
					if (second >= 60) fail("timeout signin");
					try { if (isElementPresent(By.id("idSIButton9"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				driver.findElement(By.id("i0116")).clear();
				driver.findElement(By.id("i0116")).sendKeys("yangututest@hotmail.com");
				driver.findElement(By.id("i0118")).clear();
				driver.findElement(By.id("i0118")).sendKeys("12341234a");
				driver.findElement(By.id("idSIButton9")).click();
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout inbox link");
					try { if (isElementPresent(By.xpath("//a[contains(text(),'Hotmail')]"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				driver.findElement(By.xpath("//a[contains(text(),'Входящие')]")).click();
				
				
	/*	    	WebClient wb = new WebClient();
		    	wb.setJavaScriptEnabled(true);
		    	wb.setThrowExceptionOnScriptError(false);
		    	wb.setCssEnabled(true);
				HtmlPage p = (HtmlPage) wb.getPage("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=11&ct=1334925356&rver=6.1.6206.0&wp=MBI&wreply=http:%2F%2Fmail.live.com%2Fdefault.aspx&lc=1049&id=64855&mkt=ru-ru&cbcxt=mai&snsc=1#!/mail/InboxLight.aspx?n=1727369889!n=919369624&fid=5");
				System.out.println(p.asText());
				final HtmlTextInput elem1 = p.getElementByName("login");
				elem1.setValueAttribute("yangututest@hotmail.com");
				final HtmlPasswordInput elem2 = p.getElementByName("passwd");
				elem2.setValueAttribute("12341234a");
				final HtmlElement button = p.getElementById("idSIButton9");
				p = button.click();
				final HtmlLink link = p.getElementByName("Входящие");
				p = link.click();
			
				System.out.println("text = "+p.asText());
				System.out.println("xml = "+p.asXml());
				    
*/		
				Thread.sleep(8000);
				
				
				if (isElementPresent(By.id("NoMsgs")))
				{
					System.out.println("Элемент есть"); 
					if (driver.findElement(By.id("NoMsgs")).getText().matches("^exact:У вас очень чистая папка \"Входящие\"! \\(Вам известно, что можно получать сообщения из других учетных записей электронной почты[\\s\\S]\\)$")) 
				{
						System.out.println("Пусто"); 
				}}



    
     
		for (int second = 0;; second++) {
		if (second >= 60) fail("timeout letter checkbox");
		try { if (isElementPresent(By.xpath("//tr[3]/td/input"))) break; } catch (Exception e) {}
		Thread.sleep(1000);
		}
		System.out.println("Зашли во входящие"); 
		if (isElementPresent(By.xpath("//*[contains(text(),'У вас очень чистая папка \"Входящие\"!')]"))==false)
		{	
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (isElementPresent(By.id("msgChkAll"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			driver.findElement(By.id("msgChkAll")).click();
				//selenium.click("//tr[3]/td/input");
				
				//driver.findElement(By.cssSelector("#DeleteMessages > span.Label")).click();
				//Thread.sleep(5000);
				}
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (isElementPresent(By.cssSelector("#00000000-0000-0000-0000-000000000005 > a.lnav_itemLnk. > span.Caption > span.FolderLabel"))) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				driver.findElement(By.cssSelector("#00000000-0000-0000-0000-000000000005 > a.lnav_itemLnk. > span.Caption > span.FolderLabel")).click();
					// ERROR: Caught exception [ERROR: Unsupported command [selectFrame]]
				// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isElementPresent("id=msgChkAll")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				System.out.println("Зашли в спам"); 
				if (selenium.isElementPresent("//*[contains(text(),'Здесь нет нежелательной почты')]")==false)
				{


					selenium.click("id=msgChkAll");
					selenium.click("#DeleteMessages > span.Label");
				Thread.sleep(5000);}
				System.out.println("Почистили ящик на hotmail.com через webdriver");
			}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@hotmail.com через webdriver: "+e.toString()); }}}

			
class AolClear {
				
				public void check()  throws Exception {	
					try{
						driver.get("http://mail.aol.com/");	
		
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox link");
							try { if (isElementPresent(By.id("inboxNode"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}

						driver.findElement(By.id("inboxNode")).click();
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox delete icon");
							try { if (isElementPresent(By.cssSelector("div.icon.delIcon"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
					Thread.sleep(5000);
					if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
					{System.out.println("aol.com | PASSED | INBOX"); }
					else
					{
						driver.findElement(By.xpath("//div[5]/div[2]/span")).click();
						Thread.sleep(10000);	
						if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
						{System.out.println("aol.com | PASSED | SPAM"); }
						else System.out.println("aol.com | FAILED");
					
				}}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@aol.com : "+e.toString()); }}
			
				
			
				public void clear()  throws Exception {		
					
					System.out.println("Чистим ящик на aol.com");
					try {
					driver.get("http://www.aol.com/");
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout signin");
						try { if (isElementPresent(By.cssSelector("img.noion"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					driver.findElement(By.cssSelector("img.noion")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout signin");
						try { if (isElementPresent(By.id("submitID"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.id("lgnId1")).clear();
					driver.findElement(By.id("lgnId1")).sendKeys("yangututest");
					driver.findElement(By.id("pwdId1")).clear();
					driver.findElement(By.id("pwdId1")).sendKeys("12341234a");
					driver.findElement(By.id("submitID")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox link");
						try { if (isElementPresent(By.id("inboxNode"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.id("inboxNode")).click();
					Thread.sleep(5000);
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox delete icon");
						try { if (isElementPresent(By.cssSelector("div.icon.delIcon"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(5000);
		
					if ("This folder is empty.".equals(driver.findElement(By.cssSelector("div.zeroRowHeader")).getText())==false) 

					
					
				//	if (isElementPresent(By.cssSelector("div.gridIcon.ws_image_chkOffIcon")))
						
					{	
					driver.findElement(By.cssSelector("div.gridIcon.ws_image_chkOffIcon")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox delete icon 2");
						try { if (isElementPresent(By.cssSelector("div.icon.delIcon"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(3000);
					driver.findElement(By.cssSelector("div.icon.delIcon")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox button ok");
						try { if (isElementPresent(By.xpath("//div[@class='btnLabel'][contains(text(),'OK')]"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.xpath("//div[@class='btnLabel'][contains(text(),'OK')]")).click();
					Thread.sleep(3000);}
					
					driver.findElement(By.xpath("//div[5]/div[2]/span")).click();
					Thread.sleep(5000);
					
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout delete icon");
						try { if (isElementPresent(By.cssSelector("div.icon.delIcon"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					if ("This folder is empty.".equals(driver.findElement(By.cssSelector("div.zeroRowHeader")).getText())==false) 
					{
					driver.findElement(By.cssSelector("div.gridIcon.ws_image_chkOffIcon")).click();
					Thread.sleep(5000);
					driver.findElement(By.cssSelector("div.icon.delIcon")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout spam button ok");
						try { if (isElementPresent(By.xpath("//div[@class='btnLabel'][contains(text(),'OK')]"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.xpath("//div[@class='btnLabel'][contains(text(),'OK')]")).click();
					Thread.sleep(3000);}
					System.out.println("Почистили ящик на aol.com");
					}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@aol.com : "+e.toString()); }}}

class YahooClear {
				
	
				public void check()  throws Exception {
					try{
						driver.get("http://mail.yahoo.com/");	
						for (int second = 0;; second++) {
							if (second >= 60) fail("timeout inbox link");
							try { if (isElementPresent(By.id("inbox-label"))) break; } catch (Exception e) {}
							Thread.sleep(1000);
						}
						driver.findElement(By.id("inbox-label")).click();
		
						Thread.sleep(10000);

						
						if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
						{System.out.println("yahoo.com | PASSED | INBOX"); }
						else
						{
							driver.findElement(By.id("spam-label")).click();
							Thread.sleep(10000);	
							if (isElementPresent(By.xpath("//*[contains(text(), 'Please confirm your email address')]")))
							{System.out.println("yahoo.com | PASSED | SPAM"); }
							else System.out.println("yahoo.com | FAILED");
						}}catch (Throwable e) {System.out.println("Ошибка проверки yangututest@yahoo.com : "+e.toString()); }}
						
	
				public void clear()  throws Exception {		
					
					System.out.println("Чистим ящик на yahoo.com");
					try {
					driver.get("http://www.yahoo.com/");
					driver.findElement(By.cssSelector("span.tab-icon.mail-spr")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout signin");
						try { if (isElementPresent(By.id(".save"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					Thread.sleep(3000);
					driver.findElement(By.id("username")).clear();
					driver.findElement(By.id("username")).sendKeys("yangututest@yahoo.com");
					driver.findElement(By.id("passwd")).clear();
					driver.findElement(By.id("passwd")).sendKeys("12341234a");
					Thread.sleep(1000);
					driver.findElement(By.id(".save")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox link");
						try { if (isElementPresent(By.id("inbox-label"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
					driver.findElement(By.id("inbox-label")).click();
					Thread.sleep(5000);
					@SuppressWarnings("unused")
					boolean emptyinbox = true;
					if (isElementPresent(By.cssSelector("#empty-folder-msg > p"))==false)
						
					{
					emptyinbox = false;	
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout inbox checkbox");
						try { if (isElementPresent(By.xpath("//div/span/input"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.xpath("//div/span/input")).click();
		

					driver.findElement(By.linkText("Delete")).click();
		/*			for (int second = 0;; second++) {
						if (second >= 60) fail("timeout");
						try { if (isElementPresent(By.linkText("OK"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}
		*/			Thread.sleep(10000);
					if (isElementPresent(By.linkText("OK")))
					{							
					driver.findElement(By.linkText("OK")).click();
					Thread.sleep(3000);
					}
					}
					driver.findElement(By.id("spam-label")).click();
					
					Thread.sleep(10000);
		//		if ((emptyinbox == true)&&(isElementPresent(By.xpath("//div/span/input")))
		//		||((emptyinbox == false)&&(isElementPresent(By.cssSelector("#empty-folder-msg > p"))==false)))
					
				//if (isElementPresent(By.cssSelector("#empty-folder-msg > p"))==false)
				//if	(isElementPresent(By.xpath("//div/span/input")))
				if	(isElementPresent(By.cssSelector("#empty-folder-msg > p")))
				if ("There are no emails in your Spam folder.".equals(driver.findElement(By.cssSelector("#empty-folder-msg > p")).getText())==false) //break; } catch (Exception e) {}
						
				{
					driver.findElement(By.xpath("//div/span/input")).click();
					driver.findElement(By.linkText("Delete")).click();
					for (int second = 0;; second++) {
						if (second >= 60) fail("timeout button ok");
						try { if (isElementPresent(By.linkText("OK"))) break; } catch (Exception e) {}
						Thread.sleep(1000);
					}

					driver.findElement(By.linkText("OK")).click();
					Thread.sleep(3000);}
					System.out.println("Почистили ящик на yahoo.com");
			    	}catch (Throwable e) {System.out.println("Ошибка очистки yangututest@yahoo.com : "+e.toString()); }}}
			
			
		@After
		public void tearDown() throws Exception {
	//		driver.quit();
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
