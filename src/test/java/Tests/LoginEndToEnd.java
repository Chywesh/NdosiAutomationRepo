package Tests;

import Base.BaseTrack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginEndToEnd extends BaseTrack {

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

}
