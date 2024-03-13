import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class GamilAutomation_BDD {
    private WebDriver driver;

    @Given("I am on the Gmail login page")
    public void iAmOnTheGmailLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viswa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://mail.google.com");
    }

    @When("I log in with my credentials")
    public void iLogInWithMyCredentials() {
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys("your.email@gmail.com");
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("yourpassword");
        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        nextButton.click();
    }

    @And("I compose a new email")
    public void iComposeANewEmail() {
        WebElement composeButton = driver.findElement(By.cssSelector("div.T-I.T-I-KE.L3"));
        composeButton.click();
    }

    @And("I enter recipient, subject, and body")
    public void iEnterRecipientSubjectAndBody() {
        WebElement toField = driver.findElement(By.name("to"));
        toField.sendKeys("recipient@example.com");
        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys("Incubyte");
        WebElement bodyField = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        bodyField.sendKeys("QA test for Incubyte");
    }

    @And("I send the email")
    public void iSendTheEmail() {
        WebElement sendButton = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3"));
        sendButton.click();
    }

    @Then("the email should be sent successfully")
    public void theEmailShouldBeSentSuccessfully() {
        // You can add assertion here to verify email sent successfully
        // For example, you can verify a success message
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
