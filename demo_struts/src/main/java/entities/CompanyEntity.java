package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="company")
public class CompanyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompany")
    private Integer idcompany;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "country")
    @Basic(optional = false)
    private String country;

    @Column(name = "privat")
    @Basic(optional = false)
    private Boolean privat = false;

    @Column(name = "ownername")
    @Basic(optional = true)
    private String ownerName;

    @Column(name = "numberemployees")
    @Basic(optional = false)
    private int numberEmployees = 0;

    @Column(name = "income")
    @Basic(optional = false)
    private double income = 0.0;


    public CompanyEntity() {
    }

    public CompanyEntity(String name,
                         String country,
                         Boolean privat,
                         String ownerName,
                         int numberEmployees,
                         double income) {
        this.name = name;
        this.country = country;
        this.privat = privat;
        this.ownerName = ownerName;
        this.numberEmployees = numberEmployees;
        this.income = income;
    }

    public Integer getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getPrivat() {
        return privat;
    }

    public void setPrivat(Boolean privat) {
        this.privat = privat;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
