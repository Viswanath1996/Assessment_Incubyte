package LoginTestcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailAutomation {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\viswa\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Gmail
        driver.get("https://mail.google.com");

        // Enter your email address
        WebElement emailInput = driver.findElement(By.id("identifierId"));
        emailInput.sendKeys("id@gmail.com");

        // Click on the "Next" button
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();

        // Wait for password input to be visible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        // Enter your password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password");

        // Click on the "Next" button
        WebElement nextButton = driver.findElement(By.id("passwordNext"));
        nextButton.click();

        // Wait for the "Compose" button to be clickable
        WebElement composeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.T-I.T-I-KE.L3")));

        // Click on the "Compose" button
        composeButton.click();

        // Wait for the "To" field to be visible
        WebElement toField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));

        // Enter recipient email address
        toField.sendKeys("recipient@mail.com");

        // Enter subject
        WebElement subjectField = driver.findElement(By.name("subjectbox"));
        subjectField.sendKeys("Incubyte");

        // Enter email body
        WebElement bodyField = driver.findElement(By.cssSelector("div[aria-label='Message Body']"));
        bodyField.sendKeys("QA test for Incubyte");

        // Click on the "Send" button
        WebElement sendButton = driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3"));
        sendButton.click();

        // Close the browser
        driver.quit();
    }
}
