package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.CarDto;
import nl.novi.techiteasy1121.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/remotecontrollers")
    public List<CarDto> getAllRemotecontrollers() {

        List<CarDto> dtos = carService.getAllRemoteControllers();

        return dtos;
    }

    @GetMapping("/remotecontrollers/{id}")
    public CarDto getRemotecontroller(@PathVariable("id") Long id) {

        CarDto dto = carService.getRemoteController(id);

        return dto;
    }

    @PostMapping("/remotecontrollers")
    public CarDto addRemoteController(@RequestBody CarDto dto) {
        CarDto dto1 = carService.addRemoteController(dto);
        return dto1;
    }

    @DeleteMapping("/remotecontrollers/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id) {
        carService.deleteRemoteController(id);
    }

    @PutMapping("/remotecontrollers/{id}")
    public CarDto updateTelevision(@PathVariable("id") Long id, @RequestBody CarDto dto) {
       carService.updateRemoteController(id, dto);
        return dto;
    }

}