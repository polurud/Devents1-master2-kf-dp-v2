package com.dartmouth.kd.devents;

/**
 * Based on MyRuns DataLoader
 *
 * Created by kathrynflattum on 2/25/18.
 */

import java.util.ArrayList;
import android.content.Context;
import android.content.AsyncTaskLoader;
import android.util.Log;


public class DataLoader extends AsyncTaskLoader<ArrayList<CampusEvent>> {
    public Context mContext;
    public DataLoader(Context context) {
        super(context);
        mContext = context;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<CampusEvent> loadInBackground() {
        Log.d(Globals.TAGG,"Started");
        CampusEventDbHelper mCampusEventDbHelper = new CampusEventDbHelper(mContext);
        ArrayList<CampusEvent> eventsList = mCampusEventDbHelper
                .fetchEvents();
        Log.d(Globals.TAGG,"Finished");

        return eventsList;
    }
}