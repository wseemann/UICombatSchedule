package edu.uillinois.wseemann.uicombatschedule.fragment;

import android.app.Dialog;
import android.app.AlertDialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class ScheduleDialog extends DialogFragment {

    private String mTitleText = null;
    private String mDialogText = null;

    public static ScheduleDialog newInstance(String titleText, String dialogText) {
        ScheduleDialog frag = new ScheduleDialog();

        Bundle args = new Bundle();
        args.putString("title_text", titleText);
        args.putString("dialog_text", dialogText);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitleText = getArguments().getString("title_text");
        mDialogText = getArguments().getString("dialog_text");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(mTitleText);
        builder.setMessage(mDialogText)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}