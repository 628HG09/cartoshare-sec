package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.DriverProfileDto;
import nl.novi.techiteasy1121.dtos.PassengerProfileDto;
import nl.novi.techiteasy1121.services.DriverProfileService;
import nl.novi.techiteasy1121.services.PassengerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerProfileController {
    private final PassengerProfileService passengerProfileService;

    @Autowired
    public PassengerProfileController(PassengerProfileService passengerProfileService) {
        this.passengerProfileService = passengerProfileService;
    }


    @GetMapping("/test/cimodules")
    public List<PassengerProfileDto> getAllCIModules() {

        var dtos = passengerProfileService.getAllCIModules();

        return dtos;
    }

    @GetMapping("/test/cimodules/{id}")
    public PassengerProfileDto getCIModule(@PathVariable("id") Long id) {

        PassengerProfileDto passengerProfileDto = passengerProfileService.getCIModule(id);

        return passengerProfileDto;
    }

    @PostMapping("/test/cimodules")
    public PassengerProfileDto addCIModule(@RequestBody PassengerProfileDto dto) {
        PassengerProfileDto passengerProfileDto = passengerProfileService.addCIModule(dto);
        return passengerProfileDto;
    }

    @DeleteMapping("/test/cimodules/{id}")
    public void deleteCIModule(@PathVariable("id") Long id) {
        passengerProfileService.deleteCIModule(id);
    }

    @PutMapping("/test/cimodules/{id}")
    public PassengerProfileDto updateCIModule(@PathVariable("id") Long id, @RequestBody PassengerProfileDto passengerProfileDto) {
        passengerProfileService.updateCIModule(id, passengerProfileDto);
        return passengerProfileDto;
    }
}
