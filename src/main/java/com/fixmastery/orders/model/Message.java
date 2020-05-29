package com.fixmastery.orders.model;

import java.time.LocalDateTime;

public class Message {
    private long id;
    private LocalDateTime dateTimeStamp;
    private String system;
    private String messageType;
    private String message;

    public Message(long id, LocalDateTime dateTimeStamp, String system, String messageType, String message) {
        this.id = id;
        this.dateTimeStamp = dateTimeStamp;
        this.system = system;
        this.messageType = messageType;
        this.message = message;
    }

    public String appendMessage(String addition) {
        if(!addition.equals("") || addition.length() > 3) {
            this.message += "\n" + addition;
        }

        return this.message;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    public String getSystem() {
        return system;
    }

    public String getMessage() {
        return message;
    }

    public String getFullMessage() {
        return system + ": [" + dateTimeStamp + "] " + message;
    }
}
