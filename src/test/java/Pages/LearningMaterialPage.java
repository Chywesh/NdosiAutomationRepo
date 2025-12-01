package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static java.lang.Thread.sleep;

public class LearningMaterialPage {
    Page page;

    // Primary selector and sensible fallbacks
    final String[] homeHeadingFallbacks = new String[]{"#practice-heading", "h1", "header h1", ".page-title", ".heading", "main h1"};
    final String logoutButton_ID = "#logout-button";
    final String webAutomationAdvanced_ID = "//span[normalize-space()='Web Automation Advance']";
    final String deviceTypeSelect_ID = "#deviceType";

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickWebAutomationAdvancedTab() {
        page.click(webAutomationAdvanced_ID);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectTabletOption() {
        page.locator("select#deviceType").selectOption("Tablet");
    }
    public void selectTabletBrandOption() {
        page.locator("select#brand").selectOption("Samsung");
    }
    public void clickStorageTypeSelect_ID() {
        page.click("id=storage-256GB");
    }
    public void selectColorChoiceOption() {
        page.locator("select#color").selectOption("White");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void inputQuantityOption(String quantity) {
        page.fill("id=quantity", quantity);
    }
    public void inputAddressOption(String address) {
        page.fill("id=address", address);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickNextButton() {
        page.click("id=inventory-next-btn");
    }
    public String verifySelectedDeviceInfo() {
        String deviceType = page.locator("id=summary-device-type").textContent();
        String brand = page.locator("id=summary-brand").textContent();
        String storage = page.locator("id=summary-storage").textContent();
        String color = page.locator("id=summary-color").textContent();
        String quantity = page.locator("id=summary-quantity").textContent();
        String address = page.locator("id=summary-address").textContent();

        System.out.println("Selected Device Information:");
        System.out.println("Device Type: " + deviceType);
        System.out.println("Brand: " + brand);
        System.out.println("Storage: " + storage);
        System.out.println("Color: " + color);
        System.out.println("Quantity: " + quantity);
        System.out.println("Address: " + address);
        return deviceType + ", " + brand + ", " + storage + ", " + color + ", " + quantity + ", " + address;
    }


}
