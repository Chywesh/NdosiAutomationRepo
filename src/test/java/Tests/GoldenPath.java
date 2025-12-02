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

    @Test(priority = 1)
    public void verifyClickWebAdvancedOptionTests() {
        learningMaterialPage.clickWebAutomationAdvancedTab();
    }

    @Test(priority = 2)
    public void verifySelectTabletOptionsTests() {
        learningMaterialPage.selectTabletOption();
        learningMaterialPage.selectTabletBrandOption();
        learningMaterialPage.clickStorageTypeSelect_ID();
        learningMaterialPage.selectColorChoiceOption();
        learningMaterialPage.inputQuantityOption("2");
        learningMaterialPage.inputAddressOption("1522 SmartLink");
        learningMaterialPage.clickNextButton();
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void verifyClickShippingOptionTests(){
        learningMaterialPage.verifyClickExpressShippingOption();
    }
    @Test(priority = 5)
    public void verifyClickWarrantyOptionTests(){
        learningMaterialPage.verifyClickWarrantyOption();
    }
    @Test(priority = 6)
    public void verifyDiscountCodeOptionTests(){
        learningMaterialPage.verifyDiscountCodeInputOption("50");

    }
    @Test(priority = 7)
    public void verifyDiscountAppliedTests(){
        String discountApplied = learningMaterialPage.verifyDiscountAppliedMessage();
        System.out.println("Discount Applied Details: " + discountApplied);
        Assert.assertFalse(discountApplied == null || discountApplied.trim().isEmpty(), "Expected a non-empty discount applied details after entering discount code");

    }
    @Test(priority = 8)
    public void verifyUnitPriceDetailsTests() {
        String unitPriceDetails = learningMaterialPage.verifySelectedDeviceUnitPrice();
        System.out.println("Unit Price Details: " + unitPriceDetails);
        Assert.assertFalse(unitPriceDetails == null || unitPriceDetails.trim().isEmpty(), "Expected a non-empty unit price details after clicking next");

    }
    @Test(priority = 9)
    public void verifySubtotalPriceDetailsTests() {
        String subtotalPriceDetails = learningMaterialPage.verifySubtotalAmount();
        System.out.println("Subtotal Price Details: " + subtotalPriceDetails);
        Assert.assertFalse(subtotalPriceDetails == null || subtotalPriceDetails.trim().isEmpty(), "Expected a non-empty subtotal price details after clicking next");
    }
    @Test(priority = 10)
    public void verifyWarrantyPriceDetailsTests() {
        String warrantyPriceDetails = learningMaterialPage.verifyWarrantAmount();
        System.out.println("Warranty Price Details: " + warrantyPriceDetails);
        Assert.assertFalse(warrantyPriceDetails == null || warrantyPriceDetails.trim().isEmpty(), "Expected a non-empty warranty price details after clicking next");
    }
    @Test(priority = 11)
    public void verifyShippingPriceDetailsTests() {
        String shippingPriceDetails = learningMaterialPage.verifyShippingAmount();
        System.out.println("Shipping Price Details: " + shippingPriceDetails);
        Assert.assertFalse(shippingPriceDetails == null || shippingPriceDetails.trim().isEmpty(), "Expected a non-empty shipping price details after clicking next");
    }
    @Test(priority = 12)
    public void verifyDiscountPriceDetailsTests() {
        String discountAmountDetails = learningMaterialPage.verifyDiscountedAmount();
        System.out.println("Discount Amount Details: " + discountAmountDetails);
        Assert.assertFalse(discountAmountDetails == null || discountAmountDetails.trim().isEmpty(), "Expected a non-empty discount amount details after clicking next");
    }
    @Test(priority = 13)
    public void verifyTotalPriceDetailsTests() {
        String totalAmountDetails = learningMaterialPage.verifyTotalAmount();
        System.out.println("Total Amount Details: " + totalAmountDetails);
        Assert.assertFalse(totalAmountDetails == null || totalAmountDetails.trim().isEmpty(), "Expected a non-empty total amount details after clicking next");
    }

}
