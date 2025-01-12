package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.AccountRegiterUserName;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass{


	@Test(enabled =false)
	public void  verifyRegitrationAndLogin() {


		indexPage pg = new indexPage(driver);
		pg.Clickonsigninbutton();
		logger.info("clicked on sign in button");

		myAccount myaccountpg = new myAccount(driver);
		myaccountpg.entercreateemailidaddress("lahu780@gmail.com");
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
	}

	@Test(dataProvider = "LoginDataProvider")
	public void VerifyLogin(String userEmail , String userPwd, String exceptedUsername) throws IOException 
	{

		logger.info("VerifyLogin test case excuetion started");

		indexPage pg = new indexPage(driver);
		pg.Clickonsigninbutton();
		logger.info("clicked on sign in button");

		myAccount myaccountpg = new myAccount(driver);

		myaccountpg.enterRegesteremailadd(userEmail);
		logger.info("Entered email address");
		myaccountpg.enterRegesterpwd(userPwd);
		logger.info("Entered Password");
		myaccountpg.clicksubmit();

		AccountRegiterUserName un = new AccountRegiterUserName(driver);
		String username = un.getusername();


		if(username.equals(exceptedUsername)) 
		{
			logger.info("Verify login - Passed");
			Assert.assertTrue(true);
			AccountRegiterUserName unpg = new AccountRegiterUserName(driver);
			unpg.signout();
		}
		else
		{
			logger.info("Verify login - Failed");
			capturescreenshot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}

	@DataProvider(name = "LoginDataProvider")
	public String [][] LoginDataProvider()

	{

		String fileName = System.getProperty("user.dir") + "\\TestData\\Datadriventesting.xlsx";

		int totalrows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalcells = ReadExcelFile.getCellCount(fileName, "LoginTestData");

		String data[][] = new String[totalrows-1][totalcells];

		for(int i=1; i<totalrows; i++) //rows 1, 2
		{
			for(int j=0; j<totalcells; j++ ) // col 0 , 1 , 2

			{

				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}

		return data;
	}

}
