package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class IncidentReportService {

    private List<Incident> incidents;

    public IncidentReportService(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public void generateReport(List<Incident> incidents) {
        System.out.println();
        System.out.println("LOG: IncidentReportService bean generated due to Lazy implementation.");
        System.out.println("--- Generating Incident Report ---");
        System.out.println("Number of Incidents: " + incidents.size());
    }
}
