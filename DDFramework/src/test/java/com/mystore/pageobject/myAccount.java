package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

	WebDriver ldriver;

	public myAccount(WebDriver rdriver) {

		ldriver =rdriver;

		PageFactory.initElements(rdriver, this);
	}


	@FindBy (id = "email_create")
	WebElement CreateEmailid;

	@FindBy (id ="SubmitCreate")
	WebElement submitcreate;
	
	@FindBy (id = "email")
	WebElement regesteredemailid;

	@FindBy (id ="passwd")
	WebElement regesteredepwd;
	
	@FindBy (id ="SubmitLogin")
	WebElement clickonsubmit;

	public void entercreateemailidaddress(String emailid) {

		CreateEmailid.sendKeys(emailid);
	}

	public void entersubmitcreate() {

		submitcreate.click();
	}
	
	public void enterRegesteremailadd(String email) {

		regesteredemailid.sendKeys(email);
	}

	public void enterRegesterpwd(String pwd) {

		regesteredepwd.sendKeys(pwd);
	}
	
	public void clicksubmit() {

		clickonsubmit.click();
	}
	
}
