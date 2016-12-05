package by.fpmi.pharmacy.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @Column(name = "id_basket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBasket;

    @OneToMany(mappedBy = "idMedicine")
    private Set<Medicine> idMedicine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User idUser;

    @Column(name = "count")
    private Integer count;

    public Integer getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public Set<Medicine> getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Set<Medicine> idMedicine) {
        this.idMedicine = idMedicine;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
