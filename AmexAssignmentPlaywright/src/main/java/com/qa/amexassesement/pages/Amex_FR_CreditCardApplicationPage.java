package com.qa.amexassesement.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Amex_FR_CreditCardApplicationPage {

	private Page page;

	// 1. String Locators - OR
	private String amexIcon = "(//img[@alt='American Express'])[1]";
	private String cartesAmexCardlnk = "//p[normalize-space()='Cartes American Express®']";
	private String lesCartesAmexTitle = "//div[@class='richtext parbase']//div//h1//span//span[@class='heading-5']";
	private String enSaviourPlusBtn = "(//a[@title='Carte Gold American Express']/following::a[@alt='En savoir plus'])[1]";
	private String demandezVotreCarteBtn = "(//a[normalize-space()='Demandez votre Carte'])[1]";
	private String userDetailsTitle = "//p[@class='heading-5 dls-deep-blue font-weight-normal']";
	private String civilitéRadioBtn = "//label[@for='MR']";
	private String firstNameField = "//input[@name='firstName']";
	private String lastNameField = "//input[@name='lastName']";
	private String dobField = "//input[@name='fieldControl-input-dateOfBirth']";
	private String emailAddress = "//input[@name='email']";
	private String phoneNumberField = "//input[@name='mobilePhoneNumber']";
	private String continueBtn = "//button[@type='submit']";
	private String birthNameField = "//input[@name='birthName']";
	private String placeOfBirthField = "//input[@name='placeOfBirth']";
	private String deptOfBirthDrpDwn = "//select[@name='departmentOfBirth']";
	private String residentialAddressField = "//input[@name='residentialAddressLine2']";
	private String postalCodeField = "//input[@name='postcode']";
	private String cityField = "//input[@name='cityTown']";
	private String personalResidentialStatusDrpDwn = "//select[@name='personalResidentialStatus']";
	private String bankAccountNumField = "//input[@name='fieldControl-input-bankAccountNumber";
	private String swiftCodeNumField = "//input[@name='bankIdentifierCode']";
	private String tenureOfAccountDrpDwn = "//select[@name='tenureOfAccount']";
	private String annualPersonalIncomeField = "//input[@name='annualPersonalIncome']";
	private String additionalIncomeRadioBtn = "//span[normalize-space()='Non']";
	private String totalAssestsDrpDwn = "//select[@name='totalAssets']";
	private String occupationDrpDwn = "//select[@name='occupation']";
	private String occupationDescriptionDrpDwn = "//select[@name='occupationDescription']";
	private String mothersMaidenNameField = "//input[@name='mothersMaidenName']";
	private String pinNumField = "//input[@name='pin']";
	private String confirmPinNumField = "//input[@name='confirmPin']";
	private String marketingEmailRadioBtn = "//label[@for='marketingEmailPreferences-false']//span[contains(text(),'Non')]";
	private String marketingSmsRadioBtn = "//label[@for='marketingSMSPhonePostalPreferences-OPT_OUT']";
	private String confirmPage = "//button[normalize-space()='Fermez la Page']";
	private String acceptAllCookies = "//button[contains(text(),'Tout Accepter')]";

	// 2. page constructor:
	public Amex_FR_CreditCardApplicationPage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	
//	Accept cookies
	 public void acceptAllCookies() {
		    // Wait for the "Accept All Cookies" button to appear and click it
		    try {
//		    	commonFunctions.fnWaitUntillElemVisible(acceptAllCookies);
		        page.waitForSelector(acceptAllCookies, new Page.WaitForSelectorOptions().setTimeout(5000)); 
		        page.click(acceptAllCookies);
		        System.out.println("Accepted all cookies.");
		    } catch (Exception e) {
		        System.out.println("Cookie dialog box did not appear or could not be interacted with.");
		    }
		    }
	public String getFRCardsPageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}
	
