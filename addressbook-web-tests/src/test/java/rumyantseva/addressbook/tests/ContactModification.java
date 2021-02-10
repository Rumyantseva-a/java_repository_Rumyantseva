package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;

public class ContactModification extends TestBase{

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    //app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillFormContact(new ContactData("MUliana", "MIosifovna", "QVoropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru", "MMoscow, Lenina street"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
