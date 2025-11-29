package Tests;

import Base.BaseTrack;
import org.testng.annotations.Test;
import utils.ScreenshotHelper;

public class Logout extends BaseTrack {

    @Test
    public void login() {
        // Navigate to practice page
        loginPage.clickLearningMatButton();
        // Enter credentials
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("pass"));
        // Click login and wait
        loginPage.clickLoginButton();
        //Click logout button
    }

    @Test
    public void verifyLogoutPageTests() {
        ScreenshotHelper.captureOnAssertionPlaywright(
                () -> learningMaterialPage.clickLogoutButton(),
                page,
                "Logout_verifyLogoutPageTests"
        );

        // optional: take a success screenshot
        ScreenshotHelper.takeScreenshot(page, "verifyLogoutPageTests_success");
    }
}
