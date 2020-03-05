package appmanager;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactDeletion(){
        click(By.xpath("//input[@value=\"Delete\"]"));
        isAlertPresent();
    }

    public void fillContactForm(ContactDataParametrs contactDataParametrs) {
        type(By.name("firstname"), contactDataParametrs.getName());
        type(By.name("middlename"),contactDataParametrs.getPatronymic());
        type(By.name("lastname"), contactDataParametrs.getLastName());
        type(By.name("nickname"), contactDataParametrs.getNickName());

        type(By.name("title"), contactDataParametrs.getTitle());
        type(By.name("address"), contactDataParametrs.getCountry());
        type(By.name("mobile"), contactDataParametrs.getPhone());

        type(By.name("email"), contactDataParametrs.getMail());

        selectByVisibilityTextMethod(By.name("bday"), contactDataParametrs.getbDay());
        selectByVisibilityTextMethod(By.name("bmonth"), contactDataParametrs.getbMonth());
        type(By.name("byear"), contactDataParametrs.getbYear());
        click(By.name("new_group"));
    }

    public void selectContact(){
        click(By.xpath("(//input[@name=\"selected[]\"])[1]"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

}