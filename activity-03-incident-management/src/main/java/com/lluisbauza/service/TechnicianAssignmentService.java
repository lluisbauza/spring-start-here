package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import com.lluisbauza.model.Technician;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianAssignmentService {

    private final List<Technician> technicians;

    public TechnicianAssignmentService(List<Technician> technicians) {
        this.technicians = technicians;
    }

    public void assignTechnician(Incident incident) throws Exception {
        for (Technician technician : technicians) {
            if (technician.getCategory() == incident.getCategory()) {
                if (technician.isAvailable()) {
                    incident.setTechnician(technician);
                    technician.setAvailable(false);
                    break;
                } else {
                    throw new Exception("No technicians available at the moment. Try in a few minutes.");
                }
            }
        }
    }
}
