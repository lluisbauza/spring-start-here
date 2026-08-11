package com.lluisbauza.activity06incidentboard.bootstrap;

import com.lluisbauza.activity06incidentboard.factory.IncidentFactory;
import com.lluisbauza.activity06incidentboard.service.IncidentsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IncidentFactory incidentFactory;
    private final IncidentsService incidentsService;

    public DataInitializer(IncidentFactory incidentFactory, IncidentsService incidentsService) {
        this.incidentFactory = incidentFactory;
        this.incidentsService = incidentsService;
    }

    @Override
    public void run(String... args) throws Exception {
        var incident1 = incidentFactory.createIncident("Can't log in", "Access", "High");
        var incident2 = incidentFactory.createIncident("Printer won't print", "Hardware", "Low");
        var incident3 = incidentFactory.createIncident("Blue screen", "Software", "Medium");
        incidentsService.addIncident(incident1);
        incidentsService.addIncident(incident2);
        incidentsService.addIncident(incident3);
    }
}
