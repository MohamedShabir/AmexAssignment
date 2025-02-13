package com.qa.amexassesment.Base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.qa.amexassesement.factory.PlaywrightFactory;
import com.qa.amexassesement.pages.Amex_FR_CreditCardApplicationPage;


public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	
	protected Properties prop;
	protected Amex_FR_CreditCardApplicationPage amexFR_CCPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(@Optional("chrome") String browserName) {
		pf = new PlaywrightFactory();
		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		page = pf.initBrowser(prop);
		amexFR_CCPage = new Amex_FR_CreditCardApplicationPage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
