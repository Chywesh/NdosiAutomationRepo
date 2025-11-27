package Tests;

import org.testng.annotations.Test;

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

}
