package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;



public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /**Query URL */
    private String mURL;

    /**Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mURL = url;
    }

    /**
     * Running this on a background thread
     * @return the list of earthquakes from parsing the JSON object
     */
    @Override
    public List<Earthquake> loadInBackground() {

        return QueryUtils.fetchEarthquakeData(mURL);
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }


}
