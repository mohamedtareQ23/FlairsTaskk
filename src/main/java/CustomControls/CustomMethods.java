package CustomControls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.time.Duration;

public class CustomMethods {
    public static void selectFromDropDownByValue(WebDriver driver , String value , By locator){

        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }
    public static void clickOnElement(WebDriver driver , By locator){
        driver.findElement(locator).click();
    }
    public static void EnterText(WebDriver driver , By locator , String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public static void WaitUntilElementIsNotVisible(WebDriver driver , By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
    }
    public static void waitforseconds(int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(seconds));
    }




}
