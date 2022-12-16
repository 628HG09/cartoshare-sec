package nl.novi.techiteasy1121.dtos;

import nl.novi.techiteasy1121.models.DriverProfile;

import java.time.LocalTime;

public class RideDto {
    private Long id;
    private String pickUpLocation;
    private String destination;
    private String Route;

    private String addRideInfo;

    private LocalTime departureTime;

    private double pricePerPerson;

    private double totalRitPrice;

    private int availableSpots;

    private boolean automaticAcceptance;

    private DriverProfileDto driverProfileDto;

    public RideDto() {
    }

    public RideDto(Long id, String pickUpLocation, String destination, String route, String addRideInfo, LocalTime departureTime, double pricePerPerson, double totalRitPrice, int availableSpots, boolean automaticAcceptance) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
        this.Route = route;
        this.addRideInfo = addRideInfo;
        this.departureTime = departureTime;
        this.pricePerPerson = pricePerPerson;
        this.totalRitPrice = totalRitPrice;
        this.availableSpots = availableSpots;
        this.automaticAcceptance = automaticAcceptance;
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

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public String getAddRideInfo() {
        return addRideInfo;
    }

    public void setAddRideInfo(String addRideInfo) {
        this.addRideInfo = addRideInfo;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public double getTotalRitPrice() {
        return totalRitPrice;
    }

    public void setTotalRitPrice(double totalRitPrice) {
        this.totalRitPrice = totalRitPrice;
    }

    public int getAvailableSpots() {
        return availableSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public boolean isAutomaticAcceptance() {
        return automaticAcceptance;
    }

    public void setAutomaticAcceptance(boolean automaticAcceptance) {
        this.automaticAcceptance = automaticAcceptance;
    }

    public DriverProfileDto getDriverProfileDto() {
        return driverProfileDto;
    }

    public void setDriverProfileDto(DriverProfileDto driverProfileDto) {
        this.driverProfileDto = driverProfileDto;
    }
}
