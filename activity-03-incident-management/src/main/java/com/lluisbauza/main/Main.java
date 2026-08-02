package com.lluisbauza.main;

import com.lluisbauza.config.ProjectConfig;
import com.lluisbauza.enums.Category;
import com.lluisbauza.enums.Priority;
import com.lluisbauza.factory.IncidentFactory;
import com.lluisbauza.model.Incident;
import com.lluisbauza.service.TechnicianAssignmentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var incidentFactory = context.getBean(IncidentFactory.class);
        var technicianAssignmentService = context.getBean(TechnicianAssignmentService.class);
        var incidents = new ArrayList<Incident>();

        var incident1 = incidentFactory.createIncident("Can't log in", Category.ACCESS, Priority.HIGH);
        var incident2 = incidentFactory.createIncident("Printer won't print", Category.HARDWARE, Priority.LOW);
        var incident3 = incidentFactory.createIncident("Blue screen", Category.SOFTWARE, Priority.MEDIUM);

        incidents.add(incident1);
        incidents.add(incident2);
        incidents.add(incident3);

        incidents.forEach(incident -> {
            System.out.println(incident.getId());
            try {
                technicianAssignmentService.assignTechnician(incident);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println(incident.getTechnician().getName());
        });

        context.close();
    }
}
