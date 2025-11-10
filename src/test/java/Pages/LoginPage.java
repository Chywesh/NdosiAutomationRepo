package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    private String navmaterial_ID = "#nav-btn-practice";
    private String email_ID = "#login-email";
    private String passcode_ID= "#login-password";
    private String loginButton_ID = "#login-submit";

    public LoginPage(Page page){
        this.page = page;
    }
    public void clickLearningMatButton(){page.click(navmaterial_ID);}
    public void enterUsername(String username){page.fill(email_ID,username);}

    public void enterPassword(String pass){page.fill(passcode_ID,pass);}


    public void clickLoginButton(){page.click(loginButton_ID);}

}

