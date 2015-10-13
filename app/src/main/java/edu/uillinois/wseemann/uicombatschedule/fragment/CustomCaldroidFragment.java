package edu.uillinois.wseemann.uicombatschedule.fragment;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import edu.uillinois.wseemann.uicombatschedule.adapter.CustomCaldroidAdapter;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class CustomCaldroidFragment extends CaldroidFragment {

    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {
        return new CustomCaldroidAdapter(getActivity(), month, year, getCaldroidData(), extraData);
    }

}