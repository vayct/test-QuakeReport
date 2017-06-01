package com.example.android.quakereport;

/**
 * A class for holding all the relevant information about an Earthquake
 */

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

    /**
     * Public constructor for the class
     *
     * @param magnitude is the magnitude of the earthquake
     * @param location  is the String that specify the city location
     * @param date      is the String that specify the date that happened
     */
    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    /**
     * @return the magnitude of this earthquake
     */
    public String getMagnitude() {
        return mMagnitude;
    }

    /**
     * @return the location of this earthquake
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * @return return the date in readable format
     */
    public String getFormattedDate() {
        return mDate;
    }
}
