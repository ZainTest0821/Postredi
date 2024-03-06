import Login.Login;
import SelectSoicalMediaandPost.*;
import Signup.Signup;
import User_guide_popup.Userguidepopup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class Postredi {
    WebDriver driver;


    @BeforeTest
    public void LaunchBrowser() throws InterruptedException {

        WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app-staging.postredi.com/");

    }
    @Test(priority = 1)
          void Signup() throws InterruptedException {

              //Tc No: 05
              //CLick on Signup button
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              //Click
              WebElement signupbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='pointer primary--text ma-0']")));
              signupbutton.click();
              Thread.sleep(1000);
              JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("window.scrollBy(0,300)");
              // TC No: 6
              WebElement createaccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
              createaccount.click();
              PageFactory.initElements(driver, Signup.class);
              //Scroll up
              JavascriptExecutor js2 = (JavascriptExecutor) driver;
              js2.executeScript("window.scrollBy(0,-500)");
              // Click on Cross button
              WebElement cross = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-close theme--light']")));
              cross.click();

          }

          @Test(priority = 2)
          void login() {
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              login.click();
          }

          @Test(priority = 3)
          void errorcheck() {
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              // TC No: 11
              // Enter Email
              WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-22")));
              error.sendKeys("meyihaw240@syinxun.com");
              // Click on Sign
              WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              signin.click();
              // Clear Email field
              error.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              // Enter password
              WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-25")));
              pass.sendKeys("Sparkosol123");
              signin.click();
          }

          @Test(priority = 4)
          void error() throws InterruptedException {
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              // TC No:12
              //Enter valid email
              WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-22")));
              email.sendKeys("meyihaw240@syinxun.com");
              // Enter invalid password
              WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-25")));
              pass.sendKeys("Sparkosol12345");
              // Click on signin
              WebElement sign = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              sign.click();
              Thread.sleep(1500);
              // Enter invalid email
              email.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              WebElement email2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-22")));
              email2.sendKeys("meyhaxxx@syinux.com");
              // Enter valid password
              pass.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              WebElement pass2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-25")));
              pass2.sendKeys("Sparkosol123");
              // Sign in click
              WebElement sign2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              sign2.click();
          }

          @Test(priority = 5)
          void loginwithvalid() throws InterruptedException {
              //TC No: 13
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              Thread.sleep(1500);
              // Enter valid email
              driver.findElement(By.id("input-22")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-22")));
              email.sendKeys("meyihaw240@syinxun.com");
              // Enter pass
              driver.findElement(By.id("input-25")).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
              WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-25")));
              pass.sendKeys("Sparkosol123");
              // Sign in button click
              WebElement sign = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              sign.click();

          }

          @Test(priority = 6)
          void logintoother() throws InterruptedException {
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              //Wait for invisibility
    /*wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
          Thread.sleep(5000);
          //Click on Signout button
        WebElement Signout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[2]")));
          Signout.click();*/
              driver.get("https://app-staging.postredi.com/");
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

          @Test(priority = 7)
          void popup() throws InterruptedException {
              //TC No: 16
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

          @Test(priority = 8)
          void AddSocialPlatform() {
              //TC No: 18
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              WebElement addsocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
              addsocial.click();
          }

          @Test(priority = 9)
          void AddSocialMedia() throws InterruptedException {
              //TC NO:19
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
              String mainWindowHandle = driver.getWindowHandle();

              // Facebook connect
              WebElement facebook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mx-auto text-center pa-4 v-card v-card--link v-sheet theme--light elevation-1 rounded-0']")));
              facebook.click();

              // Switch to popup window like login
              for (String handle : driver.getWindowHandles()) {
                  if (!handle.equals(mainWindowHandle)) {
                      driver.switchTo().window(handle);
                      break;

                  }
              }
              // Enter Email
              WebElement facebook1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='inputtext _55r1 inputtext inputtext']")));
              facebook1.sendKeys("nabeelahmed0294@gmail.com");
              // Enter pass
              WebElement facebook2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='inputtext _55r1 inputtext inputtext'])[2]")));
              facebook2.sendKeys("Sparkosol123");
              // Click on Login button
              WebElement facebook3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='submit']")));
              facebook3.click();
              // Select Page
              WebElement facebook5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[4]")));
              facebook5.click();
              //Scroll to end
              JavascriptExecutor js = (JavascriptExecutor) driver;
              js.executeScript("window.scrollBy(0,500)");

              Thread.sleep(2500);
              // Click on Done
              WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[10]")));
              done.click();

              driver.switchTo().window(mainWindowHandle);

              // Close the verification toast
              WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Vue-Toastification__close-button']")));
              close.click();

              Thread.sleep(1500);

              //LinkedIn connect
              WebElement linkdin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='mx-auto text-center pa-4 v-card v-card--link v-sheet theme--light elevation-1 rounded-0'])[2]")));
              linkdin.click();

              // Switch to popup window like login
              for (String handle : driver.getWindowHandles()) {
                  if (!handle.equals(mainWindowHandle)) {
                      driver.switchTo().window(handle);
                      break;

                  }
              }
              //Enter Email
              WebElement linkemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
              linkemail.sendKeys("postredi123@gmail.com");
              //Enter password
              WebElement linkpass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
              linkpass.sendKeys("a1234567890#");

              // Click on Signin
              WebElement linksign = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn__primary--large from__button--floating']")));
              linksign.click();
              // Switch to main
              driver.switchTo().window(mainWindowHandle);

              //Close the verification toast

              WebElement verificationtaost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Vue-Toastification__close-button']")));
              verificationtaost.click();

              // Instagram
              try {
                  Thread.sleep(3000);
              } catch (InterruptedException e) {
                  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='pa-4 v-card v-sheet theme--light']")));
              }

              // Instagram Connect
              WebElement instagram = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='mx-auto text-center pa-4 v-card v-card--link v-sheet theme--light elevation-1 rounded-0'])[3]")));
              instagram.click();

              // Switch Pop-up window
              for (String handle : driver.getWindowHandles()) {
                  if (!handle.equals(mainWindowHandle)) {
                      driver.switchTo().window(handle);
                      break;

                  }
              }
              Thread.sleep(1000);
              // Click on Login to Facebook
              WebElement instagram2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[11]")));
              instagram2.click();

              // Switch Pop-up window
              for (String handle : driver.getWindowHandles()) {
                  if (!handle.equals(mainWindowHandle)) {
                      driver.switchTo().window(handle);
                      break;

                  }
              }
              //Click on 'Continue'
              WebElement instagram3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'])[2]")));
              instagram3.click();
              Thread.sleep(1000);
              // Click on Connect button forward the profile
              WebElement instagram4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-btn__content']")));
              instagram4.click();


              // Scroll to end
              JavascriptExecutor js2 = (JavascriptExecutor) driver;
              js2.executeScript("window.scrollBy(0,500)");
              Thread.sleep(500);
              // Click on done
              WebElement done1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
              done1.click();
              // Switch to main
              driver.switchTo().window(mainWindowHandle);

              // Close the Add an account dialogbox
              try {
                  Thread.sleep(2000);
              } catch (InterruptedException e) {
                  WebElement closE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[9]")));
                  closE.click();
              }
              // TC No : 20
              //Thread.sleep(5000);

              // Wait for toast invisibility
              WebElement verificationtaost1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Vue-Toastification__close-button']")));
              verificationtaost1.click();
          }

          @Test(priority = 10)
          void Sharepost() throws InterruptedException {
              //Tc No : 21
              Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                      .withTimeout(Duration.ofSeconds(40))
                      .pollingEvery(Duration.ofSeconds(2))
                      .ignoring(NoSuchElementException.class);
               // Close the dialog box
              WebElement dialogbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-close theme--light']")));
              dialogbox.click();
              // click on New Post button
              WebElement newpost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
               newpost.click();

          }
        @Test(priority = 11)
        void Post() throws InterruptedException {
            //TC NO : 22
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='v-btn v-btn--has-bg v-btn--tile theme--light elevation-0 v-size--large primary mr-4']")));
            Thread.sleep(2000);
            // Click on Post button
            WebElement postbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postNow")));
            postbutton.click();
        }

        @Test(priority = 12)
        void Selectsocial() throws InterruptedException {
            //TC NO: 23
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            // Click on dropdown arrow
            WebElement dropdownarrow= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-select__selections']")));
           dropdownarrow.click();
            // Select Social Account
            WebElement clickonsocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
            clickonsocial.click();
            // Wait and click on next checkbox
            Thread.sleep(500);
            driver.findElement(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[2]")).click();
            // Click on next checkbox
            Thread.sleep(500);
            driver.findElement(By.cssSelector("div.v-application.v-application--is-ltr.theme--light:nth-child(2) div.v-menu__content.theme--light.v-menu__content--fixed.menuable__content__active.v-autocomplete__content div.v-list.v-select-list.v-sheet.theme--light.v-list--dense.theme--light div.v-list-item.v-list-item--link.theme--light:nth-child(2) div.v-list-item__action div.v-input.theme--light.v-input--selection-controls.v-input--checkbox div.v-input__control div.v-input__slot div.v-input--selection-controls__input > div.v-input--selection-controls__ripple:nth-child(3)")).click();
            // Click on arrow up
            WebElement arrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
            arrow.click();
        }

        @Test(priority = 13)
                void Generatepost() {
            //TC No:24
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            // Click on Generate Post button on Popup
            WebElement generatepost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("generatePostIdeas")));
            generatepost.click();
        }
        @Test(priority = 14)
        void generatepostelements() throws InterruptedException {
            //TC NO:25 and 26
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            WebElement searchtext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchPosts")));
            searchtext.sendKeys("ABCDEFGHKL");
            //Wait and see 'Apply and 'Clear button appear on upon changes
            Thread.sleep(1000);
            // Clear Search Box
            searchtext.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

            //Mouse over to 'Choose Category' dropdown
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-select__selections'])[2]")));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);

            Thread.sleep(2000);

            // Click on Checkboxes in category
            driver.findElement(By.xpath("//*[@class='v-icon notranslate mdi mdi-checkbox-blank-outline theme--light']")).click();

            //CLick on arrow button
            WebElement arrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
            arrow.click();

            // Click on Subcategory
            //Mouse over to 'Choose Category' dropdown
            WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-select__selections'])[3]")));
            JavascriptExecutor executor3 = (JavascriptExecutor) driver;
            executor3.executeScript("arguments[0].click();", element3);
            // click on checkboxes
            WebElement checkbox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-checkbox-blank-outline theme--light'])[2]")));
            checkbox.click();
            //Next check box
            WebElement checkbox2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item v-list-item--link theme--light'])[3]")));
            checkbox2.click();
            //Next checkbox
            WebElement checkbox3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item__action'])[7]")));
            checkbox3.click();
            //Next checkbox
            WebElement checkbox4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item__action'])[8]")));
            checkbox4.click();
            // Click on arrow to close the dropdown
            WebElement arrow1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-menu-down theme--light'])[3]")));
            arrow1.click();

            //Click on Tags
            WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-select__selections'])[4]")));
            JavascriptExecutor executor4 = (JavascriptExecutor) driver;
            executor4.executeScript("arguments[0].click();", element4);
            //Click on Check box
            WebElement checkboX=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-input--selection-controls__input'])[10]")));
            checkboX.click();
            // Click on next check box
            WebElement checkboX2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-input--selection-controls__input'])[11]")));
            checkboX2.click();

            // Click on arrow to close the dropdown
            WebElement arrow2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
            arrow2.click();
        }
        @Test(priority = 15)
        void clear(){
            //TC NO: 27
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            //Click on Apply
            WebElement apply=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[11]")));
            apply.click();
            //Click on Clear
            WebElement clear=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[12]")));
            clear.click();

            // TC NO 28
            //First close the open popup
            try {
                WebElement cross = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-close theme--light']")));
                cross.click();

            } catch (Exception e) {
                WebElement cross2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cross2);
            }
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            WebElement cross2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[3]")));
            cross2.click();

        }


        @Test(priority = 18)
        void leadurl(){
            // TC No 30
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            // wait for invisibility
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-list v-select-list v-sheet theme--light v-list--dense theme--light']")));
            // Click on 'Lead URL' button
            WebElement lead=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Lead URL') and contains(@class, 'v-btn--outlined') and contains(@class, 'v-size--small') and contains(@data-v-461a5270, '')]\n")));
            lead.click();
        }
        @Test(priority = 19)
        void Scheduleforlater() throws InterruptedException {
            //TC No 31 and 32
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            // Click on 'Schedule for later button'
            WebElement Schedule=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer text-center']")));
            Schedule.click();
            Thread.sleep(500);
            // Close the popup
            WebElement close=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light white--text']")));
            close.click();
        }
        @Test(priority = 20)
        void fileupload() throws IOException, InterruptedException {
            //TC No 33
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
           //Sroll
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");

            //Click on file uploader button
            WebElement fileuploader=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mediaPrickerWrapper py-8 d-flex justify-center align-center my-5 flex-column']")));
            fileuploader.click();
            String autoItScriptPath = "C:\\Users\\Admin\\Desktop\\autoit.exe";

            Runtime.getRuntime().exec(autoItScriptPath);

        }
    @Test(priority = 21)
        void PostNow() throws InterruptedException {
        //(TC No:34)
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Wait for file uplaod
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        // Click on POst Now button
        Thread.sleep(200);
        WebElement postbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[9]")));
      postbutton.click();



      // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
      // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();
        //Close the Share the post popup
        Thread.sleep(2000);
      WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
      cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }
    @Test(priority = 22)
        void SocialSelect1() throws InterruptedException {
            //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();

        PageFactory.initElements(driver, SelectSocial1.class);

    }
    @Test(priority = 23)
    void SocialSelect1_2() throws InterruptedException {
            //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
        // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost1.click();
        //Close the Share the post popup
        Thread.sleep(2000);
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
        cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='v-overlay__scrim']")));

        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();
        PageFactory.initElements(driver, SelectSocial1_2.class);
        Thread.sleep(4000);
    }
    @Test(priority = 24)
        void SocialSelect1_3() throws InterruptedException {
        //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
        // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost1.click();
        //Close the Share the post popup
        Thread.sleep(2000);
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
        cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='v-overlay__scrim']")));

        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();
        //
        PageFactory.initElements(driver, SelectSocial1_3.class);
        Thread.sleep(4000);
    }
    @Test(priority = 25)
        void SocialSelect2() throws InterruptedException {
        //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
        // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost1.click();
        //Close the Share the post popup
        Thread.sleep(2000);
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
        cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("v-overlay__scrim")));
        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();
        //
        PageFactory.initElements(driver, SelectSocial2.class);
        Thread.sleep(4000);
    }
    @Test(priority = 26)
        void SocialSelect2_3() throws InterruptedException {
        //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
        // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost1.click();
        //Close the Share the post popup
        Thread.sleep(2000);
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
        cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='v-overlay__scrim']")));

        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();

        //
        PageFactory.initElements(driver, SelectSocial2_3.class);
    }
    @Test(priority =27)
        void SocialSelect3() throws InterruptedException {
        //TC No 35
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
        // Clear Post Now section to remove the error
        // Click on New Post button
        WebElement newpost1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost1.click();
        //Close the Share the post popup
        Thread.sleep(2000);
        WebElement cross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
        cross.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='v-overlay__scrim']")));

        // Click on New Post button
        WebElement newpost=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
        newpost.click();

        //
        PageFactory.initElements(driver, SelectSocial3.class);
    }
        @Test(priority = 28)
        void SchedulePost() throws InterruptedException {
            //TC No 36 and 37
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            // Click on new Post
         WebElement newpost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer']")));
            newpost.click();
            Thread.sleep(2000);
            // TC No 37
            // Click on 'Schedule for later button'
            WebElement Schedule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer text-center']")));
            Schedule.click();
        }

        @Test(priority = 29)
        void schedulepost() throws InterruptedException {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            //TC No 38 and 39
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            // Check contents and buttons
            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='date']")));
            date.sendKeys("05172024");

            // Change hour
            WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-menu-down theme--light'])[2]")));
            hour.click();
            //Select hour
          WebElement hour2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list-item__title' and text()='11']")));
            hour2.click();

            // Click on minutes dropdown toggle button
            Thread.sleep(1500);
            WebElement minutes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-select__slot'])[3]")));
            minutes.click();
            Thread.sleep(1500);
            WebElement minutes2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='v-list-item__title' and text()='25']")));
            minutes2.click();
            // Select AM and PM randomly

            // Click on AM, PM toggle bar
            WebElement timerange=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-select__selections'])[4]")));
            timerange.click();
            // Locate the options within the dropdown
            WebElement AM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list-item__title' and text()='AM']")));
            WebElement PM = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list-item__title' and text()='PM']")));

            // Generate a random index (0 or 1)
            int randomIndex2 = new Random().nextInt(2);

            // Select the option based on the random index
            if (randomIndex2 == 0) {

                AM.click();
            } else {
              PM.click();
            }

            //Click on done button
            WebElement done=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flex-grow-1 v-btn v-btn--has-bg theme--light elevation-0 v-size--default grey lighten-2']")));
            done.click();
            }
            @Test(priority = 30)
        void cancelschedule() throws InterruptedException, IOException {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(40))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                Thread.sleep(2000);
                //TC No 40
                //Cancel scheduled
                WebElement cancle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light white--text']")));
                cancle.click();

                // TC No 41
                //Click on schedule button
                WebElement Schedule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer text-center']")));
                Schedule.click();

                // change date into past and check error
                WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='date']")));
                date.sendKeys("01111996");

                //Click on done button
                WebElement done=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flex-grow-1 v-btn v-btn--has-bg theme--light elevation-0 v-size--default grey lighten-2']")));
                done.click();

                // Select Social Account
                // Click on dropdown arrow
                WebElement selectsocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-select__selections']")));
                selectsocial.click();
                // Select Social Account
                WebElement clickonsocial = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-input--selection-controls__ripple']")));
                clickonsocial.click();
                // Wait and click on next checkbox
                Thread.sleep(500);
                driver.findElement(By.xpath("(//*[@class='v-input--selection-controls__ripple'])[2]")).click();
                // Click on arrow up
                WebElement arrow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light primary--text']")));
                arrow.click();
                // Add some caption
                WebElement caption=wait.until(ExpectedConditions.elementToBeClickable(By.id("content")));
                caption.sendKeys("The truth is not a stick with which to beat yourself.");
                //Sroll
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");

                //Click on file uploader button
                WebElement fileuploader=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='mediaPrickerWrapper py-8 d-flex justify-center align-center my-5 flex-column']")));
                fileuploader.click();
                String autoItScriptPath = "C:\\Users\\Admin\\Desktop\\autoit.exe";

                Runtime.getRuntime().exec(autoItScriptPath);

                // Click on POst Now button
                WebElement postbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[9]")));
                postbutton.click();
                // Scroll to End
                JavascriptExecutor js2 = (JavascriptExecutor) driver;
                js2.executeScript("window.scrollBy(0,500)");
            }
            @Test(priority = 31)
        void validschedule() throws InterruptedException, IOException {
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(40))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(NoSuchElementException.class);
                //TC No 42

                //Cancel scheduled
                WebElement cancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light white--text']")));
                cancel.click();

                // Click on schedule button
                WebElement Schedule = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ma-0 font-weight-medium pointer text-center']")));
                Schedule.click();

                // Change date and time
                WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='date']")));
                date.sendKeys("07302024");

                //Click on done
                WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='flex-grow-1 v-btn v-btn--has-bg theme--light elevation-0 v-size--default grey lighten-2']")));
                done.click();

                // Click on POst Now button
                WebElement postbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='v-btn__content'])[9]")));
                postbutton.click();
                Thread.sleep(4000);

            }


        @Test(priority = 32)
        void Reportissue() throws InterruptedException {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            //TC No 43 and 44
            WebElement reportanissue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[3]")));
            reportanissue.click();

            //Scroll to Submit
            WebElement submit = driver.findElement(By.xpath("//*[@class='my-4 v-btn v-btn--has-bg theme--light elevation-0 v-size--x-large primary']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submit);
            js.executeScript("arguments[0].click();", submit);

        }

        @Test(priority = 33)
        void reportanissue() throws InterruptedException, IOException {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            //TC No 45 ,46, 48 and 49
            //49 test case will be done by submitting report issue
            //Scroll to type
            WebElement type=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light error--text']")));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",type);
            type.click();

            //Click on Bug from type
            //TC No 46
            WebElement bug=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-list-item__content']")));
            bug.click();
            Thread.sleep(500);
            type.click();

            //Click on Feedback
            WebElement feedback=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item__content'])[2]")));
            feedback.click();
            Thread.sleep(500);
            type.click();

            //Click on Feature Request
            WebElement feature=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-list-item__content'])[3]")));
            feature.click();
            Thread.sleep(500);

            // Enter value in Feedback
            WebElement feedback1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Feedback']")));
            feedback1.sendKeys("Postredi is best social media management Web App");


            // TC No 48
            // Click on file upload
            WebElement media=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mediaPrickerWrapper py-8 d-flex justify-center align-center my-5 flex-column']")));
            media.click();
            String autoItScriptPath = "C:\\Scripts\\SocialSelects1_3.exe";
            Runtime.getRuntime().exec(autoItScriptPath);
            //Click on Submit button
            WebElement submit=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='my-4 v-btn v-btn--has-bg theme--light elevation-0 v-size--x-large primary']")));
            submit.click();

             // Wait for invisibility
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='v-overlay__scrim']")));
       // Close the verification toast
        WebElement verificationtaost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Vue-Toastification__close-button']")));
        verificationtaost.click();
        }
    @Test(priority = 34)
    void lead() throws InterruptedException {
        //TC No 50 and 51
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver,Login.class);
        PageFactory.initElements(driver, Userguidepopup.class);

        //Click on Profile button
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-avatar primary']")));
        profile.click();
        //Click on Leads from dropdown
        WebElement leads = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='route v-list-item v-list-item--dense v-list-item--link theme--light']")));
        leads.click();

        //TC No 51
        // Click on Copy Lead URL
        WebElement copy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("copyLeadUrl")));
        copy.click();

        // Close the confirmation toast because it interrupts within elements clicks
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Vue-Toastification__close-button']")));
        toast.click();

        Thread.sleep(1500);

    }

    @Test(priority = 35)
    void newtab() throws InterruptedException, AWTException, IOException {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2));
        // TC No 52 and 53
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1));
        } else {
            // Handle the case when there is only one window handle
            // For example, you can choose to open a new tab explicitly:
            ((JavascriptExecutor) driver).executeScript("window.open();");
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
        }
        // Get the copied lead URL from the clipboard using JavaScript
        String copiedURL = (String) ((JavascriptExecutor) driver).executeScript("return navigator.clipboard.readText();");
        ((JavascriptExecutor) driver).executeScript("window.location.href = arguments[0];", copiedURL);

