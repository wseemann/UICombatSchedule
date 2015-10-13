package edu.uillinois.wseemann.uicombatschedule.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.support.v4.app.DialogFragment;

/**
 * Created by wseemann on 10/10/15.
 */
public class GenericDialog extends DialogFragment {

    private String mTitleText = null;
    private String mDialogText = null;

    public static GenericDialog newInstance(String titleText, String dialogText) {
        GenericDialog frag = new GenericDialog();

        // Supply negative button text as an argument.
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
        builder.setMessage(Html.fromHtml(mDialogText));
        builder.setCancelable(true);
        builder.setNeutralButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}