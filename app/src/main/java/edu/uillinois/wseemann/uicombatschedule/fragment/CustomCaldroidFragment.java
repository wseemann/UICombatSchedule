package edu.uillinois.wseemann.uicombatschedule.fragment;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import edu.uillinois.wseemann.uicombatschedule.R;
import edu.uillinois.wseemann.uicombatschedule.adapter.CustomCaldroidAdapter;
import edu.uillinois.wseemann.uicombatschedule.utils.Date;

import edu.uillinois.wseemann.uicombatschedule.loader.CalendarLoader;

import android.support.v4.content.Loader;
import java.text.DateFormat;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class CustomCaldroidFragment extends CaldroidFragment implements LoaderManager.LoaderCallbacks<List<Date>>  {

    private CustomCaldroidAdapter mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            getLoaderManager().initLoader(0, null, this);
        } else {
            getLoaderManager().restartLoader(0, null, this);
        }
    }

    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {
        mAdapter = new CustomCaldroidAdapter(getActivity(), month, year, getCaldroidData(), extraData);
        return mAdapter;
    }

    @Override
    public Loader<List<Date>> onCreateLoader(int arg0, Bundle arg1) {
        return new CalendarLoader(getActivity(), null);
    }

    @Override
    public void onLoadFinished(Loader<List<edu.uillinois.wseemann.uicombatschedule.utils.Date>> arg0, List<edu.uillinois.wseemann.uicombatschedule.utils.Date> items) {
        extraData.clear();

        for (int i = 0; i < items.size(); i++) {
            extraData.put(items.get(i).getDate(), items.get(i));
        }

        for (int i = 0; i < items.size(); i++) {
            Date dat = items.get(i);

            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            try {
                java.util.Date date = format.parse(dat.getDate());

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                setSelectedDate(cal.getTime());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        refreshView();

        if (isResumed()) {
            //setListShown(true);
        } else {
            //setListShownNoAnimation(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<edu.uillinois.wseemann.uicombatschedule.utils.Date>> arg0) {
        // TODO Auto-generated method stub

    }
}