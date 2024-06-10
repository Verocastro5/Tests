package Test;

import io.qameta.allure.Story;
import org.junit.Test;
import Pages.BrowserWindowsPage;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class SwitchWindowsTest extends BaseTest {

    @Test
    @DisplayName("switch_windows")
    @Story("verificar el cambio de ventanas")
    public void testSwitchWindows() {
        driver.get("https://demoqa.com/browser-windows");
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);

        JavascriptExecutor jsExecutor =(JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scroll(0,500);");
        System.out.println("El scroll es realizado");

        browserWindowsPage.getWindowButton().click();

        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println("Título de la nueva ventana: This is a sample page" + driver.getTitle());
    }
}

