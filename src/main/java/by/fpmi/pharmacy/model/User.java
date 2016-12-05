package by.fpmi.pharmacy.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user", nullable = false)
    private int id;

    @Column(name = "login", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_det")
    private UserDetail idUserDetail;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public UserDetail getIdUserDetail() {
        return idUserDetail;
    }

    public void setIdUserDetail(UserDetail idUserDetail) {
        this.idUserDetail = idUserDetail;
    }
}
