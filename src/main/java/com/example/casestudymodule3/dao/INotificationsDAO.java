package com.example.casestudymodule3.dao;

import com.example.casestudymodule3.model.Notifications;

import java.util.List;

public interface INotificationsDAO {
    List<Notifications> getAllNotifications();
    Notifications findByID(int id);
    boolean addNewNotifications(Notifications notifications);
    boolean updateNotifications(Notifications notifications);
    boolean removeNotifications(int id);
}
