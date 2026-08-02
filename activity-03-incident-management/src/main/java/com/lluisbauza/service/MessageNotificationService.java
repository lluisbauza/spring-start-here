package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import com.lluisbauza.model.Technician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("message")
public class MessageNotificationService implements NotificationService {

    @Override
    public void sendNotification(Incident incident, Technician technician) {
        System.out.println("> MESSAGE " + technician.getName() + " Technician has been assigned - Incident nº" + incident.getId());
    }

}
