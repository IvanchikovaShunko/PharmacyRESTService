package by.fpmi.pharmacy.model;

import javax.persistence.*;

/**
 * Created by annashunko
 */

@Entity
@Table(name = "user_det")
public class UserDetail {
    @Id
    @Column(name = "id_user_det")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

