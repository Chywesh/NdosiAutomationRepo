package BrowserGear;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {
    private BrowserContext browserContext;
    private Page page;
    Browser browser;
    Properties prop;

    public void runBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        Playwright playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case  "chromium":
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
        }
        browserContext = browser.newContext();
        page = browser.newContext().newPage();
        page.navigate(prop.getProperty("url").trim());
    }

    public Page getPage() {
        return page;
    }
    public Properties init_prop(){
        if (prop == null){
            prop = new Properties();
            try{
                prop.load(getClass().getClassLoader().getResourceAsStream("src/test/java/resources/Configs/config.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return prop;
    }
}
