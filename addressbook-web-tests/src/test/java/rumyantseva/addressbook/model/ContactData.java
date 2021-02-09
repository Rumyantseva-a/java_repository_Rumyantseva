package rumyantseva.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address1;
  private final String phone1;
  private final String phone2;
  private final String phone3;
  private final String phone4;
  private final String email;
  private final String birthday;
  private final String birthmonth;
  private final String birthyear;
  //private final String group;
  private final String address2;
  private final String home;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String address1, String phone1, String phone2, String phone3, String phone4, String email, String birthday, String birthmonth, String birthyear, String group, String address2, String home) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address1 = address1;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.phone3 = phone3;
    this.phone4 = phone4;
    this.email = email;
    this.birthday = birthday;
    this.birthmonth = birthmonth;
    this.birthyear = birthyear;
    //this.group = group;
    this.address2 = address2;
    this.home = home;
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

  public String getBirthday() {
    return birthday;
  }

  public String getBirthmonth() {
    return birthmonth;
  }

  public String getBirthyear() {
    return birthyear;
  }

  //public String getGroup() {
    //return group;
  //}

  public String getAddress2() {
    return address2;
  }

  public String getHome() {
    return home;
  }
}
