package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        if (costs<0){
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.",costs));
        }
        this.administrativeCosts = costs;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    @Override
    public String getAsString() {
        return String.format(
                "Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %.2f\n",journey.getDestination(),calculatePrice());
    }

    @Override
    public int getId() {
        return id;
    }
}
