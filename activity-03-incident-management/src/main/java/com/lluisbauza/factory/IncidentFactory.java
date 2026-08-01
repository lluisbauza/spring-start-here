package com.lluisbauza.factory;

import com.lluisbauza.enums.Category;
import com.lluisbauza.enums.Priority;
import com.lluisbauza.model.Incident;
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

    public Incident createIncident(String description, Category category, Priority priority) {
        Incident incident = incidentProvider.getObject();

        incident.setId(count.incrementAndGet());
        incident.setDescription(description);
        incident.setCategory(category);
        incident.setPriority(priority);

        return incident;
    }



}
