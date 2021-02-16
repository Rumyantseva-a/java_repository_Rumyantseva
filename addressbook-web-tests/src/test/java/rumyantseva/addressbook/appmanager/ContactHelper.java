package rumyantseva.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillFormContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress1());
    type(By.name("home"), contactData.getPhone1());
    type(By.name("mobile"), contactData.getPhone2());
    type(By.name("work"), contactData.getPhone3());
    type(By.name("fax"), contactData.getPhone4());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getAddress2());
  }



  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void initContactCreation() {
    click(By.name("firstname"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
   // click(By.name("update"));
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contact,boolean creation) {
    initContactCreation();
    fillFormContact(contact,true);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereaContact() {

    return isElementPresent(By.name("selected[]"));
  }
}
