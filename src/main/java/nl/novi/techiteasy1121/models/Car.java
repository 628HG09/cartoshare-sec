package nl.novi.techiteasy1121.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    private String licensePlate;
    private String model;
    private String brand;

    @OneToOne(mappedBy = "car")
    DriverProfile driverProfile;

//    De constructors hoeven niet gemaakt te worden mag wel
//    public Car() {
//    }
//
//    public Car( String compatibleWith, String batteryType, String name, String brand, Double price, Integer originalStock) {
//        this.compatibleWith = compatibleWith;
//        this.batteryType = batteryType;
//        this.name = name;
//        this.brand = brand;
//        this.price = price;
//        this.originalStock = originalStock;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public DriverProfile getDriverProfile() {
        return driverProfile;
    }

    public void setDriverProfile(DriverProfile driverProfile) {
        this.driverProfile = driverProfile;
    }
}
