package rumyantseva.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.*;
import rumyantseva.addressbook.model.ContactData;
import rumyantseva.addressbook.model.Contacts;
import rumyantseva.addressbook.model.GroupData;
import rumyantseva.addressbook.model.Groups;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreation extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType()); //то же что List<ContactData>.class
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }


  @Test (dataProvider = "validContactsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    //File photo = new File("src/test/resources/IMG_1011in.jpg");
    //ContactData contact = new ContactData().withLastName("Daropaeva").withFirstName("Aliana").withGroup("[none]").withPhoto(photo);
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


