package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.RideDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Ride;
import nl.novi.techiteasy1121.repositories.DriverProfileRepository;
import nl.novi.techiteasy1121.repositories.RideRepository;
import org.springframework.stereotype.Service;

@Service
public class RideService {
    private final RideRepository rideRepository;

    private final DriverProfileRepository driverProfileRepository;

    private final DriverProfileService driverProfileService;

    public RideService(RideRepository rideRepository, DriverProfileRepository driverProfileRepository, DriverProfileService driverProfileService) {
        this.rideRepository = rideRepository;
        this.driverProfileRepository = driverProfileRepository;
        this.driverProfileService = driverProfileService;
    }

    public RideDto getRideById(Long id) {

        if (rideRepository.findById(id).isPresent()){
            Ride tv = rideRepository.findById(id).get();
            RideDto dto =transferToDto(tv);
            if(tv.getDriverProfile() != null){
                dto.setDriverProfileDto(driverProfileService.transferToDto(tv.getDriverProfile()));
            }
//            if(tv.getRemoteController() != null){
//                dto.setRemoteControllerDto(remoteControllerService.transferToDto(tv.getRemoteController()));
//            }

            return transferToDto(tv);
        } else {
            throw new RecordNotFoundException("geen rit gevonden");
        }
    }
    public RideDto addRide(RideDto dto) {

        Ride tv = transferToRide(dto);
        rideRepository.save(tv);

        return transferToDto(tv);
    }

    public Ride transferToRide(RideDto dto){
        var ride = new Ride();

        ride.setDestination(dto.getDestination());
        ride.setPickUpLocation(dto.getPickUpLocation());
        ride.setRoute(dto.getRoute());
        ride.setAddRideInfo(dto.getAddRideInfo());
        ride.setDepartureTime(dto.getDepartureTime());
        ride.setPricePerPerson(dto.getPricePerPerson());
        ride.setTotalRitPrice(dto.getTotalRitPrice());
        ride.setAvailableSpots(dto.getAvailableSpots());
        ride.setAutomaticAcceptance(dto.isAutomaticAcceptance());


        return ride;
    }

    public RideDto transferToDto(Ride ride){
        RideDto dto = new RideDto();

        dto.setId(ride.getId());
        dto.setDestination(ride.getDestination());
        dto.setPickUpLocation(ride.getPickUpLocation());
        dto.setRoute(ride.getRoute());
        dto.setAddRideInfo(ride.getAddRideInfo());
        dto.setDepartureTime(ride.getDepartureTime());
        dto.setPricePerPerson(ride.getPricePerPerson());
        dto.setTotalRitPrice(ride.getTotalRitPrice());
        dto.setAvailableSpots(ride.getAvailableSpots());
        dto.setAutomaticAcceptance(ride.isAutomaticAcceptance());
        if(ride.getDriverProfile() != null){
            //bestuurderService begon met een B
            dto.setDriverProfileDto(DriverProfileService.transferToDto(ride.getDriverProfile()));
        }

        return dto;
    }

    public void assignDriverProfileToRide(Long id, Long driverProfileId) {
        var optionalRide = rideRepository.findById(id);
        var optionalDriverProfile = driverProfileRepository.findById(driverProfileId);

        if(optionalRide.isPresent() && optionalDriverProfile.isPresent()) {
            var ride = optionalRide.get();
            var driverProfile = optionalDriverProfile.get();

            ride.setDriverProfile(driverProfile);
            rideRepository.save(ride);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
