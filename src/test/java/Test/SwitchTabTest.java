package Test;
import io.qameta.allure.Story;
import org.junit.Test;
import Pages.HomePage;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class SwitchTabTest extends BaseTest {

    @Test
    @DisplayName("Switch_tab")
    @Story("verificar Navegacion entre pestañas")
    public void testSwitchTab() {
        driver.get("https://saucelabs.com/");
        HomePage homePage = new HomePage(driver);

        homePage.getButtonElement().click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String newTabTitle = driver.getTitle();
        System.out.println("El título de la nueva pestaña es: " + newTabTitle);

        driver.switchTo().window(tabs.get(0));
        String originalTabTitle = driver.getTitle();
        System.out.println("El título de la pestaña original es: " + originalTabTitle);
    }
}

