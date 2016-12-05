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

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Medicine> medicines;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User idUser;

    @Column(name = "count")
    private Integer count;

    public Basket(Set<Medicine> medicines, User idUser, Integer count) {
        this.medicines = medicines;
        this.idUser = idUser;
        this.count = count;
    }

    public Basket() {
    }

    public Integer getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> idMedicine) {
        this.medicines = idMedicine;
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
