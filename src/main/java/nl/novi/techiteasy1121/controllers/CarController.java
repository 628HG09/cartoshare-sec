package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.CarDto;
import nl.novi.techiteasy1121.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping("/users")
    //users erbijgezet!
    public List<CarDto> getAllCars() {

        List<CarDto> dtos = carService.getAllCars();

        return dtos;
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable("id") Long id) {

        CarDto dto = carService.getCar(id);

        return dto;
    }

    @PostMapping("/users")
    // user erbij gezet!
    public CarDto addCar(@RequestBody CarDto dto) {
        CarDto dto1 = carService.addCar(dto);
        return dto1;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
    }

    @PutMapping("/{id}")
    public CarDto updateTelevision(@PathVariable("id") Long id, @RequestBody CarDto dto) {
       carService.updateCar(id, dto);
        return dto;
    }
    // car was "remoteController"

}