package com.wordpress.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.SearchFlightPage;
import com.amazon.qa.util.testUtil;


public class SearchFlightPageTest extends TestBase {
	
SearchFlightPage SearchFlightPage;


	
	@BeforeMethod
	public void setup() {
		 initialization();
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(dataProvider="getData")
	public void SearchFligh(String email,String password) throws Throwable {
		SearchFlightPage =new SearchFlightPage();
		SearchFlightPage.SercheFlight(email, password);
		SearchFlightPage.countFight();
	}
	
	@DataProvider
	public static Object[][] getData()
	{
	  return testUtil.getData("LoginTest");
	}
	
	
}
