package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By hoverElement = By.className("MuiStack-root");
    private By buttonElement = By.className("MuiButton-root");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHoverElement() {
        return driver.findElement(hoverElement);
    }

    public WebElement getButtonElement() {
        return driver.findElement(buttonElement);
    }
}

