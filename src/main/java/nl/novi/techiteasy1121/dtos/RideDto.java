package nl.novi.techiteasy1121.dtos;

import nl.novi.techiteasy1121.models.DriverProfile;

public class RideDto {
    private Long id;
    private String pickUpLocation;
    private String destination;

    private DriverProfileDto driverProfileDto;

    public RideDto() {
    }

    public RideDto(Long id, String pickUpLocation, String destination) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public DriverProfileDto getDriverProfileDto() {
        return driverProfileDto;
    }

    public void setDriverProfileDto(DriverProfileDto driverProfileDto) {
        this.driverProfileDto = driverProfileDto;
    }
}
