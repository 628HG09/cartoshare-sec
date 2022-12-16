package nl.novi.techiteasy1121.models;

import javax.persistence.*;

@Entity
public class PassengerProfile {
    @Id
    @GeneratedValue
    private Long id;
    private String rideRequest;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRideRequest() {
        return rideRequest;
    }

    public void setRideRequest(String rideRequest) {
        this.rideRequest = rideRequest;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
