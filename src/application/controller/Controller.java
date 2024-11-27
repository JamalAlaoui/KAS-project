package application.controller;

import Storage.Storage;
import application.model.*;

import java.time.LocalDate;

public class Controller {
    public static Conferences createConference(String name, LocalDate startDate, LocalDate endDate, String location, double pricePrDay, String category, int numberOfSeats) {
        Conferences conference = new Conferences(name, startDate, endDate, location, pricePrDay, category, numberOfSeats);
        Storage.addConference(conference);
        return conference;
    }

    public static Hotel createHotel(String name, String address, int pricePrDay, String location) {
        Hotel hotel = new Hotel(name, address, pricePrDay, location);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static Enrollment createEnrollment(String name, String address, String country, String mobile, LocalDate startDate, LocalDate endDate, boolean isSpeaker, boolean hasCompanion, String companionName, boolean needsAccommodation, Hotel hotel) {
        Participant participant = new Participant(name, address, country, mobile);
        Companion companion = hasCompanion ? new Companion(companionName) : null;
        Enrollment enrollment = new Enrollment(false, hasCompanion, needsAccommodation, isSpeaker, startDate, endDate, participant, hotel);
        if (companion != null) {
            enrollment.setCompanion(companion);
        }
        Storage.addEnrollment(enrollment);
        return enrollment;
    }
}
