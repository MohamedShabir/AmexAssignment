package com.qa.amexassesment.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.amexassesement.pages.commonFunctions;
import com.qa.amexassesement.utils.ExcelReader;
import com.qa.amexassesment.Base.BaseTest;

public class AmexFRCreditCardApplicationTest extends BaseTest {
    private String filePath = ".\\src\\test\\resources\\testdata\\TestData.xlsx";
    private String sheetName = "UserDetails";
    
//    private List<Map<String, String>> testData;
    // Prepare test data for each page
    List<Map<String, String>> testData = ExcelReader.readTestData(filePath, sheetName);

    @BeforeClass
    public void setUp() {
//        testData = ExcelReader.readTestData(filePath, sheetName);
    }

    @Test
    public void testCreditCardApplicationFlow() {
    	
        String actualURL = amexFR_CCPage.getFRCardsPageURL();
        Assert.assertEquals(actualURL, prop.getProperty("url"));
        
        
        amexFR_CCPage.clickAndVerifyCartesAmexCard();
        amexFR_CCPage.verifyFRAllCardsPage();
        amexFR_CCPage.verifyandClickDemandezVotreCarte();
        
        // Iterate through test data and execute the test for each row
        for (Map<String, String> data : testData) {
            // Fill user details from Excel data
//        	amexFR_CCPage.fillUserDetails(
//                    data.get("FirstName"),
//                    data.get("LastName"),
//                    data.get("Email")
//            );
//            userDetailsPage.clickOnSauvegarderEtContinuer();
        
     
        
    }
    
    }   
}