package yangutu_wedbriver;
//package tests;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.opera.core.systems.OperaDriver;
import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.annotations.*;


@SuppressWarnings("unused")
public class MailsDTandVideo extends 
SeleneseTestNgHelper
//SeleneseTestBase
{
	private WebDriver driver;
	public long curTime;
	public PrintWriter ps2;
	public String curStringDate;
	public PrintWriter ps; 
	public int dt1 = 2;
	public int vd1 = 2;
	public int dt2 = 2;
	public int vd2 = 2;
	public appGetInfo getso = new appGetInfo();
    
//	public PrintWriter ps2;
	@Before
	//Class
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
        driver = new 
        ChromeDriver();
  	    //InternetExplorerDriver();
        //OperaDriver();
        //HtmlUnitDriver();
        String baseUrl = "http://yangutu.com/";
	    selenium = new WebDriverBackedSelenium(driver, baseUrl);	
	    selenium.setTimeout("180000");

		 curTime = System.currentTimeMillis();
		 curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
		 ps2 = new PrintWriter(
		 new FileWriter("C:\\tests\\dt\\"+curStringDate+".txt"));
		
	}
 //@Ignore	
 @Test
 
 
 public void testLogin_gmail() throws Exception {
	

	    
	

 getso.read();
 getso.check();	 


 }
		
 class appGetInfo{
	 
	 
	 public final void read() throws Exception
     {
		 
		 	long curTime = System.currentTimeMillis();
			String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
		 
			BufferedReader reader = new BufferedReader(new InputStreamReader
			(new FileInputStream("C:\\tests\\dt\\lastresults.txt")));
		    String line;




		    
	//	    appGetInfo getinfo = new appGetInfo();  
	//	    getinfo.get(ps2);
		    
		    
		    while((line=reader.readLine())!=null)
		    {
		    	

		    	final String[] array = line.split(" = ");
		        String user=array[0];
		        String subscribed=array[1];	
		        String podpisan = "хз";
		        if (Integer.parseInt(subscribed) == 0)
		        {podpisan = "отписан от";}
		        if (Integer.parseInt(subscribed) == 1)
		        {podpisan = "подписан на";}
		        
		        if (user.equals("dt1"))
		        {dt1 = Integer.parseInt(subscribed);
		        System.out.println("ящик everydaymails1@gmail.com "+podpisan+" Daily Talks");
		        ps2.println("ящик everydaymails1@gmail.com "+podpisan+" Daily Talks");
		        
                getso.get(192, 1);
          //      getso.get(180, 1);
		        
		        }
		        if (user.equals("vd1"))
		        {vd1 = Integer.parseInt(subscribed);
		        System.out.println("ящик everydaymails1@gmail.com "+podpisan+" Popular Videos");
		        ps2.println("ящик everydaymails1@gmail.com "+podpisan+" Popular Videos");
		        
		        getso.get(193, 1);
          //      getso.get(158, 1);
		        
		        }
		        if (user.equals("dt2"))
		        {dt2 = Integer.parseInt(subscribed);
		        System.out.println("ящик everydaymails2@gmail.com "+podpisan+" Daily Talks");
		        ps2.println("ящик everydaymails2@gmail.com "+podpisan+" Daily Talks");
		        
		        getso.get(192, 2);
          //      getso.get(180, 2);
		    	
		        }
		        
		        if (user.equals("vd2"))
		        {vd2 = Integer.parseInt(subscribed);
		        System.out.println("ящик everydaymails2@gmail.com "+podpisan+" Popular Videos");
		        ps2.println("ящик everydaymails2@gmail.com "+podpisan+" Popular Videos");
		        
		        getso.get(193, 2);
            //    getso.get(158, 2);
                
		        }
		    
		    
		    
		    }
		    reader.close(); 
		 
     }
	 
	 public final void check() throws Exception
     {
     

		 
		   
		    
		    PrintWriter ps = new PrintWriter(
            new FileWriter("C:\\tests\\dt\\lastresults.txt"));
		   
		   
	//	    getinfo.get(ps2);
			Calendar c=Calendar.getInstance(); 

//			int year=c.get(c.YEAR); 
//			int month=c.get(c.MONTH)+1; 
			int day=c.get(Calendar.DAY_OF_MONTH);

			
			
			
			System.out.println("Сегодняшняя дата = "+curStringDate);
			System.out.println("Сегодняшний день = "+day);
		
			
			
			
			
			int count = 0;
			for (count = 1; count < 3; count++)
			{
		
		/*	WebClient wb = new WebClient();
	    	wb.setJavaScriptEnabled(false);
	    	wb.setThrowExceptionOnScriptError(false);
	    	wb.setCssEnabled(false);
			HtmlPage p = (HtmlPage) wb.getPage("http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
		    final HtmlTextInput elem1 = p.getElementByName("Email");
			elem1.setValueAttribute("everydaymails"+count);
			final HtmlPasswordInput elem2 = p.getElementByName("Passwd");
			elem2.setValueAttribute("12341234a");
			final HtmlElement button = p.getElementById("signIn");
			p = button.click();

		*/	    
			
			
		    selenium.open("http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=signIn")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			System.out.println("Заходим юзером everydaymails"+count);
			selenium.type("id=Email", "everydaymails"+count);
			selenium.type("id=Passwd", "12341234a");
			selenium.click("id=signIn");
		//	System.out.println(p.asText());

		
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//*[contains(text(), 'Поиск')]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
	;
			String title2 = "absent";
			String title = "absent";
			

			
			
			ps2.println("everydaymails"+count+"@gmail.com:");
			if (selenium.isElementPresent("//tr[1]/td[3]/a/span")){
				System.out.println("Первое письмо в ящике:");
				title = selenium.getText("//tr[1]/td[3]/a/span");
				System.out.println(title);
				ps2.println(title);
				
				if (title.contains("Daily Talks"))
				{final String[] array = title.split(" ");
		        String dtday1=array[3];
		        String s = new StringBuffer(dtday1).delete(array[3].length()-1,array[3].length()).toString();
		   		System.out.println("День рассылки Daily Talks = "+s);
		   		if (day == Integer.parseInt(s))
		   		{System.out.println("Сегодняшнее");}
		   		if (day - Integer.parseInt(s) == 1)
		   		{System.out.println("Вчерашнее");
		   		
		   		
		   		}
				}
			
				if (title.contains("Videobox"))
				{final String[] array = title.split(" ");
		        String vidday1=array[5];
		        String s = new StringBuffer(vidday1).delete(array[5].length()-1,array[5].length()).toString();
		   		System.out.println("День рассылки Popular Videos = "+s);
		   		if (day == Integer.parseInt(s))
		   		{System.out.println("Сегодняшнее");}
		   		if (day - Integer.parseInt(s) == 1)
		   		{System.out.println("Вчерашнее");}
				
				
				}
				
			}
			
			//td[6]/div/div/div/span
			//tr[2]/td[6]/div/div/div/span
	    	//if (selenium.isElementPresent("//span[@id=':ob']")){
	    	if (selenium.isElementPresent("//tr[2]/td[3]/a/span")){
			System.out.println("Второе письмо в ящике:");
		//	title2 = selenium.getText("//div/div/span/b");
			title2 = selenium.getText("//tr[2]/td[3]/a/span");
			System.out.println(title2);
			ps2.println(title2);
			
	    	
			if (title2.contains("Daily Talks"))
			{final String[] array = title2.split(" ");
	        String dtday2=array[3];
	        String s = new StringBuffer(dtday2).delete(array[3].length()-1,array[3].length()).toString();
	   		System.out.println("День рассылки Daily Talks = "+s);
	   		if (day == Integer.parseInt(s))
	   		{System.out.println("Сегодняшнее");}
	   		if (day - Integer.parseInt(s) == 1)
	   		{System.out.println("Вчерашнее");}
			
			
			}
		
			if (title2.contains("Videobox"))
			{final String[] array = title2.split(" ");
	        String vidday2=array[5];
	        String s = new StringBuffer(vidday2).delete(array[5].length()-1,array[5].length()).toString();
	   		System.out.println("День рассылки Popular Videos = "+s);
	   		if (day == Integer.parseInt(s))
	   		{System.out.println("Сегодняшнее");}
	   		if (day - Integer.parseInt(s) == 1)
	   		{System.out.println("Вчерашнее");}
			}
	    	
	    	//tut dodelat nezavisimo ot title i title2
	    	//1
			if (((count == 1)&&(dt1 == 1))||((count == 2)&&(dt2 == 1)))
	        
			{	if ((title.contains("Daily Talks")|(title2.contains("Daily Talks"))))
			{   //	System.out.println("Open Daily Talks letter");
				selenium.click("//span/b[contains(text(), 'Daily Talks')]");
			
			{for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Unsubscribe")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			WebElement element = driver.findElement(By.linkText("Unsubscribe"));
			String thisLink = element.getAttribute("href");
			System.out.println("ссылка на отписку = "+thisLink);
			ps2.println("ссылка на отписку = "+thisLink);
			selenium.click("link=Unsubscribe");
			Thread.sleep(5000);
			System.out.println("отписали everydaymails"+count+"@gmail.com от Daily Talks");
			ps2.println("отписали everydaymails"+count+"@gmail.com от Daily Talks");
			System.out.println("dt"+count+" = 0");
			ps.println("dt"+count+" = 0");
			
	        getso.get(192, count);
  //          getso.get(180, count);

			
			}}
			}
			
			//i tut dodelat
		//	2
			if (((count == 1)&&(vd1 == 1))||((count == 2)&&(vd2 == 1))){
			{if ((title.contains("Videobox")||(title2.contains("Videobox"))))
			{   //	System.out.println("Open Popular Videos letter");
				
			selenium.open("http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//span/b[contains(text(), 'Videos')]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			selenium.click("//span/b[contains(text(), ' Video')]");}
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Unsubscribe")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			WebElement element = driver.findElement(By.linkText("Unsubscribe"));
			String thisLink = element.getAttribute("href");
			System.out.println("ссылка на отписку = "+thisLink);
			ps2.println("ссылка на отписку = "+thisLink);
			selenium.click("link=Unsubscribe");
			Thread.sleep(5000);
			System.out.println("отписали everydaymails"+count+"@gmail.com от Popular Videos");
			ps2.println("отписали everydaymails"+count+"@gmail.com от Popular Videos");
			System.out.println("vd"+count+" = 0");
			ps.println("vd"+count+" = 0");
			
			getso.get(193, count);
  //          getso.get(158, count);
			
			}}}
		/*	for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//*[contains(text(), 'You have been successfully unsubscribed.')]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
		*/	
			System.out.println("Делаем логаут с ящика");
			selenium.open("http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("link=Выйти")) break; } catch (Exception e) {}
				Thread.sleep(1000);}
			Thread.sleep(3000);
			selenium.click("link=Выйти"); 
			System.out.println("Сделали логаут с ящика");
			Thread.sleep(10000);
			}

			System.out.println("2 tests complete");
		//	selenium.open("http://yangutu.com/logout");
			
			if (dt1 == 0){
			selenium.open("http://yangutu.com/dailytalks/");
		
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("id=dt-subscribe")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			selenium.type("id=dt-subscribe-email", "everydaymails2@gmail.com");
			selenium.click("id=dt-subscribe");
			
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if 
					//(selenium.isElementPresent("*[contains(text(),'успешно')]")) 
					(selenium.isTextPresent("успешно")) 
					break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			System.out.println("подписали everydaymails1@gmail.com на Daily Talks ");
			ps2.println("подписали everydaymails1@gmail.com на Daily Talks ");
			Thread.sleep(10000);
			ps.println("dt1 = 1");
			
			getso.get(192, 1);
     //       getso.get(180, 1);
			
			
			
			}
			
			if (dt2 == 0)
			{
				
				
				selenium.open("http://yangutu.com/dailytalks/");
				
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isElementPresent("id=dt-subscribe")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				selenium.type("id=dt-subscribe-email", "everydaymails2@gmail.com");
				selenium.click("id=dt-subscribe");
				
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isTextPresent("успешно")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
			System.out.println("подписали everydaymails2@gmail.com на Daily Talks");
			ps2.println("подписали everydaymails2@gmail.com на Daily Talks");
			Thread.sleep(10000);
			ps.println("dt2 = 1");
			
			getso.get(192, 2);
       //     getso.get(180, 2);

			
			
			}
			
			
			
			
			if (vd1 == 0){
			selenium.open("http://yangutu.com/video");
			
			
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//a/span")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}


			selenium.click("//a/span");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("xpath=(//input[@name='email'])[2]")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
				
			selenium.type("xpath=(//input[@name='email'])[2]", "everydaymails1@gmail.com");
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isElementPresent("//input[@value='Подписаться']")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}

			selenium.click("//input[@value='Подписаться']");
			
			//*[contains(text(),'Удалить навсегда')]";
		
			for (int second = 0;; second++) {
				if (second >= 60) fail("timeout");
				try { if (selenium.isTextPresent("Вы подписаны")) break; } catch (Exception e) {}
				Thread.sleep(1000);
			}
			
			
			
			System.out.println("подписали everydaymails1@gmail.com на Popular Videos");
			ps2.println("подписали everydaymails1@gmail.com на Popular Videos");
			Thread.sleep(5000);
			ps.println("vd1 = 1");
			

			getso.get(193, 1);
     //       getso.get(158, 1);
			
			}
			
			if (vd2 == 0)
			{
				
				selenium.open("http://yangutu.com/video");
				
				
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isElementPresent("//a/span")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}


				selenium.click("//a/span");
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isElementPresent("xpath=(//input[@name='email'])[2]")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
					
				selenium.type("xpath=(//input[@name='email'])[2]", "everydaymails2@gmail.com");
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isElementPresent("//input[@value='Подписаться']")) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}

				selenium.click("//input[@value='Подписаться']");
				
				//*[contains(text(),'Удалить навсегда')]";
			
				for (int second = 0;; second++) {
					if (second >= 60) fail("timeout");
					try { if (selenium.isTextPresent
							//("*[contains(text(),'Вы подписаны')]")
							("Вы подписаны")
							) break; } catch (Exception e) {}
					Thread.sleep(1000);
				}
				
				
					
				
			System.out.println("подписали everydaymails2@gmail.com на Popular Videos");
			ps2.println("подписали everydaymails2@gmail.com на Popular Videos");
			Thread.sleep(5000);
			ps.println("vd2 = 1");
			
			getso.get(193, 2);
       //     getso.get(158, 2);
            
			} 
     
			
			
	//		getinfo.get(ps2);
			ps.close();
			ps2.close();	
			
			
     }
		
	 public final void get(int id, int count) throws Exception
     {
		 String type = "x3";
		 String age = "x3";
		 
		    if (id==158)
		    {type = "Видео ";
		     age = " old:";}
		    
		    if (id==180)
		    {type = "DT ";
		    age = " old:";}
		    
		    if (id==192)
		    {type = "DT ";
		    age = " new:";}
		    
		    if (id==193)
		    {type = "Видео ";
		    age = " new:";}
		    
		    
		    
		//	selenium.open("http://subscribe.yangutu.com/emailmarketer/gate.php?secret=531f383bb36c63e7036562244d7bec47&listid="+id+"&mode=getstatus&email=everydaymails"+count+"@gmail.com");
		    selenium.open("http://mailsender.yangutu.com/emailmarketer/gate.php?secret=531f383bb36c63e7036562244d7bec47&listid="+id+"&mode=get_subscriber_status&email=everydaymails"+count+"@gmail.com");
			String info = selenium.getText("css=body");
			System.out.println(type+count+age);
			ps2.println(type+count+age);
		 
			if (info.contains("status")){
			String[] array = info.split("\"status\";s:");
		    System.out.println("Статус: "+array[1]);
		    ps2.println("Статус: "+array[1]);
			} else
			{
				ps2.println(info);
				System.out.println(info);
			}	
		   
			
	
     }}


	      

	@After
	public void tearDown() throws Exception {
//	selenium.stop();
	}
}
