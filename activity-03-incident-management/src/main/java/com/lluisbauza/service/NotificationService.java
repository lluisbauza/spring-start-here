package com.lluisbauza.service;

import com.lluisbauza.model.Incident;

public interface NotificationService {

    void sendNotification(Incident incident);

}
