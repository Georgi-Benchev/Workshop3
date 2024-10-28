package com.company.oop.agency.models.vehicles;

public enum VehicleType {

    LAND,
    AIR,
    SEA;

    @Override
    public String toString() {
        switch (this) {
            case LAND:
                return "LAND";
            case AIR:
                return "AIR";
            case SEA:
                return "SEA";
            default:
                throw new IllegalArgumentException();
        }
    }

}
