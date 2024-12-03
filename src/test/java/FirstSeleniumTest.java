import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstSeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\IdeaProjects\\Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.pl/");
        sleep(1000);
    }
    @Test
    public void searchTest() {
        try {
            driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono pop-upu, kontynuujemy");
        }

        driver.findElement(By.name("q")).sendKeys("Selenium");
        sleep(1000);
        driver.findElement(By.name("q")).submit();

        String expectedUrl = "https://www.google.pl/search?q=Selenium&sca_esv=2e6106e84784cb2f&sxsrf=ADLYWIKDW2YdNewxQR6CeZS1rQo6iJYTWQ%3A1730799404719&source=hp&ei=LOcpZ7yyKc-whbIP8OrM6As&iflsig=AL9hbdgAAAAAZyn1PHPfGM1WzXlXJth8dBsl0baApwug&ved=0ahUKEwi8-MWd8sSJAxVPWEEAHXA1E70Q4dUDCBY&uact=5&oq=Selenium&gs_lp=Egdnd3Mtd2l6IghTZWxlbml1bTIMECMYgAQYExgnGIoFMgwQIxiABBgTGCcYigUyDBAjGIAEGBMYJxiKBTIIEAAYgAQYywEyCBAAGIAEGMsBMggQABiABBjLATIIEAAYgAQYywEyCBAAGIAEGMsBMggQABiABBjLATIIEAAYgAQYywFIoApQAFi_CHAAeACQAQCYAVCgAYAEqgEBOLgBA8gBAPgBAZgCCKACvQTCAgoQIxiABBgnGIoFwgIEECMYJ8ICCxAuGIAEGNEDGMcBwgIFEAAYgATCAgUQLhiABMICDhAuGIAEGMcBGI4FGK8BwgIIEC4YgAQY1ALCAggQLhiABBjLAZgDAJIHATigB7xn&sclient=gws-wiz";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl != null;
        Assertions.assertTrue(actualUrl.contains("q=Selenium"));
        Assertions.assertEquals(expectedUrl, actualUrl);

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
