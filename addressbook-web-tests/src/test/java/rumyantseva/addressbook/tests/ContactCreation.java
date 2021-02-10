package rumyantseva.addressbook.tests;


import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;

public class ContactCreation extends TestBase{


  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().gotoAddNewPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillFormContact(new ContactData("Uliana", "Iosifovna", "Voropaeva", "uinikolaeva", "Bank3", "Moscow, Rublevka street", "1234567", "1234567", "1234567", "1234567", "nikolaeva@mmail.ru", "Moscow, Lenina street"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
