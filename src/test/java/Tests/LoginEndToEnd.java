package Tests;

import Base.BaseTrack;
import org.testng.annotations.Test;

public class LoginEndToEnd extends BaseTrack {
    @Test
    public void clickMaterialBtn() {
        loginPage.clickLearningMatButton();
    }

    @Test
    public void verifyEnterUserNameTests() throws InterruptedException {
        loginPage.enterUsername(prop.getProperty("username"));

    }
    @Test
    public void verifyEnterPasswordTests(){
        loginPage.enterPassword(prop.getProperty("pass"));
    }
    @Test
    public void verifyClickLoginTests() throws InterruptedException {
        loginPage.clickLoginButton();

    }

}
