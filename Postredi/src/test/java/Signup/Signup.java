package Signup;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Signup {
    public WebDriver driver;

    public Signup(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // First name
        WebElement firstname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-42")));
        firstname.sendKeys("John");
        // Last name
        WebElement lastname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-45")));
        lastname.sendKeys("Wirk");
        // Email
        WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-48")));
        email.sendKeys("meyihaw240@syinxun.com");
        // Country changer
        WebElement country1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='country-selector input-country-selector has-value lg']")));
        country1.click();
        WebElement country2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='dots-text'])[230]")));
        country2.click();
        //Phone number
        WebElement phone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number *']")));
        phone.sendKeys("07400 123132");
        // Organization
        WebElement organization=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-57")));
        organization.sendKeys("John Wirk Limited");
        // Scroll to dowm
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        // Password
        WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-60")));
        password.sendKeys("Sparkosol123");
        // Confirm Password
        WebElement comfirmpass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-64")));
        comfirmpass.sendKeys("Sparkosol124");
        //Create Account
        WebElement accountcreate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        accountcreate.click();
        Thread.sleep(1500);
        comfirmpass.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        comfirmpass.sendKeys("Sparkosol123");
        accountcreate.click();
    }
}
