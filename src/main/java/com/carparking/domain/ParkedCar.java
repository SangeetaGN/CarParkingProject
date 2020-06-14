package com.carparking.domain;

import javax.persistence.*;

@Entity
@Table(name = "PARKED_CARS")
public class ParkedCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_no")
    private int slotNo = 0;

    private String color;

    @Column(name = "reg_no")
    private String regNo = null;

    @Column(name = "is_alloted")
    private boolean isAlloted = true;

    public ParkedCar(int slotNo, boolean isAlloted) {
        this.isAlloted = isAlloted;
        this.slotNo = slotNo;
    }

    public ParkedCar(int slotNo, String regNo, String color, boolean isAlloted) {
        this.slotNo = slotNo;
        this.regNo = regNo;
        this.isAlloted = isAlloted;
        this.color = color;
    }

    public ParkedCar(String color, String regNo, boolean isAlloted) {
        this.color = color;
        this.isAlloted = isAlloted;
        this.regNo = regNo;
    }

    public ParkedCar() {
    }


    public boolean getIsAlloted() {
        return isAlloted;
    }

    public void setIsAlloted(boolean alloted) {
        isAlloted = alloted;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "ParkedCar{" +
                "slotNo=" + slotNo +
                ", color='" + color + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}
