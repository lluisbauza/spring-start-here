package com.lluisbauza.activity06incidentboard.factory;

import com.lluisbauza.activity06incidentboard.model.Incident;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IncidentFactory {

    private final ObjectProvider<Incident> incidentProvider;
    private final AtomicInteger count = new AtomicInteger(0);

    public IncidentFactory(ObjectProvider<Incident> incidentProvider) {
        this.incidentProvider = incidentProvider;
    }

    public Incident createIncident(String title, String category, String priority) {
        Incident incident = incidentProvider.getObject();

        incident.setId(count.incrementAndGet());
        incident.setTitle(title);
        incident.setCategory(category);
        incident.setPriority(priority);

        return incident;
    }

}
