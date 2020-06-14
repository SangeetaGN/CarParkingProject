package com.carparking.repo;

import com.carparking.domain.Blog;
import com.carparking.domain.ParkedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface CarParkingRepository  extends JpaRepository<ParkedCar, Integer>{
    public static final String NextAllotingSlot = "SELECT * FROM PARKED_CARS where is_alloted = false order by slot_no limit 1";
    public static final String AllowtedSlot = "SELECT * FROM PARKED_CARS where is_alloted = true order by slot_no";

    @Query(value = NextAllotingSlot,nativeQuery = true)
    public ParkedCar getNextParkingSlot();

    @Query(value = AllowtedSlot,nativeQuery = true)
    public List<ParkedCar> getAllParkedCar();

}
