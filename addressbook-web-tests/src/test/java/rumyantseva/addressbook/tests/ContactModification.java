package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;

public class ContactModification extends TestBase{

  @Test
  public void testContactModification() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData("HUliana", "Hosifovna", "Haropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru", null,"MMoscow, Lenina street"), true);
    }
    //app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillFormContact(new ContactData("DUliana", "Dosifovna", "Daropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru", null,"MMoscow, Lenina street"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
