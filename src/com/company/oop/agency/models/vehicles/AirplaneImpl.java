package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.utils.ValidationHelper;

public class AirplaneImpl extends VehicleBase implements Airplane {


    private static final String PASSENGER_ERROR_MESSAGE = "A plane cannot have less than 1 passengers or more than 800 passengers.";
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    /*      same as default no need to override
        public static final double PRICE_MIN_VALUE = 0.1;
        public static final double PRICE_MAX_VALUE = 2.5;
    */
    boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.AIR);
        setHasFreeFood(hasFreeFood);
    }


    public void setHasFreeFood(boolean hasFreeFood) {
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE
        );
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String getAsString() {
        return "Airplane ----\n" + super.getAsString() + "\nHas free food: " + hasFreeFood()+"\n";
    }
}