package rumyantseva.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import java.util.Comparator;
import java.util.List;
import org.testng.Assert;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactDeletion extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact, false);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();
  }
}
