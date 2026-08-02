package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mail")
public class MailNotificationService implements NotificationService {

    @Override
    public void sendNotification(Incident incident) {
        System.out.println("> MAIL: Technician has been assigned - Incident nº" + incident.getId());
    }

}
