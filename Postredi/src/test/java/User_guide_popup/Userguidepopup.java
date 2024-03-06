package User_guide_popup;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Userguidepopup {
    WebDriver driver;
    public Userguidepopup(WebDriver driver) throws InterruptedException {
        this.driver=driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Click on Next button on user-guide popup
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[6]")));
        popup.click();
        //Click on previous button
        Thread.sleep(700);
        WebElement popup2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[6]")));
        popup2.click();
        // Cick on Next button
        WebElement popup3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[6]")));
        popup3.click();
        Thread.sleep(500);
        popup3.click();
        //TC No: 17
        //Click on Finish
        WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[7]")));
        finish.click();

    }
    }

