package com.lluisbauza.main;

import com.lluisbauza.config.ProjectConfig;
import com.lluisbauza.enums.Category;
import com.lluisbauza.enums.Priority;
import com.lluisbauza.factory.IncidentFactory;
import com.lluisbauza.repository.IncidentRepository;
import com.lluisbauza.service.IncidentReportService;
import com.lluisbauza.service.TechnicianAssignmentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Activity 3 - Incident Management.
 *
 * Demonstrates incident creation and management using Spring Core concepts
 * such as dependency injection, bean scopes and AOP.
 *
 * - Uses hardcoded data to test the application flow.
 * - Uses basic console output and logging for demonstration purposes.
 * - Demonstrates singleton and prototype bean scopes.
 *
 * @author Lluís Bauzá
 */

public class Main {
    static void main() {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var incidentFactory = context.getBean(IncidentFactory.class);
        var technicianAssignmentService = context.getBean(TechnicianAssignmentService.class);
        var incidentRepository = context.getBean(IncidentRepository.class);

        var incident1 = incidentFactory.createIncident("Can't log in", Category.ACCESS, Priority.HIGH);
        var incident2 = incidentFactory.createIncident("Printer won't print", Category.HARDWARE, Priority.LOW);
        var incident3 = incidentFactory.createIncident("Blue screen", Category.SOFTWARE, Priority.MEDIUM);

        incidentRepository.addIncident(incident1);
        incidentRepository.addIncident(incident2);
        incidentRepository.addIncident(incident3);

        incidentRepository.getIncidents().forEach(incident -> {
            System.out.print(incident.getId() + " ");
            try {
                technicianAssignmentService.assignTechnician(incident);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        var incidentReportService = context.getBean(IncidentReportService.class);
        incidentReportService.generateReport();

        context.close();
    }
}
