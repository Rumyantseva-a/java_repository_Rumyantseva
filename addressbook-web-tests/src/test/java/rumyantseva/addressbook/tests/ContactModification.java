package rumyantseva.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;


public class ContactModification extends TestBase{


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg")
              //.withGroup("[none]")
              , true);
    }
  }

  @Test
  public void testContactModification() throws Exception {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstName("Vladsss").withLastName("Jhhgfghgfrg").withMiddleName("Jhhgfghgfrg")
            .withPhone1("123").withPhone2("123").withPhone3("123");
    app.goTo().homePage();
    app.contact().modify(contact, false);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUI();
  }
}






