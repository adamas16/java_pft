package appmanager;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactDeletion(){
        click(By.xpath("//input[@value=\"Delete\"]"));
        isAlertPresent();
    }

    public void fillContactForm(ContactDataParametrs contactDataParametrs, boolean creation) {
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
        if (creation){
            selectByVisibilityTextMethod(By.name("new_group"),"test1");
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void selectContact(int index){
        driver.findElements(By.xpath("//input[@name=\"selected[]\"]")).get(index).click();
    }

    public void initContactEdition(int index){
        driver.findElements(By.xpath("//img[@title=\"Edit\"]")).get(index).click();
        System.out.println("Номер контакта = " + (index + 1));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void updateButton() {
        click(By.xpath("//input[@name=\"update\"]"));
    }

    public void createContact(ContactDataParametrs contactDataParametrs, boolean creation) {
        initContactCreation();
        fillContactForm(contactDataParametrs,creation);
        submitContactCreation();
        gotoHomePage();
        refresh();
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@title=\"Details\"]"));
    }

    public List<ContactDataParametrs> getContactList() {
        List<ContactDataParametrs> contacts = new ArrayList<ContactDataParametrs>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> contactEntryList = element.findElements(By.cssSelector("td"));
            WebElement nameCell = contactEntryList.get(2);
            String name = nameCell.getText();
            WebElement lastnameCell = contactEntryList.get(1);
            String lastname = lastnameCell.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactDataParametrs contact = new ContactDataParametrs(name, "Sergeevich", lastname,null, null, null, null, null,null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
