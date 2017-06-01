package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * An {@link EarthquakeAdapter} knows how to create a list item layout for each earthquake
 * in the data source
 *
 * These list item layout will be provided to an adapter to view like ListView
 * to be displayed to the user
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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
        //Display the magnitude of the current earthquake in that TextView
        magnitudeTextView.setText(currentEarthquake.getMagnitude());



        //Find the TextView with view ID location
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        //Display the location of the current earthquake in that TextView
        locationTextView.setText(currentEarthquake.getLocation());

        //Find the TextView with view ID date
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        //Display the date of the current earthquake in that TextView
        dateTextView.setText(currentEarthquake.getFormattedDate());

        return listItemView;

    }
}
