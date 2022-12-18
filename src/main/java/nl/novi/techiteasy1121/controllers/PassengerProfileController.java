package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.PassengerProfileDto;
import nl.novi.techiteasy1121.services.PassengerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerprofiles")
public class PassengerProfileController {
    private final PassengerProfileService passengerProfileService;

    @Autowired
    public PassengerProfileController(PassengerProfileService passengerProfileService) {
        this.passengerProfileService = passengerProfileService;
    }


    @GetMapping("")
    public List<PassengerProfileDto> getAllPassengerProfiles() {

        var dtos = passengerProfileService.getAllPassengerprofiles();

        return dtos;
    }

    @GetMapping("/{id}")
    public PassengerProfileDto getPassengerProfile(@PathVariable("id") Long id) {

        PassengerProfileDto passengerProfileDto = passengerProfileService.getPassengerProfile(id);

        return passengerProfileDto;
    }

    @PostMapping("")
    public PassengerProfileDto addPassengerProfile(@RequestBody PassengerProfileDto dto) {
        PassengerProfileDto passengerProfileDto = passengerProfileService.addPassengerProfile(dto);
        return passengerProfileDto;
    }

    @DeleteMapping("/{id}")
    public void deletePassengerProfile(@PathVariable("id") Long id) {
        passengerProfileService.deletePassengerProfile(id);
    }

    @PutMapping("/{id}")
    public PassengerProfileDto updatePassengerProfile(@PathVariable("id") Long id, @RequestBody PassengerProfileDto passengerProfileDto) {
        passengerProfileService.updatePassengerProfile(id, passengerProfileDto);
        return passengerProfileDto;
    }
//     PP was ook cimodules
}
