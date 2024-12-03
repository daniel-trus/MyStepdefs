import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyStepdef {
    WebDriver driver;

    @Given("I have WebBrowser opened")
    public void iHaveWebBrowserOpened() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Daniel\\IdeaProjects\\Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @When("I go to google.com")
    public void iGoToGoogleCom() {
        driver.get("https://www.google.pl/");

    }

    @When("I submit the pop upp")
    public void iSubmitThePopUpp() {
        try {
            driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        } catch (Exception e) {
            System.out.println("Nie znaleziono pop-upu, kontynuujemy");
        }
    }

    @And("^Type (.+) in search engine$")
    public void typeKeysearchInSearchEngine(String phrase) {
        driver.findElement(By.name("q")).sendKeys(phrase);
    }

    @And("^I fill out the form with new data first name (.+) last name (.+) email (.+) password (.+)$")
    public void iFillOutTheFormWithNewDataFirstNameFirstNameLastNameLastNameEmailEmailPasswordPassword(String firstName, String lastName, String email, String password) {

    }

    @And("I submit the search")
    public void iSubmitTheSearch() {
        driver.findElement(By.name("q")).submit();
    }

    @Then("Browser is navigated to search results")
    public void browserIsNavigatedToSearchResults() {
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
