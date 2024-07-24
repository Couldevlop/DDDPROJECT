package com.openlab.edition.domaine.notification.model;

import com.openlab.edition.domaine.notification.NotificationProvider;

import java.time.LocalDate;

public class Notification {
    private Long idNotification;
    private String content;
    private LocalDate date;
    private NotificationProvider notificationProvider;


    private Notification(NotificationBuilder build) {
        this.idNotification = build.idNotification;
        this.content = build.content;
        this.date = build.date;
        this.notificationProvider = build.notificationProvider;
    }


    public static class NotificationBuilder{
        private Long idNotification;
        private String content;
        private LocalDate date;
        private NotificationProvider notificationProvider;

        public NotificationBuilder idNotification(long idNotification){
            this.idNotification = idNotification;
            return this;
        }


        public NotificationBuilder content(String content){
            this.content = content;
            return this;
        }

        public NotificationBuilder date(LocalDate date){
            this.date = date;
            return this;
        }


        public NotificationBuilder notificationProvider(NotificationProvider notificationProvider){
            this.notificationProvider = notificationProvider;
            return this;
        }


        public Notification build(){
            return new Notification(this);
        }
    }


    public Long getIdNotification() {
        return idNotification;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    public NotificationProvider getNotificationProvider() {
        return notificationProvider;
    }
}
