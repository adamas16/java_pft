package appmanager;

import addressbook_tests_parametrs.ContactDataParametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Set;
import java.util.HashSet;


import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    private NavigationHelper goTo = new NavigationHelper(driver);

    public void submitContactDeletion(){
        click(By.xpath("//input[@value=\"Delete\"]"));
        isAlertPresent();
    }

    public void fillContactForm(ContactDataParametrs contactDataParametrs, boolean creation) {
        type(By.name("firstname"), contactDataParametrs.getName());
        type(By.name("lastname"), contactDataParametrs.getLastName());
        type(By.name("nickname"), contactDataParametrs.getNickName());
        type(By.name("address"), contactDataParametrs.getCountry());
        type(By.name("mobile"), contactDataParametrs.getPhone());
        if (creation){
            selectByVisibilityTextMethod(By.name("new_group"),"test1");
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void selectContactsById(int id)  {
        driver.findElement(By.cssSelector("input[value='"+id+"'")).click();
    }

    public void selectContactModification(int id) {
        driver.findElement(By.xpath("//a[@href=\"edit.php?id="+id+"\"]")).click();
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

    public void create(ContactDataParametrs contactDataParametrs, boolean creation) {
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

    public List<ContactDataParametrs> list() {
        List<ContactDataParametrs> contacts= new ArrayList<ContactDataParametrs>();
        List<WebElement> elements= driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells= element.findElements(By.xpath("td"));
            String lastname =cells.get(1).getText();
            String name =cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDataParametrs().withId(id).withName(name).withLastName(lastname));
        }
        return contacts;
//        List<ContactDataParametrs> contacts = new ArrayList<ContactDataParametrs>();
//        List<WebElement> elements = driver.findElements(By.name("entry"));
//        for (WebElement element : elements) {
//            List<WebElement> contactEntryList = element.findElements(By.cssSelector("td"));
//            WebElement nameCell = contactEntryList.get(2);
//            String name = nameCell.getText();
//            WebElement lastnameCell = contactEntryList.get(1);
//            String lastname = lastnameCell.getText();
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
//            ContactDataParametrs contact = new ContactDataParametrs(name, "Sergeevich", lastname,null, null, null, null, null,null, null, null);
//            contacts.add(contact);
//        }
//        return contacts;
    }

    public void modify(ContactDataParametrs contact) {
//      нажатие на кнопку редактировать
        selectContactsById(contact.getId());

        selectContactModification(contact.getId());

//      заполнение формы
        fillContactForm(contact,false);

//      нажать на обновить контакт
        updateButton();

//      возврат на главную страницу
        goTo.mainPage();
    }

    public void delete(ContactDataParametrs contact) throws Exception{
        selectContactsById(contact.getId());
        submitContactDeletion();
        isAlertPresent();
//        goTo.mainPage();
//        Thread.sleep( 10000);
//        driver.navigate().refresh();
    }

    public void createContact(ContactDataParametrs contact) {
//      добавляем контакт
        initContactCreation();

//      заполнение формы
        fillContactForm(contact, true);

//      нажать на подтверждение создание контакта
        submitContactCreation();

//      возврат на главную страницу
        goTo.mainPage();
    }

    public Set<ContactDataParametrs> all() {
        Set<ContactDataParametrs> contacts = new HashSet<ContactDataParametrs>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.xpath("td"));
            String lastname = cells.get(1).getText();
            String name = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactDataParametrs().withId(id).withName(name).withLastName(lastname));
        }
        return contacts;
    }

}
