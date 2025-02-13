package com.qa.amexassesement.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.options.WaitForSelectorState;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public abstract class commonFunctions {
	private static Page page;
	
	public static void fnWaitUntillElemVisible(String element) {
		try {
			page.locator(element).first()
			 .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void jsScrollToElement(String element) throws Exception {
		try {
		page.evaluate(element + " => " + element + ".scrollIntoView()");
		System.out.println("Info -> JS Scroll to Element is Sucessful");
	}catch(TimeoutError t){
		System.out.println("Error Info -> Scroll to Element is failed in the Screen");
		t.printStackTrace();
	}
		}

    
    public static boolean waitUntilElementDisplayed(Locator locator, int timeoutSec) {
        boolean elementVisible = locator.isVisible();
        int timer = 0;
        while (!elementVisible && timer < timeoutSec) {
            try {
                Thread.sleep(1000);
                elementVisible = locator.isVisible();
                timer++;

            } catch (Exception e) {
                System.out.println(locator + "was not visible.");
            }
        }
        return elementVisible;
    }
    
   

  
    
}