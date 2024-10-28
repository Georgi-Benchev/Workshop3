package com.company.oop.agency.commands.creation;

import com.company.oop.agency.commands.contracts.Command;
import com.company.oop.agency.core.contracts.AgencyRepository;
import com.company.oop.agency.models.TicketImpl;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.utils.ParsingHelpers;
import com.company.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTicketCommand implements Command {


    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String TICKET_CREATED_MESSAGE = "Ticket with ID %d was created.";

    private final AgencyRepository repository;
    private int journeyId;
    private double cost;


    public CreateTicketCommand(AgencyRepository repository) {
        this.repository = repository;
    }


    @Override
    public String execute(List<String> parameters) {

        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Journey journey = repository.findJourneyById(journeyId);
        TicketImpl ticket = repository.createTicket(journey,cost);

        return String.format(TICKET_CREATED_MESSAGE, ticket.getId());

    }


    private void parseParameters(List<String> parameters) {
        this.journeyId = ParsingHelpers.tryParseInteger(parameters.get(0), "journey id");
        this.cost = ParsingHelpers.tryParseDouble(parameters.get(1), "cost");
    }

}