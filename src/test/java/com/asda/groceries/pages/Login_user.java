package com.asda.groceries.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_user {
WebDriver driver;
	
	//declaring the header elements when a user is signed in


public Login_user(WebDriver driver){
	this.driver= driver;
	PageFactory.initElements(driver,this);
	}

// sign in button 
@FindBy(id="sign-in-button-accessible") 
WebElement signinid;
// element present on frame when clicked on sign in button.

//user name text box
	@FindBy(id="username")
	WebElement usernameid;

	//password text box
	@FindBy(id="password")
	WebElement passwordid;
	
	//sign in button text box
	@FindBy(id="btn-signIn-accessible")
	WebElement signinbuttonid;

	
	//Registration button
@FindBy(xpath ="//a [contains(@href,'#/registration')]")
WebElement register_button;

//help button
// search box
//Registration is quick and easy box for entering post code
//Already a customer sign in button in landing page.
//All category pages one by one


//Constructor method to initialize driver object.


//ACTION METHODS

//Click on Sign in button
public void click_sign_in(){
	signinid.click();
}
// Sign in frame will open navigating it to frame
public void sign_in_frame(){
	driver.switchTo().frame("login");
}

public void setup_user_id(String username){
	usernameid.sendKeys(username);
}

public void setup_user_pwd(String password){
	passwordid.sendKeys(password);
	}

public void click_sign_in_in_frame(){
	signinbuttonid.click();
}


public void check_homepage_title_N_url(){
	String a = driver.getTitle();
	System.out.println(a);
	Assert.assertEquals(a,"Online Food Shopping - ASDA Groceries");
	String b = driver.getCurrentUrl();
	System.out.println(b);
	Assert.assertEquals("http://groceries.asda.com/asda-webstore/landing/home.shtml", driver.getCurrentUrl());

}
public void Signed_in_assert(){
	

	
	
}



public void sign_in_user(String uname,String pwd){
	click_sign_in();
	sign_in_frame();
	setup_user_id(uname);
	setup_user_pwd(pwd);
	click_sign_in_in_frame();
	
}

public void click_registration(){
	register_button.click();
}

	
}
