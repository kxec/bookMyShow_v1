package com.example.bookmyshow_v1.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Invalid UserId , User not Found Please Register the User first");
    }
}
