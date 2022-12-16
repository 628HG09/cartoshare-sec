package nl.novi.techiteasy1121.models;

import javax.persistence.*;

@Entity
public class DriverProfile {

    @Id
    @GeneratedValue
    private Long id;
    private String open;

//    @OneToMany(mappedBy = "driverProfile")
//    @JsonIgnore
//    List<User> users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
