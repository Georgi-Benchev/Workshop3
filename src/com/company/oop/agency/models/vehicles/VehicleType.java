package com.company.oop.agency.models.vehicles;

public enum VehicleType {

    LAND,
    AIR,
    SEA;

    @Override
    public String toString() {
        switch (this) {
            case LAND:
                return "Land";
            case AIR:
                return "Air";
            case SEA:
                return "Sea";
            default:
                throw new IllegalArgumentException();
        }
    }

}
