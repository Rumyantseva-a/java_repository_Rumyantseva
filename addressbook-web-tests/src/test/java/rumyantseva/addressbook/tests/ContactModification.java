package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class ContactModification extends TestBase{

  @Test (enabled = false)
  public void testContactModification() throws Exception {

    if (! app.getContactHelper().isThereaContact()) {app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("HUliana", "Hosifovna", "Haropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru","[none]","MMoscow, Lenina street"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    int lastId = before.get(before.size() - 1).getId();
    app.getContactHelper().initContactModification(lastId);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "HUlianaBasic", "Hosifovna", "Haropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru", null, "MMoscow, Lenina street");
    app.getContactHelper().fillFormContact(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove (before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}
