package Test;

import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.UploadDownloadPage;
import java.time.Duration;

public class LoadingFileTest extends BaseTest {

    @Test
    @DisplayName("Loading_file")
    @Story("verificar carga de archivo")
    public void testLoadingFile() {
        driver.get("https://demoqa.com/upload-download");
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(uploadDownloadPage.getUploadFileInput()));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", uploadDownloadPage.getUploadFileInput());

        // Subir el archivo
        //uploadDownloadPage.getUploadFileInput().Sendkeys("");
    }
}

