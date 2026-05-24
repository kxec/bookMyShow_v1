package com.example.bookmyshow_v1.exceptions;

public class SeatNotAvailableException extends Exception {
    public SeatNotAvailableException() {
        super("Sorry Some of the seats you Selected are not available");
    }
}
