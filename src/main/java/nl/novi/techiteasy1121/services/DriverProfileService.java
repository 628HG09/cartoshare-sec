package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.DriverProfileDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.DriverProfile;
import nl.novi.techiteasy1121.repositories.DriverProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverProfileService {

    @Autowired
    private DriverProfileRepository driverProfileRepository;

    public List<DriverProfileDto> getAllDriverProfiles() {
        List<DriverProfile> driverProfiles = driverProfileRepository.findAll();
        List<DriverProfileDto> dtos = new ArrayList<>();
        for (DriverProfile ci : driverProfiles) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public DriverProfileDto getDriverProfile(long id) {
        Optional<DriverProfile> driverProfile = driverProfileRepository.findById(id);
        if(driverProfile.isPresent()) {
            DriverProfileDto ci = transferToDto(driverProfile.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No driver-profile found");
        }
    }

    public DriverProfileDto addDriverprofile(DriverProfileDto driverProfileDto) {
        driverProfileRepository.save(transferToDriverProfile(driverProfileDto));
        return driverProfileDto;
    }

    public void deleteDriverProfile(Long id) {
        driverProfileRepository.deleteById(id);
    }

    public void updateDriverProfile(Long id, DriverProfileDto driverProfileDto) {
        if(!driverProfileRepository.existsById(id)) {
            throw new RecordNotFoundException("No driver-profile found");
        }
        DriverProfile storedDriverProfile = driverProfileRepository.findById(id).orElse(null);
        storedDriverProfile.setId(driverProfileDto.getId());
        storedDriverProfile.setOpen(driverProfileDto.getOpen());
        driverProfileRepository.save(storedDriverProfile);
    }

    public DriverProfile transferToDriverProfile(DriverProfileDto dto){
        DriverProfile driverProfile = new DriverProfile();

        driverProfile.setId(dto.getId());
        driverProfile.setOpen(dto.getOpen());

        return driverProfile;
    }
//deze hieronder static moeten maken. Als de rest foutgaat static weghalen
    public static DriverProfileDto transferToDto(DriverProfile driverProfile){
        var dto = new DriverProfileDto();

        dto.id = driverProfile.getId();
        dto.open = driverProfile.getOpen();

        return dto;
    }
}
