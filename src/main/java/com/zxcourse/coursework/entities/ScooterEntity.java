package com.zxcourse.coursework.entities;
import javax.persistence.*;

@Entity
@Table(name = "scooters")
public class ScooterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false, length = 100)
    private Integer chargePercent;

    @Column(nullable = false, length = 100)
    private Boolean lockStatus;

    @Column(nullable = false, length = 100)
    private Boolean torchStatus;

    @Column(nullable = false, length = 100)
    private String geolocation;

    @Column(nullable = false, length = 100)
    private String photoURL;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "scooter_id")
    private RentEntity rent;

    public RentEntity getRent() {
        return rent;
    }

    public void setRent(RentEntity rent) {
        this.rent = rent;
    }
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Integer getChargePercent() {
        return chargePercent;
    }

    public void setChargePercent(Integer chargePercent) {
        this.chargePercent = chargePercent;
    }

    public Boolean getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Boolean getTorchStatus() {
        return torchStatus;
    }

    public void setTorchStatus(Boolean torchStatus) {
        this.torchStatus = torchStatus;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public ScooterEntity(){}
}
