package Tests;

import Base.BaseTrack;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLogin extends BaseTrack {
    @Test
    public void clickMaterialBtn() {
        loginPage.clickLearningMatButton();
    }

    @Test
    public void verifyInvalidUserNameTests() throws InterruptedException {
        loginPage.enterUsername(prop.getProperty("invalidUser"));
        loginPage.enterPassword(prop.getProperty("invalidPass"));
        loginPage.clickLoginButton();
        String invalidLoginText = loginPage.getInvalidLoginText();
        System.out.println("Invalid credentials (user): " + invalidLoginText);
        Assert.assertFalse(invalidLoginText.isEmpty(), "Expected an invalid username error message");
    }

    @Test
    public void verifyInvalidPassTests() throws InterruptedException {
        // Provide a valid username but invalid password to check password error
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("invalidPass"));
        loginPage.clickLoginButton();
        String invalidPassText = loginPage.getInvalidPassText();
        System.out.println("Invalid credentials (pass): " + invalidPassText);
        Assert.assertFalse(invalidPassText.isEmpty(), "Expected an invalid password error message");
    }

    @Test
    public void verifyClickLoginTests() throws InterruptedException {
        // Simple smoke of clicking login
        loginPage.clickLoginButton();
    }
}
