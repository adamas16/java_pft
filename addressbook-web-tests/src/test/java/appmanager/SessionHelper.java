package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void autoLogin(String user, String password) {
        driver.get("http://localhost/addressbook/");
        type(By.name("user"),user);
        type(By.name("pass"),password);
        click(By.xpath("//input[@value='Login']"));
    }

    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

}

