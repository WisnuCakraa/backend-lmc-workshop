package com.nunu.lmc.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "CompanyProfile")
@Table(name="company_profile")
public class CompanyProfile {
    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Integer id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "no_telfon", nullable = false)
    private String noTelp;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", nullable = false)
    private String description;

    public CompanyProfile() {
    }

    public CompanyProfile(String companyName, String ownerName, String noTelp, String address, String description) {
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.noTelp = noTelp;
        this.address = address;
        this.description = description;
    }

    public CompanyProfile(Integer id, String companyName, String ownerName, String noTelp, String address, String description) {
        this.id = id;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.noTelp = noTelp;
        this.address = address;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CompanyProfile{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", noTelp='" + noTelp + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
