package rumyantseva.addressbook.tests;

import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;
import org.testng.Assert;

public class ContactDeletion extends TestBase{

  @Test
  public void testContactDeletion() throws Exception {

    if (! app.getContactHelper().isThereaContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("HUliana", "Hosifovna", "Haropaeva", "Muinikolaeva", "MBank3", "MMoscow, Rublevka street", "01234567", "01234567", "01234567", "01234567", "Mnikolaeva@mmail.ru","[none]","MMoscow, Lenina street"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    //int lastId = before.get(before.size() - 1).getId();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();

    Thread.sleep(5000);//время на автоматический переход наглавную страницу
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove (before.size() - 1);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    //int a = 1;


  }
}
