package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails {

	WebDriver ldriver;


	public AccountCreationDetails(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy (id = "id_gender1")
	WebElement MRradiobtn;

	@FindBy (id = "customer_firstname")
	WebElement customerfirstname;

	@FindBy (id = "customer_lastname")
	WebElement customerlastname;

	@FindBy (id = "passwd")
	WebElement enterpassword;

	@FindBy (id = "submitAccount")
	WebElement clickonregiterbtn;

	//Address



	@FindBy (partialLinkText = "Add my first address")
	WebElement clickonaddnewaddress;

	@FindBy (id = "firstname")
	WebElement firstName;

	@FindBy (id = "lastname")
	WebElement LastName;

	@FindBy (id = "address1")
	WebElement address;

	@FindBy (id = "city")
	WebElement City;

	@FindBy (id = "id_state")
	WebElement state;

	@FindBy (id = "postcode")
	WebElement Postalcode;

	@FindBy (id = "id_country")
	WebElement country;

	@FindBy (id = "phone_mobile")
	WebElement mobilenumber;

	@FindBy (id = "alias")
	WebElement myaddress;

	@FindBy (id = "submitAddress")
	WebElement savebtn;



	public void mrradiobtn() {

		MRradiobtn.click();
	}

	public void entercustomerfirstname(String fname) {

		customerfirstname.sendKeys(fname);
	}

	public void entercustomerlastname(String lname) {

		customerlastname.sendKeys(lname);
	}

	public void enterpassowrd(String pwd) {

		enterpassword.sendKeys(pwd);
	}

	public void registerbtn() {

		clickonregiterbtn.click();

	}

	public void clickaddress() {

	clickonaddnewaddress.click();


	}

	public void firstname(String name) {

		firstName.clear();
		firstName.sendKeys(name);

	}


	public void lastname(String Lname) {

		LastName.clear();
		LastName.sendKeys(Lname);

	}

	public void enteraddress(String address2) {

		address.sendKeys(address2);

	}

	public void entercity(String cityy) {

		City.sendKeys(cityy);

	}

	public void enterstate(String text) {

		Select State = new Select(state);

		State.deselectByVisibleText(text);

	}

	public void enterpostacodee(String postalcode) {

		Postalcode.sendKeys(postalcode);

	}

	public void entercountry(String countryy) {

		Select country1 = new Select(country);

		country1.deselectByVisibleText(countryy);

	}

	public void entermobilenumber(String phone) {

		mobilenumber.sendKeys(phone);

	}

	public void entermyaddress(String myaddresss) {

		myaddress.sendKeys(myaddresss);

	}

	public void clcionsavebtn() {

		savebtn.click();


	}
}
