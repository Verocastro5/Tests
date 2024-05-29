package org.example;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestSelenium {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        // tiempo de espera
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //ingresar a la pagina web
        driver.get("https://saucelabs.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testHover() {
        // Encontrar el elemento y hacer hover
        WebElement elementToHover = driver.findElement(By.className("MuiStack-root"));

        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

        // Realizar la acción de hover
        actions.moveToElement(elementToHover).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        //verificacion despues del hover
        WebElement menu= driver.findElement(By.className("MuiStack-root"));
        assertTrue(menu.isDisplayed(), " Debería mostrarse el menu después del hover");

        //cerrar el navegador
        //driver.quit();

    }
    @Test
    public void Switch_Tab(){
        driver.get("https://saucelabs.com/");
        //encontrar el elemento que abre la otra pestaña
        WebElement element = driver.findElement(By.className("MuiButton-root"));
        element.click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //seleccionar la nueva pestaña
        driver.switchTo().window(tabs.get(1));

        // Verificar el título de la nueva pestaña
        String newTabTitle = driver.getTitle();
        System.out.println("El título de la nueva pestaña es: Saucelab-Accounts" + newTabTitle);

        //Verificar el titulo de la pagina original
        driver.switchTo().window(tabs.get(0));
        String originalTabTitle = driver.getTitle();
        System.out.println("El título de la pestaña original es: Saucelabs" + originalTabTitle);

    }

    @Test
    public void navigateAndSwitchWindows() {
        // Navegar a la nueva URL
        driver.navigate().to("https://demoqa.com/browser-windows");
        WebElement button = driver.findElement(By.id("windowButton"));
        // Hacer clic en el enlace para abrir una nueva ventana
        button.click();

        // Obtener el handle de la ventana original
         String originalWindow = driver.getWindowHandle();

        // Obtener todos los handles
         Set<String> allWindows = driver.getWindowHandles();

        // Cambiar a la nueva ventana
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
            // Realizar acciones en la nueva ventana
            System.out.println("Título de la nueva ventana: " + driver.getTitle());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            //cerrar ventana original
            //driver.close();
        }
    }

    @Test
    public void Loading_file() {

        // Navegar a la nueva URL
        driver.navigate().to("https://demoqa.com/upload-download");

        // Encontrar el elemento de carga de archivos

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadFile")));
        //element.click();
        // Subir el archivo
        element.sendKeys("Documentos\\resultado");

    }
    @After
    public void tearDown(){
        //cerrar el navegador
        driver.quit();

    }
    @Test
    public void fluent_wait(){
        // Navegar a la nueva URL
        driver.navigate().to("https://demoqa.com/dynamic-properties");

        // Configura Fluent Wait
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60)) // Tiempo máximo de espera
                .pollingEvery(Duration.ofSeconds(2)) // Intervalo de sondeo
                .ignoring(NoSuchElementException.class); // Ignorar excepciones
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        element.click();
        System.out.println("El resultado es: Exitoso");
    }


}







