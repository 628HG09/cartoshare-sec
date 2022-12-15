package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.RideDto;
import nl.novi.techiteasy1121.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }


    @PostMapping("")
    public ResponseEntity<Object> addRit(@RequestBody RideDto rideDto){
        RideDto dto = rideService.addRide(rideDto);
//        Rit savedRit =  rideService.save(ritDto);

        return ResponseEntity.created(null).body(dto);
    }

    @PutMapping("/{id}/{bestuurderId}")
    public void assignBestuurderToRit(@PathVariable("id") Long id, @PathVariable("bestuurderId") Long bestuurderId) {
        rideService.assignDriverProfileToRide(id, bestuurderId);
    }
}
