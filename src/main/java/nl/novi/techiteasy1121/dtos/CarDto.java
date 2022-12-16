package nl.novi.techiteasy1121.dtos;
// validators mogen jullie eventueel zelf toevoegen

public class CarDto {

    public Long id;
    public String licensePlate;
    public String model;
    public String brand;


    public CarDto() {
    }

    public CarDto(Long id, String licensePlate, String model, String brand) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
    }

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

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
