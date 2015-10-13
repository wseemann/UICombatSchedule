package edu.uillinois.wseemann.uicombatschedule.loader;

/**
 * Created by wseemann on 10/10/15.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

import edu.uillinois.wseemann.uicombatschedule.database.Database;
import edu.uillinois.wseemann.uicombatschedule.utils.Date;

/**
 * A custom Loader that loads all of the installed applications.
 */
public class CalendarLoader extends AsyncTaskLoader<List<Date>> {
    // TODO fix this
    //final InterestingConfigChanges mLastConfig = new InterestingConfigChanges();

    private List<Date> mItems;

    public CalendarLoader(Context context, Bundle args) {
        super(context);
    }

    /**
     * This is where the bulk of our work is done.  This function is
     * called in a background thread and should generate a new set of
     * data to be published by the loader.
     */
    @Override public List<Date> loadInBackground() {
        List<Date> items = new ArrayList<Date>();

        Database database = new Database(getContext());
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.query(Database.DATES_TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String date = cursor.getString(cursor.getColumnIndex(Database.DATE));
            String info = cursor.getString(cursor.getColumnIndex(Database.INFO));

            items.add(new Date(date, info));
        }

        db.close();
        database.close();

        // Sort the list.
        //Collections.sort(entries, ALPHA_COMPARATOR);

        // Done!
        return items;
    }

    /**
     * Called when there is new data to deliver to the client.  The
     * super class will take care of delivering it; the implementation
     * here just adds a little more logic.
     */
    @Override public void deliverResult(List<Date> items) {
        if (items.size() == 0) {
            //Toast.makeText(getContext(),
            //		getContext().getString(R.string.error_message),
            //		Toast.LENGTH_SHORT).show();
        }

        if (isReset()) {
            // An async query came in while the loader is stopped.  We
            // don't need the result.
            if (items != null) {
                onReleaseResources(items);
            }
        }
        List<Date> oldItems = items;
        mItems = items;

        if (isStarted()) {
            // If the Loader is currently started, we can immediately
            // deliver its results.
            super.deliverResult(items);
        }

        // At this point we can release the resources associated with
        // 'oldItems' if needed; now that the new result is delivered we
        // know that it is no longer in use.
        if (oldItems != null) {
            onReleaseResources(oldItems);
        }
    }

    /**
     * Handles a request to start the Loader.
     */
    @Override protected void onStartLoading() {
        if (mItems != null) {
            // If we currently have a result available, deliver it
            // immediately.
            deliverResult(mItems);
        }

        // TODO fix this
        if (takeContentChanged() || mItems == null) { //|| configChange) {
            // If the data has changed since the last time it was loaded
            // or is not currently available, start a load.
            forceLoad();
        }
    }

    /**
     * Handles a request to stop the Loader.
     */
    @Override protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    /**
     * Handles a request to cancel a load.
     */
    @Override public void onCanceled(List<Date> items) {
        super.onCanceled(items);

        // At this point we can release the resources associated with 'items'
        // if needed.
        onReleaseResources(items);
    }

    /**
     * Handles a request to completely reset the Loader.
     */
    @Override protected void onReset() {
        super.onReset();

        // Ensure the loader is stopped
        onStopLoading();

        // At this point we can release the resources associated with 'items'
        // if needed.
        if (mItems != null) {
            onReleaseResources(mItems);
            mItems = null;
        }
    }

    /**
     * Helper function to take care of releasing resources associated
     * with an actively loaded data set.
     */
    protected void onReleaseResources(List<Date> items) {
        // For a simple List<> there is nothing to do.  For something
        // like a Cursor, we would close it here.
    }
}