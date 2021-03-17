package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreation extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    ContactData contact = new ContactData().withLastName("Daropaeva").withFirstName("Aliana").withGroup("[none]");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

  }

  //@Test
  //public void testBadContactCreation() throws Exception {
  //  Contacts before = app.contact().all();
  //  app.goTo().addNewPage();
  //  ContactData contact = new ContactData().withLastName("Daropaeva'").withFirstName("Aliana'").withGroup("[none']");
  //  app.contact().create(contact, true);
  //  assertThat(app.contact().count(), equalTo(before.size()));
  //  Contacts after = app.contact().all();
  //  assertThat(after, equalTo(before));
  //  }


}
