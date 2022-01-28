package com.spring.simple.steps.university.backend.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Direction implements Serializable {
    private String Street;
    private String number;
    private String postalCode;
    private String Department;
    private String floor;
    private String location;

    public Direction() {
    }

    public Direction(String street, String number, String postalCode, String department, String floor, String location) {
        Street = street;
        this.number = number;
        this.postalCode = postalCode;
        Department = department;
        this.floor = floor;
        this.location = location;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "Street='" + Street + '\'' +
                ", number='" + number + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", Department='" + Department + '\'' +
                ", floor='" + floor + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
