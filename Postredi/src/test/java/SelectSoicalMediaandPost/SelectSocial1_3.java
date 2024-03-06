package SelectSoicalMediaandPost;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;

public class SelectSocial1_3 {
    public WebDriver driver;


    public SelectSocial1_3(WebDriver driver) throws InterruptedException, IOException {
        this.driver=driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        // Scroll to up
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-500)");

        // Select Social media accounts
        // Click on Post button
        WebElement selectsocial=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-select__selections']")));
        executor.executeScript("arguments[0].click();", selectsocial);


        // Select 1st Social Account
        WebElement clickonsocial=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
        executor.executeScript("arguments[0].click();", clickonsocial);


        // Select 3rd Social media
        WebElement SelectSocial=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[2]")));
        executor.executeScript("arguments[0].click();", SelectSocial);


        // Click on arrow up
        WebElement arrow=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
        executor.executeScript("arguments[0].click();", arrow);



        // Add some caption
        WebElement caption=wait.until(ExpectedConditions.elementToBeClickable(By.id("content")));
        caption.sendKeys("The truth is not a stick with which to beat yourself.");

        // Scroll to End
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        //Click on file uploader button
        WebElement fileuploader=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mediaPrickerWrapper py-8 d-flex justify-center align-center my-5 flex-column']")));
        executor.executeScript("arguments[0].click();", fileuploader);

        String autoItScriptPath = "C:\\Scripts\\SocialSelects1_3.exe";

        Runtime.getRuntime().exec(autoItScriptPath);

        Thread.sleep(5000);
        // Click on POst Now button
        WebElement postbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("postNow")));
       executor.executeScript("arguments[0].click();", postbutton);



    }
}

