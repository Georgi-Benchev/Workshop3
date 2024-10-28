package com.company.oop.agency.models.contracts;

public interface Ticket extends Printable{

    Journey getJourney();

    double calculatePrice();

    double getAdministrativeCosts();

}