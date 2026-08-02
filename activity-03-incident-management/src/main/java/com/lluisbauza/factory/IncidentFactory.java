package com.lluisbauza.factory;

import com.lluisbauza.annotation.NewIncident;
import com.lluisbauza.enums.Category;
import com.lluisbauza.enums.Priority;
import com.lluisbauza.model.Incident;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
public class IncidentFactory {

    private final ObjectProvider<Incident> incidentProvider;
    private final AtomicInteger count = new AtomicInteger(0);
    private Logger logger = Logger.getLogger(IncidentFactory.class.getName());

    public IncidentFactory(ObjectProvider<Incident> incidentProvider) {
        this.incidentProvider = incidentProvider;
        logger.info("IncidentFactory bean created when implementing Spring Context due to: Eager implementation.");
    }

    @NewIncident
    public Incident createIncident(String description, Category category, Priority priority) {
        Incident incident = incidentProvider.getObject();

        incident.setId(count.incrementAndGet());
        incident.setDescription(description);
        incident.setCategory(category);
        incident.setPriority(priority);

        return incident;
    }

}
