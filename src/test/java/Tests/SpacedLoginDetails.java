package Tests;

import Base.BaseTrack;
import org.testng.annotations.Test;

public class SpacedLoginDetails extends BaseTrack {
    // Test to verify login with spaces in username and password it must trim spaces and login successfully
    @Test
    public void clickMaterialBtn() {
        loginPage.clickLearningMatButton();
    }
    @Test
    public void verifyEnterSpacedUserNameTests() throws InterruptedException {
        loginPage.enterSpacedUsername(prop.getProperty("usernameWithSpaces"));}
    @Test
    public void verifyEnterSpacedPasswordTests(){
        loginPage.enterSpacedPassword(prop.getProperty("passWithSpaces"));}
    @Test
    public void verifyClickLoginTests() throws InterruptedException {
        loginPage.clickLoginButton();}
}
