package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.DriverProfileDto;
import nl.novi.techiteasy1121.services.DriverProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverProfileController {
    private final DriverProfileService driverProfileService;

    @Autowired
    public DriverProfileController(DriverProfileService driverProfileService) {
        this.driverProfileService = driverProfileService;
    }


    @GetMapping("/cimodules")
    public List<DriverProfileDto> getAllCIModules() {

        var dtos = driverProfileService.getAllCIModules();

        return dtos;
    }

    @GetMapping("/cimodules/{id}")
    public DriverProfileDto getCIModule(@PathVariable("id") Long id) {

        DriverProfileDto driverProfileDto = driverProfileService.getCIModule(id);

        return driverProfileDto;
    }

    @PostMapping("/cimodules")
    public DriverProfileDto addCIModule(@RequestBody DriverProfileDto dto) {
        DriverProfileDto driverProfileDto = driverProfileService.addCIModule(dto);
        return driverProfileDto;
    }

    @DeleteMapping("/cimodules/{id}")
    public void deleteCIModule(@PathVariable("id") Long id) {
        driverProfileService.deleteCIModule(id);
    }

    @PutMapping("/cimodules/{id}")
    public DriverProfileDto updateCIModule(@PathVariable("id") Long id, @RequestBody DriverProfileDto driverProfileDto) {
        driverProfileService.updateCIModule(id, driverProfileDto);
        return driverProfileDto;
    }

}