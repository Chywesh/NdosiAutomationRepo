package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginPage {
    Page page;
    // Locators
    final String nav_material_ID = "#nav-btn-practice";
    final String email_ID = "#login-email";
    final String passcode_ID= "#login-password";
    final String loginButton_ID = "#login-submit";
    // Use sibling selectors commonly used for inline error messages; keep alternatives
    final String invalidLogin_ID = "#login-email ~ div.error-message"; // primary
    final String invalidLogin_alt = "#login-email + div .error-message"; // alt
    final String invalidPass_ID = "#login-password ~ div.error-message"; // primary
    final String invalidPass_alt = "#login-password + div .error-message"; // alt
    final String trimmedUsername_ID = email_ID;
    final String trimmedPassword_ID = passcode_ID;
    final String switchTabs_ID = "#nav-btn-contact";

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
        // try primary selector then fallback
        String text = tryGetText(invalidLogin_ID);
        if(text.isEmpty()) text = tryGetText(invalidLogin_alt);
        return text.trim();
    }
    public String getInvalidPassText(){
        String text = tryGetText(invalidPass_ID);
        if(text.isEmpty()) text = tryGetText(invalidPass_alt);
        return text.trim();
    }

    private String tryGetText(String selector){
        try{
            Locator loc = page.locator(selector);
            // wait up to 5s for the element to appear and be visible
            loc.waitFor(new Locator.WaitForOptions().setTimeout(5000L).setState(WaitForSelectorState.VISIBLE));
            String txt = loc.textContent();
            return txt == null ? "" : txt;
        } catch (Exception e){
            return "";
        }
    }
    //Verify trim input methods
    public void enterSpacedUsername(String usernameSpaced){page.fill(trimmedUsername_ID,usernameSpaced);}
    public void enterSpacedPassword(String passSpaced){page.fill(trimmedPassword_ID,passSpaced);}

    //Click login button method - wait 5 seconds after clicking to allow post-login processing
    public void clickLoginButton(){
        page.click(loginButton_ID, new Page.ClickOptions().setTimeout(60000));
        page.waitForTimeout(5000); // wait 5 seconds after login
    }

    //Switch tabs method
    public void switchTabsContactsButton(){
        page.waitForSelector(switchTabs_ID, new Page.WaitForSelectorOptions().setTimeout(60000));
        page.click(switchTabs_ID);
    }
    public void clickPracticePageButton(){page.click(nav_material_ID);}


}
