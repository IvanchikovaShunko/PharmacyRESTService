package by.fpmi.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subscription")
public class Subscription implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_subscription")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSubscription;

    @Column(name = "subscription")
    private Boolean subscription;

    @Column(name = "subscription_period")
    private String subscriptionPeriod;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "subscription_medicine", joinColumns = {
            @JoinColumn(name = "id_subscription", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_medicine",
                    nullable = false, updatable = false) })
    private Set<Medicine> medicines = new HashSet<Medicine>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User idUser;

    public Subscription(Boolean subscription, String subscriptionPeriod, Set<Medicine> medicines, User idUser) {
        this.subscription = subscription;
        this.subscriptionPeriod = subscriptionPeriod;
        this.medicines = medicines;
        this.idUser = idUser;
    }

    public Subscription() {
    }

    public Integer getIdSubscription() {
        return idSubscription;
    }

    public void setIdSubscription(Integer idSubscription) {
        this.idSubscription = idSubscription;
    }

    public Boolean getSubscription() {
        return subscription;
    }

    public void setSubscription(Boolean subscription) {
        this.subscription = subscription;
    }

    public String getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(String subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
    }

    public Set<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(Set<Medicine> medicines) {
        this.medicines = medicines;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}