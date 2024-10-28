package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleBase implements Bus {

    private static final String PASSENGER_ERROR_MESSAGE = "A bus cannot have less than 10 passengers or more than 50 passengers.";
    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
/*    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;*/   // -> same as default

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id,passengerCapacity,pricePerKilometer,VehicleType.LAND);
        /*throw new UnsupportedOperationException("Not implemented yet.");*/
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

}