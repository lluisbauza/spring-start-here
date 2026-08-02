package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import com.lluisbauza.model.Technician;

public interface NotificationService {

    void sendNotification(Incident incident, Technician technician);

}
