package com.zxcourse.coursework.entities;
import javax.persistence.*;

@Entity
@Table(name = "rents")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private Long lengthOfTrip;

    @Column(nullable = false, length = 100)
    private String dateOfTrip;

    @Column(nullable = false, length = 100)
    private String timeOfTrip;

    @Column(nullable = false, length = 100)
    private String timeOnTrip;

    @Column(nullable = false, length = 100)
    private String rateOfTrip;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client_id;

    @OneToOne
    @JoinColumn(name = "scooter_id")
    private ScooterEntity scooter_id;

    public RentEntity(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getLengthOfTrip() {
        return lengthOfTrip;
    }

    public void setLengthOfTrip(Long lengthOfTrip) {
        this.lengthOfTrip = lengthOfTrip;
    }

    public String getDateOfTrip() {
        return dateOfTrip;
    }

    public void setDateOfTrip(String dateOfTrip) {
        this.dateOfTrip = dateOfTrip;
    }

    public String getTimeOfTrip() {
        return timeOfTrip;
    }

    public void setTimeOfTrip(String timeOfTrip) {
        this.timeOfTrip = timeOfTrip;
    }

    public String getTimeOnTrip() {
        return timeOnTrip;
    }

    public void setTimeOnTrip(String timeOnTrip) {
        this.timeOnTrip = timeOnTrip;
    }


    public String getRateOfTrip() {
        return rateOfTrip;
    }

    public void setRateOfTrip(String rateOfTrip) {
        this.rateOfTrip = rateOfTrip;
    }

    public ClientEntity getClient_id() {
        return client_id;
    }

    public void setClient_id(ClientEntity client_id) {
        this.client_id = client_id;
    }

    public ScooterEntity getScooter_id() {
        return scooter_id;
    }

    public void setScooter_id(ScooterEntity scooter_id) {
        this.scooter_id = scooter_id;
    }

}
