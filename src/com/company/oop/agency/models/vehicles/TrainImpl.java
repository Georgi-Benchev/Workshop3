package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleBase implements Train {

    private static final String PASSENGER_ERROR_MESSAGE = "A train cannot have less than 30 passengers or more than 150 passengers.";
    private static final String CARTS_ERROR_MESSAGE = "A train cannot have less than 1 cart or more than 15 carts.";
    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
/*    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;*/  // -> same as default

    int carts;


    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.LAND);
        setCarts(carts);
        /*throw new UnsupportedOperationException("Not implemented yet.");*/
    }

    public void setCarts(int carts) {
        ValidationHelper.validateValueInRange(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE, CARTS_ERROR_MESSAGE);
        this.carts = carts;
    }

    @Override
    public int getCarts() {
        return this.carts;
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
    public String getAsString() {
        return "Train ---\n" + super.getAsString() + "\nCarts amount: " + getCarts();
    }

}