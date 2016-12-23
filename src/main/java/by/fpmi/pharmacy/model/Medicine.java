package by.fpmi.pharmacy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "medicine")
public class Medicine implements Serializable{
    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_medicine")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_subscription")
    private List<Subscription> subscriptions;

    public Medicine(String nameMedicine, String aboutMedicine, Double gramInOne, Double cost, Integer quantity,
                    String consist, Date expiration_date, String state, String dosing,
                    String contradictions, String imagePath) {
        this.nameMedicine = nameMedicine;
        this.aboutMedicine = aboutMedicine;
        this.gramInOne = gramInOne;
        this.cost = cost;
        this.quantity = quantity;
        this.consist = consist;
        this.expiration_date = expiration_date;
        this.state = state;
        this.dosing = dosing;
        this.contradictions = contradictions;
        this.imagePath = imagePath;
    }

    public Medicine() {
    }


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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (!getIdMedicine().equals(medicine.getIdMedicine())) return false;
        if (!getNameMedicine().equals(medicine.getNameMedicine())) return false;
        if (!getAboutMedicine().equals(medicine.getAboutMedicine())) return false;
        if (!getGramInOne().equals(medicine.getGramInOne())) return false;
        if (!getCost().equals(medicine.getCost())) return false;
        if (!getQuantity().equals(medicine.getQuantity())) return false;
        if (!getConsist().equals(medicine.getConsist())) return false;
        if (!getExpiration_date().equals(medicine.getExpiration_date())) return false;
        if (!getState().equals(medicine.getState())) return false;
        if (!getDosing().equals(medicine.getDosing())) return false;
        if (!getContradictions().equals(medicine.getContradictions())) return false;
        return getImagePath().equals(medicine.getImagePath());

    }

    @Override
    public int hashCode() {
        int result = getIdMedicine().hashCode();
        result = 31 * result + getNameMedicine().hashCode();
        result = 31 * result + getAboutMedicine().hashCode();
        result = 31 * result + getGramInOne().hashCode();
        result = 31 * result + getCost().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getConsist().hashCode();
        result = 31 * result + getExpiration_date().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getDosing().hashCode();
        result = 31 * result + getContradictions().hashCode();
        result = 31 * result + getImagePath().hashCode();
        return result;
    }
}