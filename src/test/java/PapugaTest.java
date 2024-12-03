import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PapugaTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\IdeaProjects\\Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://przyklady.javastart.pl/jpetstore/actions/Catalog.action;jsessionid=4C4D366AC8E37DF1CD49D82701690A79");
        sleep(1000);
    }

    @Test
    public void papugaTest() {
        driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")).click();
        driver.findElement(By.cssSelector("#Catalog > table > tbody > tr:nth-child(2) > td:nth-child(1) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input")).click();
        boolean value = driver.findElement(By.xpath("//*[@id=\"Cart\"]/a")).isDisplayed();
        System.out.println(value);

        Assertions.assertTrue(value);
        Assertions.assertTrue(true, String.valueOf(value));

        sleep(1000);

        WebElement loginInput = driver.findElement(By.name("email"));
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
