package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    // Locators
    final String nav_material_ID = "#nav-btn-practice";
    final String email_ID = "#login-email";
    final String passcode_ID= "#login-password";
    final String loginButton_ID = "#login-submit";
    final String invalidLogin_ID = "#login-email ~ div.error-message"; // Updated selector for error message
    final String invalidPass_ID = "#login-password ~ div.error-message"; // Updated selector for error message
    final String trimmedUsername_ID = email_ID;
    final String trimmedPassword_ID = passcode_ID;
    final String switchTabs_ID = "nav-btn-contact";

    // Constructor
    public LoginPage(Page page){
        this.page = page;
    }
    //Navigation method
    public void clickLearningMatButton(){page.click(nav_material_ID);}

    //Valid end to end login methods
    public void enterUsername(String username){page.fill(email_ID,username);}
    public void enterPassword(String pass){page.fill(passcode_ID,pass);}


    //Invalid login methods
    public String getInvalidLoginText(){
        page.waitForSelector(invalidLogin_ID); // Ensure the error message is visible
        return page.textContent(invalidLogin_ID);
    }
    public String getInvalidPassText(){
        page.waitForSelector(invalidPass_ID); // Ensure the error message is visible
        return page.textContent(invalidPass_ID);
    }
    //Verify trim input methods
    public void enterSpacedUsername(String usernameSpaced){page.fill(trimmedUsername_ID,usernameSpaced);}
    public void enterSpacedPassword(String passSpaced){page.fill(trimmedPassword_ID,passSpaced);}

    //Click login button method
    public void clickLoginButton(){page.click(loginButton_ID, new Page.ClickOptions().setTimeout(60000));}

    //Switch tabs method
    public void switchTabsContactsButton(){page.click(switchTabs_ID);}
}
