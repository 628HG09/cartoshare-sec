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

    public List<DriverProfileDto> getAllCIModules() {
        List<DriverProfile> driverProfiles = driverProfileRepository.findAll();
        List<DriverProfileDto> dtos = new ArrayList<>();
        for (DriverProfile ci : driverProfiles) {
            dtos.add(transferToDto(ci));
        }
        return dtos;
    }

    public DriverProfileDto getCIModule(long id) {
        Optional<DriverProfile> ciModule = driverProfileRepository.findById(id);
        if(ciModule.isPresent()) {
            DriverProfileDto ci = transferToDto(ciModule.get());
            return ci;
        } else {
            throw new RecordNotFoundException("No ci-module found");
        }
    }

    public DriverProfileDto addCIModule(DriverProfileDto driverProfileDto) {
        driverProfileRepository.save(transferToCIModule(driverProfileDto));
        return driverProfileDto;
    }

    public void deleteCIModule(Long id) {
        driverProfileRepository.deleteById(id);
    }

    public void updateCIModule(Long id, DriverProfileDto driverProfileDto) {
        if(!driverProfileRepository.existsById(id)) {
            throw new RecordNotFoundException("No ci-module found");
        }
        DriverProfile storedDriverProfile = driverProfileRepository.findById(id).orElse(null);
        storedDriverProfile.setId(driverProfileDto.getId());
        storedDriverProfile.setType(driverProfileDto.getType());
        storedDriverProfile.setName(driverProfileDto.getName());
        storedDriverProfile.setPrice(driverProfileDto.getPrice());
        driverProfileRepository.save(storedDriverProfile);
    }

    public DriverProfile transferToCIModule(DriverProfileDto dto){
        DriverProfile driverProfile = new DriverProfile();

        driverProfile.setId(dto.getId());
        driverProfile.setName(dto.getName());
        driverProfile.setType(dto.getType());
        driverProfile.setPrice(dto.getPrice());

        return driverProfile;
    }
//deze hieronder static moeten maken. Als de rest foutgaat static weghalen
    public static DriverProfileDto transferToDto(DriverProfile driverProfile){
        var dto = new DriverProfileDto();

        dto.id = driverProfile.getId();
        dto.name = driverProfile.getName();
        dto.type = driverProfile.getType();
        dto.price = driverProfile.getPrice();

        return dto;
    }
}
