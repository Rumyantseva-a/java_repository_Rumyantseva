package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();

  }
}
