package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    private String email_ID = "#login-email";
    private String passcode_ID= "# login-password";
    private String login_ID = "#login-submit";

    public LoginPage(Page page){
        this.page = page;
    }
}
