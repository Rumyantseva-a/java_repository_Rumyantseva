package rumyantseva.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import rumyantseva.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().homePage();
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData().withFirstName("Fhygbj").withLastName("Atggfrg")
                //.withGroup("[none]")
                .withEmail("TrueTest@mail.ru"), true);
      }
    }

    @Test
    public void testContactEmails() {
      app.goTo().homePage();
      ContactData contact = app.contact().all1().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

      assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

      //assertThat(contact.getPhone1(), equalTo(cleaned(contactInfoFromEditForm.getPhone1())));
      //assertThat(contact.getPhone2(), equalTo(cleaned(contactInfoFromEditForm.getPhone2())));
      //assertThat(contact.getPhone3(), equalTo(cleaned(contactInfoFromEditForm.getPhone3())));
    }

    private String mergeEmails(ContactData contact) {
      return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
              .stream().filter((s) -> ! s.equals(""))
              .collect(Collectors.joining("\n"));
    }

  //.map(ContactEmailTest::cleaned)

    //public static String cleaned (String email) {
    //  return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    //}


}
