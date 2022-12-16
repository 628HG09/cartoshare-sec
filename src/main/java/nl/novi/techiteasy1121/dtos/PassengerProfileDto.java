package nl.novi.techiteasy1121.dtos;

public class PassengerProfileDto {
    public Long id;
    public String rideRequest;

    private UserDto userDto;

    public PassengerProfileDto() {
    }

    public PassengerProfileDto(Long id, String rideRequest) {
        this.id = id;
        this.rideRequest = rideRequest;
    }

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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
