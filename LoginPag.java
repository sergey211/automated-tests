package yangutu_wedbriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPag 
//extends SeleneseTestNgHelper 
{
	

	 protected final WebDriver driver; 
	 public LoginPag(WebDriver driver) 
	 {
		 this.driver = driver; 
	 }


	 
public void appLoggn(String email) throws Exception {


	try { 
	System.out.println("Логинимся юзером "+email);
	
//driver.get("http://yangutu:usabilityrulit@dev.yangutu.com/login?lang=en");
driver.get("http://yangutu.com/login?lang=en");
  	
	driver.findElement(By.xpath("(//input[@id='f_auth_login'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='f_auth_login'])[2]")).sendKeys(email);
		driver.findElement(By.xpath("(//input[@id='f_auth_pass'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='f_auth_pass'])[2]")).sendKeys("111111");
		driver.findElement(By.xpath("(//input[@id='login_form_submit_spc'])[2]")).click();
	
}	    catch(Throwable e){

       System.out.println("Ошибка: "+e);}}
}