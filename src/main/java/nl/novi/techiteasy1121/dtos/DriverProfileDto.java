package nl.novi.techiteasy1121.dtos;
// validators mogen jullie eventueel zelf toevoegen

public class DriverProfileDto {

    public Long id;
    public String name;
    public String type;
    public Double price;

    private CarDto carDto;

    public DriverProfileDto() {
    }

    // MOET HIER NOG CAR BIJ?:
    public DriverProfileDto(Long id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }
}
