package Test;

import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import Pages.DynamicPropertiesPage;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest extends BaseTest {

    @Test
    @DisplayName("Fluent_wait")
    @Story("Validacion de visibilidad del elemento")
    public void testFluentWait() {
        driver.get("https://demoqa.com/dynamic-properties");
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until((Function<? super WebDriver, WebElement>)ExpectedConditions.visibilityOf(dynamicPropertiesPage.getVisibleAfterButton()));
        element.click();
        System.out.println("El resultado es: Exitoso");
    }
}

