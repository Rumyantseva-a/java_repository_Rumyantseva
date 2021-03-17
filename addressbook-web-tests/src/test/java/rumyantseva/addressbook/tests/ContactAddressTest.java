package rumyantseva.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg").withGroup("[none]").withPhone1("1110").withPhone2("2220").withPhone3("3330").withEmail("fdgf@mail.ru").withAddress1("Rublevka street"), true);
    }
  }

  @Test
  public void testContactAddresses() {
    app.goTo().homePage();
    ContactData contact = app.contact().all1().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress1(), equalTo(contactInfoFromEditForm.getAddress1()));

  }

  //private String mergeAddresses(ContactData contact) {
  //  return Arrays.asList(contact.getAddress1(), contact.getAddress2())
  //          .stream().filter((s) -> ! s.equals(""))
  //          .collect(Collectors.joining("\n"));
  //}

  //public static String cleaned (String address) {
  //  return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  //}



}
