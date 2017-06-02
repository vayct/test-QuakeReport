package com.example.android.quakereport;

/**
 * A class for holding all the relevant information about an Earthquake
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mURL;

    /**
     * Public constructor for the class
     *
     * @param magnitude is the magnitude of the earthquake
     * @param location  is the String that specify the city location
     * @param time      is the String that specify the date that happened
     */
    public Earthquake(double magnitude, String location, long time, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = time;
        mURL = url;
    }

    /**
     * @return the magnitude of this earthquake
     */
    public double getMagnitude() {
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
    public long getTime() {
        return mTimeInMilliseconds;
    }

    public String getURL() {
        return mURL;
    }
}
