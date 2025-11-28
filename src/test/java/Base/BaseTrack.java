package Base;

import BrowserGear.BrowserFactory;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTrack {
    BrowserFactory play;
    public Page page;
    public LoginPage loginPage;
    public LearningMaterialPage learningMaterialPage;
    public Properties prop;

    @BeforeTest
    public void setup(){
        play = new BrowserFactory();
        prop = play.init_prop();
        play.runBrowser(prop);
        page = play.getPage();
        loginPage = new LoginPage(page);
        learningMaterialPage = new LearningMaterialPage(page);
    }

}
