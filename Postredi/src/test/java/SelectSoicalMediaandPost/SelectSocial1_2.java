package SelectSoicalMediaandPost;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;

public class SelectSocial1_2 {
    public WebDriver driver;


    public SelectSocial1_2(WebDriver driver) throws InterruptedException, IOException {
        this.driver = driver;
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        // Scroll to up
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-500)");

        // Select Social media accounts
        // Click on Dropdown arrow of social media
        WebElement selectsocial=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-select__selections']")));
        executor.executeScript("arguments[0].click();", selectsocial);

        // Select 1st Social Account
        WebElement clickonsocial = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
        executor.executeScript("arguments[0].click();", clickonsocial);

        Thread.sleep(900);
        //Select 2nd Social Account
        WebElement SocialMedia2=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.v-application.v-application--is-ltr.theme--light:nth-child(2) div.v-menu__content.theme--light.v-menu__content--fixed.menuable__content__active.v-autocomplete__content div.v-list.v-select-list.v-sheet.theme--light.v-list--dense.theme--light div.v-list-item.v-list-item--link.theme--light:nth-child(2) div.v-list-item__action div.v-input.theme--light.v-input--selection-controls.v-input--checkbox div.v-input__control div.v-input__slot div.v-input--selection-controls__input > div.v-input--selection-controls__ripple:nth-child(3)")));
        executor.executeScript("arguments[0].click();", SocialMedia2);

        // Click on arrow up
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
        executor.executeScript("arguments[0].click();", arrow);


        // Add some caption
        WebElement caption=wait.until(ExpectedConditions.elementToBeClickable(By.id("content")));
        caption.sendKeys("We need to be willing to accept our feelings around an event in order to fully gain the benefits, which are available from it.");

        // Scroll to End
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        //Click on file uploader button
        WebElement fileuploader=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mediaPrickerWrapper py-8 d-flex justify-center align-center my-5 flex-column']")));
        executor.executeScript("arguments[0].click();", fileuploader);
        String autoItScriptPath = "C:\\Scripts\\SocialSelects1_2.exe";

        Runtime.getRuntime().exec(autoItScriptPath);

        // Click on POst Now button
        WebElement postbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("postNow")));
        executor.executeScript("arguments[0].click();", postbutton);
        Thread.sleep(5000);
        postbutton.click();


    }
}
