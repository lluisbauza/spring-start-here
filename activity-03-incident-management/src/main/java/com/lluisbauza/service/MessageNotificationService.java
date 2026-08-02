package com.lluisbauza.service;

import com.lluisbauza.model.Incident;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("message")
public class MessageNotificationService implements NotificationService {

    @Override
    public void sendNotification(Incident incident) {
        System.out.println("> MESSAGE: Technician has been assigned - Incident nº" + incident.getId());
    }

}
