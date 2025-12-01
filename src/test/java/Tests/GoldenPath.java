package Tests;

import Base.BaseTrack;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotHelper;

public class GoldenPath extends BaseTrack {

    @Test
    public void loginAndVerifyHomePage() {
        // Navigate to practice page
        loginPage.clickLearningMatButton();
        // Enter credentials
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("pass"));
        // Click login and wait
        loginPage.clickLoginButton();
        // Verify home page heading is present and not empty
        String materialLearningPageTitle = learningMaterialPage.getLeaningMatPageHeadingText();
        System.out.println("Home Page Title: " + materialLearningPageTitle);
        Assert.assertFalse(materialLearningPageTitle == null || materialLearningPageTitle.trim().isEmpty(), "Expected a non-empty home page heading after login");

    }

    @Test
    public void verifyClickWebAdvancedOptionTests() {
        ;
        learningMaterialPage.clickWebAutomationAdvancedTab();
    }

    @Test
    public void verifySelectTabletOptionsTests() {
        learningMaterialPage.selectTabletOption();
        learningMaterialPage.selectTabletBrandOption();
        learningMaterialPage.clickStorageTypeSelect_ID();
        learningMaterialPage.selectColorChoiceOption();
        learningMaterialPage.inputQuantityOption("2");
        learningMaterialPage.inputAddressOption("1522 SmartLink");
        learningMaterialPage.clickNextButton();
    }

    @Test
    public void verifySelectedItemDetailsTests() {
        String selectedItemDetails = learningMaterialPage.verifySelectedDeviceInfo();
        System.out.println("Selected Item Details: " + selectedItemDetails);
        Assert.assertFalse(selectedItemDetails == null || selectedItemDetails.trim().isEmpty(), "Expected a non-empty selected item details after clicking next");
        ScreenshotHelper.captureOnAssertionPlaywright(() -> {
                    // No action needed here, just capturing the screenshot
                },
                page,
                "GoldenPath_verifySelectedItemDetailsTests"
        );


    }
}
