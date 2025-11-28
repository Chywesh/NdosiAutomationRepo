package Tests;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import utils.ScreenshotHelper;

public class SwitchTabs extends Base.BaseTrack {


    @Test
    public void clickMaterialBtn() {
        loginPage.clickLearningMatButton();
    }

    @Test
    public void verifyEnterUserNameTests() throws InterruptedException {
        loginPage.enterUsername(prop.getProperty("username"));

    }

    @Test
    public void verifyEnterPasswordTests() {
        loginPage.enterPassword(prop.getProperty("pass"));
    }

    @Test
    public void verifyClickLoginTests() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Test
    public void verifySwitchTabsContactsButton() {
        loginPage.switchTabsContactsButton();
    }
    @Test(dependsOnMethods = {"verifySwitchTabsContactsButton"})
    public void reClickMaterialBtnFromContacts() {
        loginPage.clickPracticePageButton();}

    @Test(priority = 7)
    public void verifyLoginPageTests() {
        // capture screenshot on assertion failure
        ScreenshotHelper.captureOnAssertionPlaywright(
                () -> loginPage.verifyLoginPageHeading(),
                page,
                "SwitchTabs_verifyLoginPageTests"
        );

        // optional: take a success screenshot
        ScreenshotHelper.takeScreenshot(page, "SwitchTabs_verifyLoginPageTests_success");
    }
}


