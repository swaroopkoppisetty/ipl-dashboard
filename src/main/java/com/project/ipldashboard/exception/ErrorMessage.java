package com.project.ipldashboard.exception;

import java.util.Date;

public class ErrorMessage {
    private String status;
    private String message;
    private Date date;
    private String description;

    public ErrorMessage(String status, String message, Date date, String description) {
        this.status = status;
        this.message = message;
        this.date = date;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
