import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium_NaukaWłasna {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\IdeaProjects\\Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--kiosk");
//        options.addArguments("--incognito");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://tantis.pl/");
        sleep(1000);
    }

    @Test
    public void tantisTest() {
        sleep(1000);
        WebElement shadowHost = driver.findElement(By.cssSelector("#CybotCookiebotDialog > ui-modal > span:nth-child(4) > div > ui-button:nth-child(2)"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("button"));
        shadowElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"CybotCookiebotDialog\"]/ui-modal/span[4]/div/ui-button[2]//button")));
        element.click();
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialog\"]/ui-modal/span[4]/div/ui-button[2]//button")).click();

        driver.findElement(By.xpath("//*[@id=\"shopContent\"]/main/div[1]/div/div[1]/div[1]/div/div/ul/li[1]/a/span")).getCssValue("color");
        sleep(1000);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    void sleep(int ms) {
        try {
            Thread.sleep(ms); // Czekamy 2 sekundy
        } catch (InterruptedException e) {
            // W przypadku, gdyby wątek został przerwany, możemy obsłużyć wyjątek
            e.printStackTrace();
        }    }

}
