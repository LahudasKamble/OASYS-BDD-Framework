package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	//Create object of Webdriver

	WebDriver ldriver;


	//Constructer

	public indexPage(WebDriver rdriver) {

		ldriver= rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify elements
	@FindBy (linkText = "Sign in")
	WebElement signin;


	//identify action on Webelement

	public void Clickonsigninbutton() {

		signin.click();
	}

}
