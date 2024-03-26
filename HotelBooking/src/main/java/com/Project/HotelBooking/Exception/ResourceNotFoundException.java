package com.Project.HotelBooking.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String user, String fieldName, long Id) {
    }


    public ResourceNotFoundException(String user) {

    }
}
