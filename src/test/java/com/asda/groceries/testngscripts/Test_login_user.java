package com.asda.groceries.testngscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.asda.groceries.pages.Login_user;

public class Test_login_user {
		WebDriver driver;
		Login_user obj1;
		
	  @BeforeSuite
	  public void setup(){
		  driver=new FirefoxDriver();

		  
	  }
	  
	  @BeforeTest
	  public void test_setup(){
		  driver.get("http://groceries.asda.com/");
		  driver.manage().window().maximize();
				   obj1=new Login_user(driver);
		 		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   System.out.println("before suite");
		  
	  }
	  
	  
	  @AfterSuite
	  public void unset(){
		  System.out.println("afterTest");
		  driver.close();
		  driver=null;
		
		  
	  }
	 

	 @Test
	 //(priority=2)
	// ( enabled=false)
	  public void login_test() {
		  obj1.sign_in_user("abhi11@wipro.com", "wipro@123");
		  
		  
	  }

}
