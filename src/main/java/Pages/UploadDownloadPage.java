package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage {
    private WebDriver driver;

    private By uploadFileInput = By.id("uploadFile");

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getUploadFileInput() {
        return (By) driver.findElement(uploadFileInput);
    }
}

