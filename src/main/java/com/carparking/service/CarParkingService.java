package com.carparking.service;

import com.carparking.domain.ParkedCar;
import com.carparking.repo.CarParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarParkingService {
    
    @Autowired
    private CarParkingRepository carParkingRepository;

    public List<ParkedCar> getAllParkedCars(){
        return carParkingRepository.getAllParkedCar();
    }

    public ParkedCar getParkedCarForTheSlot(int blogId){
        return carParkingRepository.findById(blogId).orElse(new ParkedCar());
    }

    public ParkedCar allotParking(String regNo, String color){
       return carParkingRepository.save(new ParkedCar(color,regNo ,true));
    }

    public ParkedCar updateCarDetails(int blogId, String title, String content){
        // getting blog
        ParkedCar parkedCar = carParkingRepository.findById(blogId).orElse(new ParkedCar());
        parkedCar.setRegNo(title);
        parkedCar.setColor(content);
        return carParkingRepository.save(parkedCar);
    }

    public boolean emptyParkingSlot(int slotNo){
        ParkedCar parkedCar = getParkedCarForId(slotNo);
        parkedCar.setIsAlloted(false);
        carParkingRepository.saveAndFlush(parkedCar);
        return true;
    }

    private ParkedCar getParkedCarForId(int id){
        return carParkingRepository.findById(id).orElse(new ParkedCar());
    }

    public ParkedCar allotPartingSlot(String slotNo,String regNo,String color) {
        ParkedCar parkedCar = carParkingRepository.getNextParkingSlot();
        if (parkedCar != null) {
            parkedCar.setColor(color);
            parkedCar.setRegNo(regNo);
            parkedCar.setIsAlloted(true);
            return carParkingRepository.saveAndFlush(parkedCar);
        } else {
            if (slotNo != null && !slotNo.isEmpty()) {
                int slot = Integer.parseInt(slotNo);
                ParkedCar car = getParkedCarForId(slot);
                if (!car.getIsAlloted()) {
                    car.setRegNo(regNo);
                    car.setColor(color);
                    car.setIsAlloted(true);
                    return carParkingRepository.saveAndFlush(car);
                } else {
                    return null;
                }
            } else {
                return allotParking(regNo, color);
            }
        }
    }
}
