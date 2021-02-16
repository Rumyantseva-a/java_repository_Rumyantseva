package rumyantseva.addressbook.tests;


import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;

public class ContactCreation extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().createContact(new ContactData("Duliana", "Iosifovna", "Daropaeva", "uinikolaeva", "Bank3", "Moscow, Rublevka street", "1234567", "1234567", "1234567", "1234567", "nikolaeva@mmail.ru", null,"Moscow, Lenina street"), true);

  }


}
