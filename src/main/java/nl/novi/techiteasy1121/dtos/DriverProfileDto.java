package nl.novi.techiteasy1121.dtos;
// validators mogen jullie eventueel zelf toevoegen

public class DriverProfileDto {

    public Long id;
    public String open;

    private CarDto carDto;

    private UserDto userDto;

    public DriverProfileDto() {
    }

    // MOET HIER NOG CAR BIJ?:
    public DriverProfileDto(Long id, String open) {
        this.id = id;
        this.open = open;

    }

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

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
