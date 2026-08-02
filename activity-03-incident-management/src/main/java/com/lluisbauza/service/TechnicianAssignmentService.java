package com.lluisbauza.service;

import com.lluisbauza.enums.Priority;
import com.lluisbauza.enums.State;
import com.lluisbauza.model.Incident;
import com.lluisbauza.model.Technician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianAssignmentService {

    private final List<Technician> technicians;
    private final NotificationService messageNotificationService;
    private final NotificationService mailNotificationService;

    public TechnicianAssignmentService(
            NotificationService messageNotificationService,
            @Qualifier("mail") NotificationService mailNotificationService,
            List<Technician> technicians) {
        this.messageNotificationService = messageNotificationService;
        this.mailNotificationService = mailNotificationService;
        this.technicians = technicians;
    }

    public void assignTechnician(Incident incident) throws Exception {
        for (Technician technician : technicians) {
            if (technician.getCategory() == incident.getCategory()) {
                if (technician.isAvailable()) {
                    incident.setTechnician(technician);
                    technician.setAvailable(false);
                    incident.setState(State.ASSIGNED);

                    if (incident.getPriority() == Priority.HIGH) {
                        mailNotificationService.sendNotification(incident);
                    } else {
                        messageNotificationService.sendNotification(incident);
                    }
                    break;

                } else {
                    throw new Exception("No technicians available at the moment. Try in a few minutes.");
                }
            }
        }
    }
}
