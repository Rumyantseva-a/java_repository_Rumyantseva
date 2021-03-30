package rumyantseva.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @Id
  @Column (name = "id")
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;

  @Column (name = "firstname")
  @Expose
  private String firstname;

  @Column (name = "middlename")
  @Expose
  private String middlename;

  @Column (name = "lastname")
  @Expose
  private String lastname;


  @Transient
  @Expose
  private String nickname;

  @Transient
  @Expose
  private String company;

  @Transient
  @Expose
  private String address1;

  @Column (name = "home")
  @Type(type = "text")
  @Expose
  private String phone1;

  @Column (name = "mobile")
  @Type(type = "text")
  @Expose
  private String phone2;

  @Column (name = "work")
  @Type(type = "text")
  @Expose
  private String phone3;

  @Transient
  @Expose
  private String phone4;

  @Transient
  @Expose
  private String email;

  @Transient
  @Expose
  private String email2;

  @Transient
  @Expose
  private String email3;

  @Transient
  @Expose
  private String group;

  @Transient
  @Expose
  private String address2;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Column (name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File (photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }



  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }


  public ContactData withFirstName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddleName(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickName(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public ContactData withPhone1(String phone1) {
    this.phone1 = phone1;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withPhone3(String phone3) {
    this.phone3 = phone3;
    return this;
  }

  public ContactData withPhone4(String phone4) {
    this.phone4 = phone4;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }



  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress1() {
    return address1;
  }

  public String getPhone1() {
    return phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getPhone3() {
    return phone3;
  }

  public String getPhone4() {
    return phone4;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {
    return group;
  }

  public String getAddress2() {
    return address2;
  }



  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData contactData = (ContactData) o;
    return id == contactData.id && Objects.equals(firstname, contactData.firstname) && Objects.equals(lastname, contactData.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }


}
