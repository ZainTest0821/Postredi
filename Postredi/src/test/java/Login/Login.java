package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Login {
   public WebDriver driver;

    public Login(WebDriver driver){
        this.driver=driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Enter email
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-22")));
        email.sendKeys("nabeelahmed0294@gmail.com");
        // Enter pass
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-25")));
        pass.sendKeys("12345678A");
        // Signin  button
        WebElement sign = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
        sign.click();
    }

    }

