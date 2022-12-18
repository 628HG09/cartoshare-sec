package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.DriverProfileDto;
import nl.novi.techiteasy1121.services.DriverProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverprofiles")
public class DriverProfileController {
    private final DriverProfileService driverProfileService;

    @Autowired
    public DriverProfileController(DriverProfileService driverProfileService) {
        this.driverProfileService = driverProfileService;
    }


    @GetMapping("")
    public List<DriverProfileDto> getAllDriverProfiles() {

        var dtos = driverProfileService.getAllDriverProfiles();

        return dtos;
    }

    @GetMapping("/{id}")
    public DriverProfileDto getDriverProfile(@PathVariable("id") Long id) {

        DriverProfileDto driverProfileDto = driverProfileService.getDriverProfile(id);

        return driverProfileDto;
    }

    @PostMapping("/users")
    // /users erbij gezet!
    public DriverProfileDto addDriverProfile(@RequestBody DriverProfileDto dto) {
        DriverProfileDto driverProfileDto = driverProfileService.addDriverprofile(dto);
        return driverProfileDto;
    }

    @DeleteMapping("/{id}")
    public void deleteDriverProfile(@PathVariable("id") Long id) {
        driverProfileService.deleteDriverProfile(id);
    }

    @PutMapping("/{id}")
    public DriverProfileDto updateDriverProfile(@PathVariable("id") Long id, @RequestBody DriverProfileDto driverProfileDto) {
        driverProfileService.updateDriverProfile(id, driverProfileDto);
        return driverProfileDto;
    }

    // driverprofiles was cimodules

}