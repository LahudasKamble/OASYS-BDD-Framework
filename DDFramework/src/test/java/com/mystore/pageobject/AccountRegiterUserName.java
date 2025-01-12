package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegiterUserName {
	
	WebDriver ldriver;


	public AccountRegiterUserName(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (xpath = "//a[@title='View my customer account']")
	WebElement registerusername;
	
	@FindBy(linkText = "Sign out")
	WebElement clickonsignout;
	
	
	public void signout() {
		
		clickonsignout.click();
	}
	
	public String getusername() {
		
		String name = registerusername.getText();
		
		return name;
		
	}

}
