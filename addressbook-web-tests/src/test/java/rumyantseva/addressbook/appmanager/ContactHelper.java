package rumyantseva.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;
import com.google.common.collect.ForwardingSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    attach(By.name("photo"), contactData.getPhoto());


    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getAddress2());
  }



  //public void selectContact() {
  //  click(By.name("selected[]"));
  //}

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();;
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initContactCreation() {
    click(By.name("firstname"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }
  public void initContactModification(int id) {
    click(By.xpath("//a[@href='edit.php?id="+ id +"']"));
  }

  public void submitContactModification() {
   // click(By.name("update"));
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillFormContact(contact, creation);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact, boolean creation) {
    selectContactById(contact.getId());
    initContactModification();
    fillFormContact(contact, creation);
    submitContactModification();
    //contactCache = null;
    returnToHomePage();

  }


  public void delete(ContactData contact, boolean creation) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereaContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  //public List<ContactData> getContactList() {
  //  List<ContactData> contacts = new ArrayList<ContactData>();
  //  List<WebElement> elements = wd.findElements (By.cssSelector("tr[name=entry]"));
  //  for (WebElement element : elements) {
  //    List<WebElement> cells = element.findElements(By.tagName("td"));

 //     String firstname = cells.get(2).getText();
 //     String lastname = cells.get(1).getText();
 //     int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
 //     ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null, null, null, null, null, null, null);
 //     contacts.add(contact);
 //   }
  //  return contacts;
  //}

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements (By.cssSelector("tr[name=entry]"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
  return new Contacts(contactCache);
  }

  public Set<ContactData> all1() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements (By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String address = cells.get(3).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress1(address));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();

    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withPhone1(home).withPhone2(mobile).withPhone3(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withAddress1(address);

  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s'", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[href=edit.php?id=%s]", id))).click();

  }
}
