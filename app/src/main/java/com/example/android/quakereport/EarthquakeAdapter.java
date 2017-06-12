package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * An {@link EarthquakeAdapter} knows how to create a list item layout for each earthquake
 * in the data source
 *
 * These list item layout will be provided to an adapter to view like ListView
 * to be displayed to the user
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    private static String LOCATION_STRING_SEPARATOR = " of ";

    /**
     * Constructor for the EarthquakeAdapter
     * @param context of the app
     * @param earthquakes is the list of earthquakes with all the relevant information
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0,  earthquakes);
    }


    /**
     * Returns a list item view that displays information about the earthquakes at a given position in
     * the list of earthquakes
     */
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        //Check if there is existing list item view (called convertView) that we can reuse,
        //else, inflate a new list item layout
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_iten, parent, false);
        }

        //Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);

        //Find the TextView with view ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

        //Format the magnitude to be one decimal places
        double magnitude = currentEarthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String stringMagnitude = formatter.format(magnitude);


        //Display the magnitude of the current earthquake in that TextView
        magnitudeTextView.setText(stringMagnitude);

        //set the proper background color on the magnitude circle.
        //fetch the background from the TextView, which is a GradientDrawable

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        //Get the appropriate background color based on the current magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);



        //Split the location string into 2 two strings
        //check if there is the string " of "
        //otherwise, will use the String "Near to" for the offset location
        String stringLocation = currentEarthquake.getLocation();
        String offsetLocation;
        String primaryLocation;
        if(stringLocation.contains(LOCATION_STRING_SEPARATOR) == true) {

            String[] splitString = stringLocation.split(LOCATION_STRING_SEPARATOR);
            offsetLocation = splitString[0] + LOCATION_STRING_SEPARATOR;
            primaryLocation = splitString[1];
        }
        else{
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = stringLocation;

        }

        //Find the 2 textViews that we can set to
        //Display the location of the current earthquake in that TextView
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.offset_location);
        offsetTextView.setText(offsetLocation);

        TextView primaryTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryTextView.setText(primaryLocation);






        //Find the TextView with view ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        //Find the TextView with view ID time
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);


        //Convert the time to Date object
        Date dateObject = new Date(currentEarthquake.getTime());



        //Format the date as "Jan 23,1992"
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd,yyyy");
        String toDate = dateFormat.format(dateObject);
        dateTextView.setText(toDate);

        //Format the time as "3:21 pm"
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String toTime = timeFormat.format(dateObject);
        timeTextView.setText(toTime);

        return listItemView;

    }

    private int getMagnitudeColor(double mag) {

        int magnitudeColor;

        int magnitudeFloor = (int) Math.floor(mag);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;
        }


        return ContextCompat.getColor(getContext() , magnitudeColor);

    }
}
