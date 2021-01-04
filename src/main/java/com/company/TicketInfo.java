package com.company;

public class TicketInfo {
    private String firstName;
    private String lastName;
    private String takeOffCity;
    private String arrivalCity;

    public TicketInfo(String firstName, String lastName, String takeOffCity, String arrivalCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.takeOffCity = takeOffCity;
        this.arrivalCity = arrivalCity;
    }
    public TicketInfo(){}
    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getTakeOffCity() {

        return takeOffCity;
    }

    public void setTakeOffCity(String takeOffCity) {

        this.takeOffCity = takeOffCity;
    }

    public String getArrivalCity() {

        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {

        this.arrivalCity = arrivalCity;
    }

    @Override
    public String toString() {
        return "PASSENGER: " + firstName + " " + lastName + " |  FLY ROUTE: from: " + takeOffCity + " to " + arrivalCity;
    }
}