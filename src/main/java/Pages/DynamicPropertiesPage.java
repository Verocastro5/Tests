package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicPropertiesPage {
    private WebDriver driver;

    private By visibleAfterButton = By.id("visibleAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getVisibleAfterButton() {
        return driver.findElement(visibleAfterButton);
    }
}

