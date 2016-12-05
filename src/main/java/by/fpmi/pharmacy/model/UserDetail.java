package by.fpmi.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by annashunko
 */

@Entity
@Table(name = "user_det")
public class UserDetail implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user_det")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUserDet;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "about")
    private String about;

    @Column(name = "home_address")
    private String homeAddress;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    public UserDetail(String name, Integer age, String gender, String about, String homeAddress, String email, String telephone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.about = about;
        this.homeAddress = homeAddress;
        this.email = email;
        this.telephone = telephone;
    }

    public UserDetail() {
    }

    public Integer getIdUserDet() {
        return idUserDet;
    }

    public void setIdUserDet(Integer idUserDet) {
        this.idUserDet = idUserDet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

