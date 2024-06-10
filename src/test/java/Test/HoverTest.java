package Test;

import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.interactions.Actions;
import Pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    @DisplayName("test hover")
    @Story("Confirmacion de accion al pasar el mouse")
    public void testHover() {
        driver.get("https://saucelabs.com/");
        HomePage homePage = new HomePage(driver);

        Actions actions = new Actions(driver);
        actions.moveToElement(homePage.getHoverElement()).perform();

        assertTrue(homePage.getHoverElement().isDisplayed(), "Debería mostrarse el menu después del hover");
    }
}


