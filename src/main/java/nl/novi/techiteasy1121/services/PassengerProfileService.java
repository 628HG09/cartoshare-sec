package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.DriverProfileDto;
import nl.novi.techiteasy1121.dtos.PassengerProfileDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.DriverProfile;
import nl.novi.techiteasy1121.models.PassengerProfile;
import nl.novi.techiteasy1121.repositories.DriverProfileRepository;
import nl.novi.techiteasy1121.repositories.PassengerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerProfileService {
    @Autowired
    private PassengerProfileRepository passengerProfileRepository;

    public List<PassengerProfileDto> getAllPassengerprofiles() {
        List<PassengerProfile> passengerProfiles = passengerProfileRepository.findAll();
        List<PassengerProfileDto> dtos = new ArrayList<>();
        for (PassengerProfile ci : passengerProfiles) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public PassengerProfileDto getPassengerProfile(long id) {
        Optional<PassengerProfile> passengerProfile = passengerProfileRepository.findById(id);
        if(passengerProfile.isPresent()) {
            PassengerProfileDto ci = transferToDto(passengerProfile.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No passenger-profile found");
        }
    }

    public PassengerProfileDto addPassengerProfile(PassengerProfileDto passengerProfileDto) {
        passengerProfileRepository.save(transferToPassengerProfile(passengerProfileDto));
        return passengerProfileDto;
    }

    public void deletePassengerProfile(Long id) {
        passengerProfileRepository.deleteById(id);
    }

    public void updatePassengerProfile(Long id, PassengerProfileDto passengerProfileDto) {
        if(!passengerProfileRepository.existsById(id)) {
            throw new RecordNotFoundException("No passenger-profile found");
        }
        PassengerProfile storedPassengerProfile = passengerProfileRepository.findById(id).orElse(null);
        storedPassengerProfile.setId(passengerProfileDto.getId());
        storedPassengerProfile.setRideRequest(passengerProfileDto.getRideRequest());
        passengerProfileRepository.save(storedPassengerProfile);
    }

    public PassengerProfile transferToPassengerProfile(PassengerProfileDto dto){
        PassengerProfile passengerProfile = new PassengerProfile();

        passengerProfile.setId(dto.getId());
        passengerProfile.setRideRequest(dto.getRideRequest());

        return passengerProfile;
    }
    //deze hieronder static moeten maken. Als de rest foutgaat static weghalen
    public static PassengerProfileDto transferToDto(PassengerProfile passengerProfileProfile){
        var dto = new PassengerProfileDto();

        dto.id = passengerProfileProfile.getId();
        dto.rideRequest= passengerProfileProfile.getRideRequest();

        return dto;
    }
}

