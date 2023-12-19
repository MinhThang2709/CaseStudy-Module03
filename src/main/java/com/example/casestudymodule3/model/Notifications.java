package com.example.casestudymodule3.model;

public class Notifications {
    private int notificationsId;
    private String content;
    private String notificationTime;

    public Notifications(int notificationsId, String content, String notificationTime) {
        this.notificationsId = notificationsId;
        this.content = content;
        this.notificationTime = notificationTime;
    }

    public int getNotificationsId() {
        return notificationsId;
    }

    public void setNotificationsId(int notificationsId) {
        this.notificationsId = notificationsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}
