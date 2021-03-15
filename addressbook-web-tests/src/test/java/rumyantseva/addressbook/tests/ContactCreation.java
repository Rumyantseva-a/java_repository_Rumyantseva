package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreation extends TestBase{


  @Test (enabled = false)
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNewPage();
    ContactData contact = new ContactData ("Duliana", "Iosifovna", "Daropaeva", "uinikolaeva", "Bank3", "Moscow, Rublevka street", "1234567", "1234567", "1234567", "1234567", "nikolaeva@mmail.ru", "[none]","Moscow, Lenina street");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}