//	}
//	public String navigateToUrl() {
//		String url = page.url();
//		System.out.println("page url : " + url);
//		return url;
//	}

	public void clickAndVerifyCartesAmexCard() {
		try {
//			boolean isLogoVisible = page.locator(amexIcon).isVisible();
//			// Assert that the logo is visible
////			Assert.assertTrue(isLogoVisible, "The Amex logo is visible on the page.");
//			System.out.println(isLogoVisible);
			Locator carteslnk = page.locator(cartesAmexCardlnk);
			if (carteslnk.isVisible()) {
				page.click(cartesAmexCardlnk);
				System.out.println("Cartes American Express Link is clicked successfullyn");
			} else {
				System.out.println("Cartes American Express Link is NOT visible in the screen");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyFRAllCardsPage() {
		try {
			commonFunctions.fnWaitUntillElemVisible(lesCartesAmexTitle);
//		page.locator("//div[@class='richtext parbase']//div//h1//span//span[@class='heading-5']").first()
//		 .waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(40000));
			commonFunctions.jsScrollToElement(enSaviourPlusBtn);
			Locator enSaviourLnk = page.locator(enSaviourPlusBtn);
			if (enSaviourLnk.isVisible()) {
				page.click(enSaviourPlusBtn);
				System.out.println("En Saviour Plus Link is clicked successfullyn");
			} else {
				System.out.println("En Saviour Link is NOT visible in the screen");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyandClickDemandezVotreCarte() {
		try {
			commonFunctions.fnWaitUntillElemVisible(demandezVotreCarteBtn);
			page.click(demandezVotreCarteBtn);
			System.out.println("DemandezV otre Carte Link is clicked successfullyn");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void clickAndVerifyUserDetailsPage() {
//		try {
//			commonFunctions.fnWaitUntillElemVisible(userDetailsTitle);
//			// Get the title of the page
//	        String pageTitle = page.title();
//	        // Expected title
//	        String expectedTitle = "Souscrivez en quelques minutes";
//	        // Assert that the title matches the expected title
//	        Assert.assertEquals(pageTitle, expectedTitle, "Page title does not match the expected Title.");
//	        
////	        Gender
//	        page.click(civilitéRadioBtn);
//	        System.out.println("Civilite Radio Button is Clicked Successfully");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * Fills user details dynamically using a map of field names and values.
	 *
	 * @param userDetails A map where the key is the field name (e.g., "firstName")
	 *                    and the value is the input value.
	 */
//	 public void fillUserDetails(Map<String, String> userDetails) {
//	        for (Map.Entry<String, String> entry : userDetails.entrySet()) {
//	            String fieldName = entry.getKey();
//	            String value = entry.getValue();
//
//	            // Dynamically construct the selector based on the field name
//	            String selector = String.format("[name='%s']", fieldName); // Example: [name='firstName']
//	            page.fill(selector, value);
//	        }
//	    }

	public void fillUserDetails(List<Map<String, String>> userDetailsPages, List<String> continueButtonSelectors) {
		commonFunctions.fnWaitUntillElemVisible(userDetailsTitle);
		// Get the title of the page
		String pageTitle = page.title();
		// Expected title
		String expectedTitle = "Souscrivez en quelques minutes";
		// Assert that the title matches the expected title
		Assert.assertEquals(pageTitle, expectedTitle, "Page title does not match the expected Title.");

		// Map Excel column names to actual selectors
		Map<String, String> selectorMap = new HashMap<>();
//		Page 1
		selectorMap.put("Gender", civilitéRadioBtn);
		selectorMap.put("FirstName", firstNameField);
		selectorMap.put("LastName", lastNameField);
		selectorMap.put("DOB", dobField);
		selectorMap.put("Email", emailAddress);
		selectorMap.put("Phone", phoneNumberField);

//	    page 2
		selectorMap.put("BirthName", birthNameField);
		selectorMap.put("Place of Birth", placeOfBirthField);
		selectorMap.put("Dept. of Birth", deptOfBirthDrpDwn); // Dropdown selector
		selectorMap.put("Residential Address", residentialAddressField);
		selectorMap.put("PostalCode", postalCodeField);
		selectorMap.put("City", cityField);
		selectorMap.put("Personal Residential Address", personalResidentialStatusDrpDwn); // Drop down

//	    Page 3
		selectorMap.put("Bank Account Number", bankAccountNumField);
		selectorMap.put("Bank Identifier Code", swiftCodeNumField);
		selectorMap.put("Tenure of Account", tenureOfAccountDrpDwn); // Drop down
		selectorMap.put("Annual Personal Income", annualPersonalIncomeField);
		selectorMap.put("Additional Income", additionalIncomeRadioBtn);// radio button
		selectorMap.put("Total Assets", totalAssestsDrpDwn); // Drop down
		selectorMap.put("Occupation", occupationDrpDwn); // Drop down
		selectorMap.put("Occupation Desc.", occupationDescriptionDrpDwn); // Drop down

//	    Page 4
		selectorMap.put("Mother's Maiden Name", mothersMaidenNameField);
		selectorMap.put("Pin Number", pinNumField);
		selectorMap.put("Confirm Pin", confirmPinNumField);
		selectorMap.put("Marketing Email", marketingEmailRadioBtn); // radio btn
		selectorMap.put("Marketing Sms", marketingSmsRadioBtn);// radio btn

		// Map fields that are dropdowns
		List<String> dropdownFields = List.of("Dept. of Birth", "Personal Residential Address", "Tenure of Account",
				"Total Assets", "Occupation", "Occupation Desc.");

		// Map fields that are radio buttons
		List<String> radioButtonFields = List.of("Gender", "Dept. of Birth", "Additional Income", "Marketing Email",
				"Marketing Sms");

//		boolean continueButtonClicked = false;

		for (int i = 0; i < userDetailsPages.size(); i++) {
			Map<String, String> pageDetails = userDetailsPages.get(i);

			for (Map.Entry<String, String> entry : pageDetails.entrySet()) {
				String fieldName = entry.getKey();
				String value = entry.getValue();

				// Get the selector from the map
				String selector = selectorMap.get(fieldName);
				if (selector == null) {
					throw new RuntimeException("Selector not found for field: " + fieldName);
				}

				// Handle dropdown fields
				if (dropdownFields.contains(fieldName)) {
					page.waitForSelector(selector + " option");
					page.selectOption(selector, value);
				}
				// Handle radio button fields
				else if (radioButtonFields.contains(fieldName)) {
					String radioSelector = selector + "[value='" + value + "']";
					page.waitForSelector(radioSelector);
					page.click(radioSelector);
				}
				// Handle text input fields
				else {
					page.fill(selector, value);
				}

				// Click the "Continue" button if there is another page
				if (i < continueButtonSelectors.size()) {
					String continueButtonSelector = continueButtonSelectors.get(i);
					page.click(continueButtonSelector);
				}
			}

		}

	}

	public void ConfirmUserDetails() {
		try {
			commonFunctions.fnWaitUntillElemVisible(confirmPage);
			page.click(confirmPage);
			Thread.sleep(10000);
			page.click(confirmPage);

			Locator carteslnk = page.locator(cartesAmexCardlnk);
			if (carteslnk.isVisible()) {
				page.click(cartesAmexCardlnk);
				System.out.println("Cartes American Express Link is clicked successfullyn");
			} else {
				System.out.println("Cartes American Express Link is NOT visible in the screen");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	public void fillMultiStepUserDetails(String excelFilePath, List<String> continueButtonSelectors)
//			throws IOException {
//		// Read data from Excel
////		List<Map<String, String>> userDetailsPages = readExcelData(excelFilePath);
//
//		// Define field selectors
//		Map<String, String> selectorMap = new HashMap<>();
//		selectorMap.put("FirstName", "#firstName");
//		selectorMap.put("LastName", "#lastName");
//		selectorMap.put("Email", "#email");
//		selectorMap.put("Phone", "#phone");
//		selectorMap.put("Country", "#country"); // Dropdown selector
//		selectorMap.put("State", "#state"); // Dropdown selector
//		selectorMap.put("Address", "#address");
//		selectorMap.put("City", "#city");
//		selectorMap.put("ZipCode", "#zipCode");
//		selectorMap.put("Gender", "input[name='gender']"); // Radio button example
//		selectorMap.put("Subscription", "input[name='subscription']"); // Another radio button example
//
//		// Define dropdown and radio button fields
//		List<String> dropdownFields = List.of("Country", "State");
//		List<String> radioButtonFields = List.of("Gender", "Subscription");
//
//		for (int i = 0; i < userDetailsPages.size(); i++) {
//			Map<String, String> pageDetails = userDetailsPages.get(i);
//
//			for (Map.Entry<String, String> entry : pageDetails.entrySet()) {
//				String fieldName = entry.getKey();
//				String value = entry.getValue();
//
//				String selector = selectorMap.get(fieldName);
//				if (selector == null) {
//					throw new RuntimeException("Selector not found for field: " + fieldName);
//				}
//
//				if (dropdownFields.contains(fieldName)) {
//					page.waitForSelector(selector + " option");
//					page.selectOption(selector, value);
//				} else if (radioButtonFields.contains(fieldName)) {
//					String radioSelector = selector + "[value='" + value + "']";
//					page.waitForSelector(radioSelector);
//					page.click(radioSelector);
//				} else {
//					page.fill(selector, value);
//				}
//			}
//
//			// Click the "Continue" button if there is another page
//			if (i < continueButtonSelectors.size()) {
//				String continueButtonSelector = continueButtonSelectors.get(i);
//				page.click(continueButtonSelector);
//			}
//		}
//	}

}
