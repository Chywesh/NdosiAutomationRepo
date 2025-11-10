package Base;

import BrowserGear.BrowserFactory;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTrack {
    BrowserFactory play;
    Page page;
    LoginPage loginPage;
    Properties prop;

    @BeforeTest
    public void setup(){
        play = new BrowserFactory();
        prop = play.init_prop();
        play.runBrowser(prop);
        page = play.getPage();
        loginPage = new LoginPage(page);
    }

}
