package com.yatra.qa.testcases;

import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	
	 public HomePageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		HomePage homepage=new HomePage();
	}

}
