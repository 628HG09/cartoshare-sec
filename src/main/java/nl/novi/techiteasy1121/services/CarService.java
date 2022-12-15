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
        storedCar.setCompatibleWith(carDto.getCompatibleWith());
        storedCar.setBatteryType(carDto.getBatteryType());
        storedCar.setName(carDto.getName());
        storedCar.setPrice(carDto.getPrice());
        storedCar.setBrand(carDto.getBrand());
        storedCar.setOriginalStock(carDto.getOriginalStock());
        carRepository.save(storedCar);
    }

    public CarDto transferToDto(Car car){
        var dto = new CarDto();

        dto.id = car.getId();
        dto.compatibleWith = car.getCompatibleWith();
        dto.batteryType = car.getBatteryType();
        dto.name = car.getName();
        dto.brand = car.getBrand();
        dto.price = car.getPrice();
        dto.originalStock = car.getOriginalStock();

        return dto;
    }

    public Car transferToRemoteController(CarDto dto){
        var remoteController = new Car();

        remoteController.setId(dto.getId());
        remoteController.setCompatibleWith(dto.getCompatibleWith());
        remoteController.setBatteryType(dto.getBatteryType());
        remoteController.setName(dto.getName());
        remoteController.setBrand(dto.getBrand());
        remoteController.setPrice(dto.getPrice());
        remoteController.setOriginalStock(dto.getOriginalStock());

        return remoteController;
    }

}
