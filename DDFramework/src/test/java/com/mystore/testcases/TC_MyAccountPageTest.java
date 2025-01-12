package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.AccountRegiterUserName;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;

public class TC_MyAccountPageTest extends BaseClass{


	@Test
	public void  verifyRegitrationAndLogin() throws InterruptedException {


		indexPage pg = new indexPage(driver);
		pg.Clickonsigninbutton();
		logger.info("clicked on sign in button");

		myAccount myaccountpg = new myAccount(driver);
		myaccountpg.entercreateemailidaddress("lahu16@gmail.com");
		logger.info("Entered email address");
		myaccountpg.entersubmitcreate();
		logger.info("clicked on sumbit");

		AccountCreationDetails ac = new AccountCreationDetails(driver);

		ac.mrradiobtn();
		ac.entercustomerfirstname("Lahu");
		ac.entercustomerlastname("Kamble");
		ac.enterpassowrd("LK@345");
		ac.registerbtn();
		
		logger.info("Entered Account customer details");
		
		AccountRegiterUserName un = new AccountRegiterUserName(driver);

		String username = un.getusername();

		Assert.assertEquals("Lahu Kamble", username);
		
		logger.info("Verify Regiter User Name");
		
//		JavascriptExecutor j = (JavascriptExecutor)driver;
//    	j.executeScript("window.scrollBy(0,400)");
//    	Thread.sleep(1000);
		ac.clickaddress();
		ac.firstname("Lahu");
		ac.lastname("Kamble");
		ac.enteraddress("30 victoria cres");
		ac.entercity("pune");
		ac.enterstate("Alabama");
		ac.enterpostacodee("54646");
		ac.entercountry("United States");
		ac.entermobilenumber("7972220876");
		ac.entermyaddress("someshware nagar");
		ac.clcionsavebtn();
		
		logger.info("Entered Address details");

	}
	
	@Test(enabled =false)
	public void VerifyLogin() throws IOException {
		
		logger.info("VerifyLogin test case excuetion started");
		
		indexPage pg = new indexPage(driver);
		pg.Clickonsigninbutton();
		logger.info("clicked on sign in button");
		
		myAccount myaccountpg = new myAccount(driver);
		
		myaccountpg.enterRegesteremailadd("lahu780@gmail.com");
		logger.info("Entered email address");
		myaccountpg.enterRegesterpwd("LK@345");
		logger.info("Entered Password");
		myaccountpg.clicksubmit();
		
		AccountRegiterUserName un = new AccountRegiterUserName(driver);
		
		
		String username = un.getusername();
		if(username.equals("Lahu Kamble")) 
		{
			logger.info("Verify login - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify login - Failed");
			capturescreenshot(driver,"VerifyLogin");
			Assert.assertFalse(false);
		}
	}

}
