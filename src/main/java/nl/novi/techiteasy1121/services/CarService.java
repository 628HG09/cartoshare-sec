package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.CarDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Car;
import nl.novi.techiteasy1121.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getAllRemoteControllers() {
        List<CarDto> dtos = new ArrayList<>();
        List<Car> cars = carRepository.findAll();
        for (Car rc : cars) {
            dtos.add(transferToDto(rc));
        }
        return dtos;
    }

    public CarDto getRemoteController(long id) {
        Optional<Car> remoteController = carRepository.findById(id);
        if(remoteController.isPresent()) {
            return transferToDto(remoteController.get());
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }
    }

    public CarDto addRemoteController(CarDto carDto) {
        Car rc =  transferToRemoteController(carDto);
        carRepository.save(rc);
        return carDto;
    }

    public void deleteRemoteController(Long id) {
        carRepository.deleteById(id);
    }

    public void updateRemoteController(Long id, CarDto carDto) {
        if(!carRepository.existsById(id)) {
            throw new RecordNotFoundException("No remotecontroller found");
        }
        Car storedCar = carRepository.findById(id).orElse(null);
        storedCar.setId(carDto.getId());
        storedCar.setLicensePlate(carDto.getLicensePlate());
        storedCar.setModel(carDto.getModel());
        storedCar.setBrand(carDto.getBrand());
        carRepository.save(storedCar);
    }

    public CarDto transferToDto(Car car){
        var dto = new CarDto();

        dto.id = car.getId();
        dto.licensePlate = car.getLicensePlate();
        dto.model = car.getModel();
        dto.brand = car.getBrand();

        return dto;
    }

    public Car transferToRemoteController(CarDto dto){
        var remoteController = new Car();

        remoteController.setId(dto.getId());
        remoteController.setLicensePlate(dto.getLicensePlate());
        remoteController.setModel(dto.getModel());
        remoteController.setBrand(dto.getBrand());

        return remoteController;
    }

}
