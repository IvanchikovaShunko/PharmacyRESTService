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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User idUser;

    public Subscription(Boolean subscription, String subscriptionPeriod, Medicine medicine, User idUser) {
        this.subscription = subscription;
        this.subscriptionPeriod = subscriptionPeriod;
        this.medicine = medicine;
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

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}