package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import com.lluisbauza.model.Technician;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mail")
public class MailNotificationService implements NotificationService {

    @Override
    public void sendNotification(Incident incident, Technician technician) {
        System.out.println("> MAIL: " + technician.getName() + " has been assigned - Incident nº" + incident.getId());
    }

}
