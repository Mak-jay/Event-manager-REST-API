package com.jay.EventManager.Exceptions;

public class EventNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public EventNotFoundException() {}

    public EventNotFoundException(String message) {
        super(message);
    }
}
