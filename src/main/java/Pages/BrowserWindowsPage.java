package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindowsPage {
    private WebDriver driver;

    private By windowButton = By.id("windowButton");

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWindowButton() {
        return driver.findElement(windowButton);
    }
}

