package by.fpmi.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRole implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ROLE_ID")
    private long roleID;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERNAME", nullable = false)
    private User user;

    public UserRole() {}

    public UserRole(User user, String role) {
        this.role = role;
        this.user = user;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
