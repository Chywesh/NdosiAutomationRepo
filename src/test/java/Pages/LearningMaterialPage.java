package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LearningMaterialPage {
    Page page;

    // Primary selector and sensible fallbacks
    final String[] homeHeadingFallbacks = new String[]{"#practice-heading", "h1", "header h1", ".page-title", ".heading", "main h1"};
    final String logoutButton_ID = "#logout-button";

    public LearningMaterialPage(Page page) {
        this.page = page;
    }
    // Method to verify if on learning material home page by checking for heading text
    public String getLeaningMatPageHeadingText() {
        for (String selector : homeHeadingFallbacks) {
            try {
                Locator loc = page.locator(selector).first();
                loc.waitFor(new Locator.WaitForOptions().setTimeout(5000L).setState(WaitForSelectorState.VISIBLE));
                String txt = loc.textContent();
                if (txt != null && !txt.trim().isEmpty()) {
                    return txt.trim();
                }
            } catch (Exception ignored) {
                // try next selector
            }
        }
        // none found
        return "";
    }
    public void clickLogoutButton() {
        page.click(logoutButton_ID);
    }


}
