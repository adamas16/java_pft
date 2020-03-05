package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

//    public void alertAccept() {
//        driver.switchTo().alert().accept();
//    }

    public void selectByVisibilityTextMethod(By locator, String text) {
        click(locator);
        select(locator, text);
        click(locator);
    }

    public void select(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)){
                clear(locator);
                sendText(locator, text);
            }
        }
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public void sendText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void getAttrib(By locator, String value){

    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
