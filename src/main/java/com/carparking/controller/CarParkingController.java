package com.carparking.controller;

import com.carparking.domain.ParkedCar;
import com.carparking.service.CarParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarParkingController {
    @Autowired
    private CarParkingService carParkingService;

    @RequestMapping(value = "/health" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void checkHealth(){
    }

    @GetMapping("/alloted/slots")
    public List<ParkedCar> getAllParkedCars(){
        return carParkingService.getAllParkedCars();
    }

    @GetMapping("/allotedcar/{id}")
    public ParkedCar show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return carParkingService.getParkedCarForTheSlot(blogId);
    }

    @PostMapping("/allot")
    public ParkedCar allotParkingSlots(@RequestBody Map<String, String> body){
        String slotNo = body.get("slotNo");
        String regNo = body.get("regNo");
        String color = body.get("color");
        return carParkingService.allotPartingSlot(slotNo,regNo,color);
    }

    @PutMapping("/car/{id}")
    public ParkedCar update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        return carParkingService.updateCarDetails(blogId,body.get("regNo"),body.get("color"));
    }

    @DeleteMapping("/remove/{id}")
    public boolean delete(@PathVariable String id){
        int i = Integer.parseInt(id);
        return carParkingService.emptyParkingSlot(i);
    }
}
