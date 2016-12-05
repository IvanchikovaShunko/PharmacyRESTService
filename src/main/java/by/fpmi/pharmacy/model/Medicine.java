package by.fpmi.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "id_medicine")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicine;

    @Column(name = "name_medicine")
    private String nameMedicine;

    @Column(name = "about_medicine")
    private String aboutMedicine;

    @Column(name = "gram_in_one")
    private Double gramInOne;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "consist")
    private String consist;

    @Column(name = "expiration_date")
    private Date expiration_date;

    @Column(name = "state")
    private String state;

    @Column(name = "dosing")
    private String dosing;

    @Column(name = "contradictions")
    private String contradictions;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicines")
    private Set<Subscription> subscriptions = new HashSet<Subscription>();

    public Integer getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Integer idMedicine) {
        this.idMedicine = idMedicine;
    }

    public String getNameMedicine() {
        return nameMedicine;
    }

    public void setNameMedicine(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }

    public String getAboutMedicine() {
        return aboutMedicine;
    }

    public void setAboutMedicine(String aboutMedicine) {
        this.aboutMedicine = aboutMedicine;
    }

    public Double getGramInOne() {
        return gramInOne;
    }

    public void setGramInOne(Double gramInOne) {
        this.gramInOne = gramInOne;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getConsist() {
        return consist;
    }

    public void setConsist(String consist) {
        this.consist = consist;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDosing() {
        return dosing;
    }

    public void setDosing(String dosing) {
        this.dosing = dosing;
    }

    public String getContradictions() {
        return contradictions;
    }

    public void setContradictions(String contradictions) {
        this.contradictions = contradictions;
    }
}