//Launch URL in the new tab
//        driver.get("https://app-staging.postredi.com/ooo");

        // TC No 53
        WebElement send = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        send.click();
        Thread.sleep(1000);
    }


    @Test(priority = 36)
    void enterdetails() throws InterruptedException {
        // TC No 54,55,56,57 and 58
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Get window handles to close it properly becuase next test case will not interact with refresh button because code think this is still close window

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }
        // First name
        WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name")));
        firstname.sendKeys("James");

        // Last name
        WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name")));
        lastname.sendKeys(" Parker");

        //Email
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("ilyaz@mac.com");

        //Phone
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Phone")));
        phone.sendKeys("E.");

        // TC NO 57 -Meeting date error check
        WebElement meeting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("meeting_date")));
        meeting.sendKeys("02022021");

        // Enter message
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        message.sendKeys("Great job! The service was fast, efficient, and the staff was friendly. Highly recommended!");

        // Click on Send button
        WebElement send = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        send.click();
        Thread.sleep(900);

        // Clear and Change the phone number
        phone.clear();
        phone.sendKeys("1234567890");
        Thread.sleep(900);

        // Change the date
        meeting.sendKeys(Keys.ARROW_LEFT);
        meeting.sendKeys(Keys.DELETE);
        meeting.sendKeys(Keys.ARROW_LEFT);
        meeting.sendKeys(Keys.DELETE);
        meeting.sendKeys(Keys.ARROW_LEFT);
        meeting.sendKeys(Keys.DELETE);
        meeting.sendKeys("02122024");
        // TC NO 58
        send.click();
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window((String) windowHandles.toArray()[0]);

    }

    @Test(priority = 37)
    void newleadcheck() throws InterruptedException {
        // TC No 59 ad 60
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // Click on All from Rows per table dropdown
        //Click on dropdown arrow
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light']")));
        dropdown.click();
        Thread.sleep(500);
        // Select All
        driver.findElement(By.xpath("(//*[@class='v-list-item__content'])[10]")).click();

        // Click on refresh button
        WebElement refreshbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-refresh theme--light']")));
        refreshbutton.click();
        Thread.sleep(500);

        // Click on table data to scroll in table otherwise a full webPage will scroll
        WebElement tabeldata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-data-table__wrapper']")));

        // Scroll to the end of the table container
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy({ top: arguments[0].scrollHeight, behavior: 'smooth' });", tabeldata);

    }

    @Test(priority = 38)
    void searchbutton() throws InterruptedException {
        //TC No 62 and 63
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
        search.sendKeys("James");
        // Click on table data to scroll in table
        WebElement tabeldata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-data-table__wrapper']")));

        // Scroll to the end of the table container
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy({ top: arguments[0].scrollHeight, behavior: 'smooth' });", tabeldata);

        Thread.sleep(2000);
        //Clear and enter new details
        search.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        Thread.sleep(500);
        search.sendKeys("ABCD");

        // TC NO 63- refresh button check
        WebElement refreshbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-refresh theme--light']")));
        refreshbutton.click();
        //Clear Search box
        search.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

    }

    @Test(priority = 39)
    void rowsperpage() throws InterruptedException {
        //TC NO 64
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Click on dropdown arrow
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-menu-down theme--light']")));
        dropdown.click();
        Thread.sleep(500);
        // Select 5
        driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='5']")).click();
        // Select 10
        Thread.sleep(1000);
        dropdown.click();
        driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='10']")).click();
        // Click on table data to scroll in table
        WebElement tabeldata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-data-table__wrapper']")));
        // Scroll to the end of the table container
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy({ top: arguments[0].scrollHeight, behavior: 'smooth' });", tabeldata);
        Thread.sleep(900);

        //Select 15
        Thread.sleep(1000);
        dropdown.click();
        driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='15']")).click();
        js.executeScript("arguments[0].scrollBy({ top: arguments[0].scrollHeight, behavior: 'smooth' });", tabeldata);

        // Select All
        Thread.sleep(1000);
        dropdown.click();
        driver.findElement(By.xpath("//div[@class='v-list-item__title' and text()='All']")).click();
        js.executeScript("arguments[0].scrollBy({ top: arguments[0].scrollHeight, behavior: 'smooth' });", tabeldata);

    }

    @Test(priority = 40)
    void changeleadurl() throws InterruptedException {
        //TC NO 65,66,67,68 and 69
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        //Click on Change lead URL
        WebElement leadurl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[2]")));
        leadurl.click();

        //TC NO 66-  Clear text field on dialog box to see error
        WebElement clearttext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Lead URL']")));
        clearttext.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

        //TC No 67 -- Special character check
        clearttext.sendKeys("//!@#$%^&*");
        Thread.sleep(1000);
        clearttext.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        Thread.sleep(500);

        // TC No 69- check for cross button
        WebElement crossbuttonclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='v-icon notranslate mdi mdi-close theme--light']")));
        crossbuttonclick.click();
        Thread.sleep(500);
        // Change the lead URL text
        leadurl.click();
        Thread.sleep(800);
        // Change the text and check for verification toast
        clearttext.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        clearttext.sendKeys("Parker");
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitBtn")));
        submit.click();
    }

    @Test(priority = 41)
    void Customizedlead() throws InterruptedException {
        //TC No 70
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Click on Customized lead URL
        WebElement customized = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[3]")));
        customized.click();
        Thread.sleep(1500);

    }

    @Test(priority = 42)
    void titleandsubtitle() throws InterruptedException {
        //TC No 71 and 72
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        // Empty title and Subtitle
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']")));
        title.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        // Empty subtitle
        Thread.sleep(600);
        WebElement subtitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@type='text'])[2]")));
        subtitle.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        // Click on save button
        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='px-10 mr-2 mb-2 v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']")));
        save.click();

        //Enter details in Title text box
        Thread.sleep(600);
        title.sendKeys("Feedback");

        save.click();

        //Enter details in subtitle
        Thread.sleep(500);
        subtitle.sendKeys("Sol");

        save.click();

        // TC No 72
        Thread.sleep(500);
        // Change the title
        title.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        Thread.sleep(500);
        title.sendKeys("Webpage");

        save.click();

        // Change the subtitle
        Thread.sleep(500);
        subtitle.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        subtitle.sendKeys("Feedback");

        save.click();
    }

    @Test(priority = 43)
    void titlevalidation() throws InterruptedException, IOException {
        // TC No 73,74,75 and 76
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

            // Click on view
            WebElement view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='px-2 mr-2 mb-2 v-btn v-btn--outlined theme--light v-size--default primary--text']")));
            view.click();
            Thread.sleep(3500);

        // Get the window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Close the second tab (assuming it's the last tab opened)
        String lastWindowHandle = driver.getWindowHandle();
        for (String handle : windowHandles) {
            if (!handle.equals(lastWindowHandle)) {
                driver.switchTo().window(handle);
                // Perform actions on the second tab if needed
                driver.close();
                break;
            }
        }

        // Switch back to the first tab (assuming it's the remaining tab)
        if (windowHandles.contains(lastWindowHandle)) {
            driver.switchTo().window(lastWindowHandle);
            // Perform actions on the first tab if needed
        } else {
            System.out.println("The target window was closed.");
        }

            // TC No 74- remove background button for  error test
            WebElement removeimage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='icon']")));
            removeimage.click();
            // Click on save button
            WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='px-10 mr-2 mb-2 v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']")));
            save.click();

            // TC No 75-Upload new wallpaper
            WebElement upload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='drop mb-4 invalid']")));
            upload.click();

            String autoItScriptPath = "C:\\Scripts\\background.exe";

            Runtime.getRuntime().exec(autoItScriptPath);

            Thread.sleep(3000);
            // Click on save button after uploading new file
        executor.executeScript("arguments[0].click();", save);
            Thread.sleep(2000);

            // TC No 76


            view.click();
        Thread.sleep(3500);

        // Get the window handles
        Set<String> windowHandles1 = driver.getWindowHandles();

        // Close the second tab (assuming it's the last tab opened)
        String lastWindowHandle1 = driver.getWindowHandle();
        for (String handle : windowHandles1) {
            if (!handle.equals(lastWindowHandle1)) {
                driver.switchTo().window(handle);
                // Perform actions on the second tab if needed
                driver.close();
                break;
            }
        }

        // Switch back to the first tab (assuming it's the remaining tab)
        if (windowHandles.contains(lastWindowHandle)) {
            driver.switchTo().window(lastWindowHandle);
            // Perform actions on the first tab if needed
        } else {
            System.out.println("The target window was closed.");
        }

        }
        @Test(priority = 44)
    void organizationdetails() throws InterruptedException {
        // TC NO 78,79,80 and 81
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            // TC No 79- Click on Edit Organizational details
            WebElement organizational=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='px-2 mr-2 mb-2 v-btn v-btn--outlined theme--light v-size--default primary--text'])[2]")));
            organizational.click();
            // TC NO 80- Empty all the text fields

            // First name
            WebElement firstname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='First Name']")));
           firstname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

           //Last name
            Thread.sleep(500);
            WebElement lastname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Last Name']")));
            lastname.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

            // Phone
            Thread.sleep(500);
            WebElement phone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Phone number *']")));
            phone.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);

            // Organization Name
            Thread.sleep(500);
            WebElement organizationname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Enter your organization name']")));
            organizationname.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);

            // Organizational Address
            Thread.sleep(500);
            WebElement organizationaladdress=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Enter your organization address']")));
            organizationaladdress.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);

            // Organizational Email
            Thread.sleep(500);
            WebElement organizationalemail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Enter your organization email']")));
            organizationalemail.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);

            //Click on Submit button
            WebElement submit=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='mb-6 v-btn v-btn--has-bg theme--light elevation-0 v-size--x-large primary'])[2]")));
            submit.click();

            // TC No 80-Edit or update
            // First name update
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstname);
            firstname.sendKeys("Alfine");

            // Last name update
            Thread.sleep(500);
            lastname.sendKeys("Malik");

            // Phone number update
            Thread.sleep(500);
            phone.sendKeys("3145468971");

            // Organzation name update
            Thread.sleep(500);
            organizationname.sendKeys("Top development ");

            // Organizational address
            Thread.sleep(500);
            organizationaladdress.sendKeys("51635 Andre Forge");

            // Organizational email update
            Thread.sleep(500);
            organizationalemail.sendKeys("cilecet630@goflipa.com");

            // CLick on submit
            Thread.sleep(500);
            submit.click();

            //TC NO 81- Close the popup by clicking on cross button
            Thread.sleep(500);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-500)");

            // Click popup cross button
            WebElement crossbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-icon notranslate mdi mdi-close theme--light'])[2]")));
            // Move to cross button and click on it
            Thread.sleep(600);
            crossbutton.click();


        }
        @Test(priority = 45)
    void templates() throws InterruptedException {
        // TC NO 82 and 83
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(40))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            JavascriptExecutor executor = (JavascriptExecutor) driver;

            // Click on temp 1
            Thread.sleep(500);
            WebElement temp1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[4]")));
            Actions actions = new Actions(driver);
            actions.moveToElement(temp1).perform();
            temp1.click();
            // Click on temp 2
            Thread.sleep(500);
            WebElement temp2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[5]")));
            temp2.click();

            // Click on temp 3
            Thread.sleep(500);
            WebElement temp3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[6]")));
            Actions actions1 = new Actions(driver);
            actions1.moveToElement(temp3).perform();
            temp3.click();

            // Click on temp 4
            Thread.sleep(500);
            WebElement temp4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[6]")));
            temp4.click();

            // Click on temp5
            WebElement temp5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[7]")));
            Actions actions2 = new Actions(driver);
            actions2.moveToElement(temp5).perform();
            temp5.click();

            // Click on temp6
            WebElement temp6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='v-btn__content'])[7]")));
            temp6.click();
            Thread.sleep(500);

            // Choose which you want
            Actions actions3 = new Actions(driver);
            actions3.moveToElement(temp3).perform();
            temp3.click();

            // Click on view to check
            WebElement view = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='px-2 mr-2 mb-2 v-btn v-btn--outlined theme--light v-size--default primary--text']")));
            view.click();
            Thread.sleep(3000);
            // Get the window handles
            Set<String> windowHandles = driver.getWindowHandles();

            // Close the second tab (assuming it's the last tab opened)
            String lastWindowHandle = driver.getWindowHandle();
            for (String handle : windowHandles) {
                if (!handle.equals(lastWindowHandle)) {
                    driver.switchTo().window(handle);
                    // Perform actions on the second tab if needed
                    driver.close();
                    break;
                }
            }

            // Switch back to the first tab (assuming it's the remaining tab)
            if (windowHandles.contains(lastWindowHandle)) {
                driver.switchTo().window(lastWindowHandle);
                // Perform actions on the first tab if needed
            } else {
                System.out.println("The target window was closed.");
            }

        }
    }




