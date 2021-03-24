package com.javatech.com.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ErrorResponse {

    private Date timestamp;
    private String status;
    private String message;
    private String details;

    /**
     * Instantiates a new Error response.
     *
     * @param timestamp the timestamp
     * @param status    the status
     * @param message   the message
     * @param details   the details
     */
    public ErrorResponse(Date timestamp, String status, String message, String details) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.details = details;
    }
}