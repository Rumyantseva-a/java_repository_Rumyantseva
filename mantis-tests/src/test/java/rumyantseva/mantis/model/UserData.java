/*package rumyantseva.mantis.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "mantis_user_table")

public class UserData {

  @Id
  @Column (name = "id")
  private int id = Integer.MAX_VALUE;

  @Column (name = "username")
  private String username;

  @Column (name = "email")
  @Type(type = "text")
  private String email;

  @Column (name = "password")
  @Type(type = "text")
  private String password;

  public int getId() {
    return id;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public UserData withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserData withEmail(String email) {
    this.email = email;
    return this;
  }

  public UserData withPassword(String password) {
    this.password = password;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }


  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserData userData = (UserData) o;
    return id == userData.id && Objects.equals(username, userData.username) && Objects.equals(email, userData.email) && Objects.equals(password, userData.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password);
  }

}


 */