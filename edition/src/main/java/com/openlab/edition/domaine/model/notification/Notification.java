package com.openlab.edition.domaine.model.notification;

import java.time.LocalDate;

public class Notification {
    private Long idNotification;
    private String content;
    private LocalDate date;


    public Long getIdNotification() {
        return idNotification;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }
}
