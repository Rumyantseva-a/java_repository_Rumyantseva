package rumyantseva.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactPhoneTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg").withGroup("[none]").withPhone1("1110").withPhone2("2220").withPhone3("3330").withPhone4("4440"), true);
    }
  }

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all1().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    //assertThat(contact.getPhone1(), equalTo(cleaned(contactInfoFromEditForm.getPhone1())));
    //assertThat(contact.getPhone2(), equalTo(cleaned(contactInfoFromEditForm.getPhone2())));
    //assertThat(contact.getPhone3(), equalTo(cleaned(contactInfoFromEditForm.getPhone3())));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getPhone1(), contact.getPhone2(), contact.getPhone3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
