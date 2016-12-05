package by.fpmi.pharmacy.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class User implements Serializable{
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRolesSet = new HashSet<UserRole>(0);

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    public User() {
        this.enabled = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRolesSet() {
        return userRolesSet;
    }

    public void setUserRolesSet(Set<UserRole> userRolesSet) {
        this.userRolesSet = userRolesSet;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
