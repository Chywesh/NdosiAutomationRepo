package Tests;

import Base.BaseTrack;
import org.testng.annotations.Test;

public class InvalidLogin extends BaseTrack {
    @Test
    public void clickMaterialBtn() {
        loginPage.clickLearningMatButton();
    }

    @Test
    public void verifyInvalidUserNameTests() throws InterruptedException {
        loginPage.enterUsername(prop.getProperty("invalidUser"));
        String invalidLoginText = loginPage.getInvalidLoginText();
        System.out.println("Invalid credentials: " + invalidLoginText);
    }

    @Test
    public void verifyInvalidPassTests() throws InterruptedException {
        loginPage.enterPassword(prop.getProperty("invalidPass"));
        String invalidPassText = loginPage.getInvalidPassText();
        System.out.println("Invalid credentials: " + invalidPassText);
    }

    @Test
    public void verifyClickLoginTests() throws InterruptedException {
        loginPage.clickLoginButton();
    }
}
