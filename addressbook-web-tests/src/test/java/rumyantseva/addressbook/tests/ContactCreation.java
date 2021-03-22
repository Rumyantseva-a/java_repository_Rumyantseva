package rumyantseva.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreation extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    File photo = new File("src/test/resources/IMG_1011in.jpg");
    ContactData contact = new ContactData().withLastName("Daropaeva").withFirstName("Aliana").withGroup("[none]").withPhoto(photo);
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

  //@Test --для проверки абсолютного и относительного путей к файлу
  //public void testCurrentDir() {
  //  File currentDir = new File(".");
  //  System.out.println(currentDir.getAbsolutePath());
  //  File photo = new File("src/test/resources/IMG_1011in.jpg");
  //  System.out.println(photo.getAbsolutePath());
  //  System.out.println(photo.exists());
  //}


}


