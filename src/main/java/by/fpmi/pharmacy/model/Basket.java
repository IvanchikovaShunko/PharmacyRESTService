package by.fpmi.pharmacy.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "basket")
public class Basket implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_basket")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBasket;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "basket_medicine", joinColumns = {
            @JoinColumn(name = "id_basket", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_medicine",
                    nullable = false)})
    private Set<Medicine> medicines;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User idUser;


    public Basket(Set<Medicine> medicines, User idUser, Integer count) {
        this.medicines = medicines;
        this.idUser = idUser;
    }

    public Basket() {
        this.medicines = new HashSet<>();
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

    public Set<Medicine> addMedicine(Medicine medicine) {
        medicines.add(medicine);
        return medicines;
    }

    public Set<Medicine> removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
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

}
