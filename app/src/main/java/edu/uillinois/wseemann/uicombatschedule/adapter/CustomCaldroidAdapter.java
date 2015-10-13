package edu.uillinois.wseemann.uicombatschedule.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import java.util.HashMap;

import edu.uillinois.wseemann.uicombatschedule.R;
import edu.uillinois.wseemann.uicombatschedule.database.Database;
import edu.uillinois.wseemann.uicombatschedule.utils.Date;
import hirondelle.date4j.DateTime;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class CustomCaldroidAdapter extends CaldroidGridAdapter {

    private Context mContext;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            edu.uillinois.wseemann.uicombatschedule.utils.Date date = (edu.uillinois.wseemann.uicombatschedule.utils.Date) msg.obj;
            String info = date.getInfo();
            TextView tv = date.getView();

            if (info != null) {
                tv.setText(info);
                tv.setBackgroundResource(R.color.blue);
            }
        }
    };

    public CustomCaldroidAdapter(Context context, int month, int year,
                                       HashMap<String, Object> caldroidData,
                                       HashMap<String, Object> extraData) {
        super(context, month, year, caldroidData, extraData);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cellView = convertView;

        // For reuse
        if (convertView == null) {
            cellView = inflater.inflate(R.layout.custom_list_item, null);
            //cellView = inflater.inflate(android.R.layout.simple_list_item_2, null);
        }

        int topPadding = cellView.getPaddingTop();
        int leftPadding = cellView.getPaddingLeft();
        int bottomPadding = cellView.getPaddingBottom();
        int rightPadding = cellView.getPaddingRight();

        TextView tv1 = (TextView) cellView.findViewById(android.R.id.text1);
        TextView tv2 = (TextView) cellView.findViewById(android.R.id.text2);

        tv1.setTextColor(Color.BLACK);

        // Get dateTime of this cell
        DateTime dateTime = this.datetimeList.get(position);
        Resources resources = context.getResources();

        // Set color of the dates in previous / next month
        if (dateTime.getMonth() != month) {
            tv1.setTextColor(resources
                    .getColor(com.caldroid.R.color.caldroid_darker_gray));
        }

        boolean shouldResetDiabledView = false;
        boolean shouldResetSelectedView = false;

        // Customize for disabled dates and date outside min/max dates
        if ((minDateTime != null && dateTime.lt(minDateTime))
                || (maxDateTime != null && dateTime.gt(maxDateTime))
                || (disableDates != null && disableDates.indexOf(dateTime) != -1)) {

            tv1.setTextColor(CaldroidFragment.disabledTextColor);
            if (CaldroidFragment.disabledBackgroundDrawable == -1) {
                cellView.setBackgroundResource(com.caldroid.R.drawable.disable_cell);
            } else {
                cellView.setBackgroundResource(CaldroidFragment.disabledBackgroundDrawable);
            }

            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(com.caldroid.R.drawable.red_border_gray_bg);
            }

        } else {
            shouldResetDiabledView = true;
        }

        // Customize for selected dates
        if (selectedDates != null && selectedDates.indexOf(dateTime) != -1) {
            cellView.setBackgroundColor(resources
                    .getColor(com.caldroid.R.color.caldroid_sky_blue));

            tv1.setTextColor(Color.BLACK);

        } else {
            shouldResetSelectedView = true;
        }

        if (shouldResetDiabledView && shouldResetSelectedView) {
            // Customize for today
            if (dateTime.equals(getToday())) {
                cellView.setBackgroundResource(com.caldroid.R.drawable.red_border);
            } else {
                cellView.setBackgroundResource(com.caldroid.R.drawable.cell_bg);
            }
        }

        tv1.setText("" + dateTime.getDay());

        /*String info = getDateInfo(dateTime);

        if (info != null) {
            tv2.setText(info);
            tv2.setBackgroundResource(R.color.blue);
        }*/

        // Somehow after setBackgroundResource, the padding collapse.
        // This is to recover the padding
        cellView.setPadding(leftPadding, topPadding, rightPadding,
                bottomPadding);

        // Set custom color if required
        setCustomResources(dateTime, cellView, tv1);

        new DatabaseQuery(mHandler, dateTime, tv2).execute();

        return cellView;
    }

    private class DatabaseQuery extends AsyncTask<Void, Void, Void> {

        private Handler mHandler;
        private DateTime mDate;
        private TextView mView;

        public DatabaseQuery(Handler handler, DateTime date, TextView view) {
            mHandler = handler;
            mDate = date;
            mView = view;
        }

        @Override
        protected Void doInBackground(Void... v) {
            Date date = getDateInfo(mDate);
            date.setView(mView);
            Message msg = mHandler.obtainMessage();
            msg.obj = date;

            mHandler.sendMessage(msg);

            return null;
        }

        private edu.uillinois.wseemann.uicombatschedule.utils.Date getDateInfo(DateTime date) {
            String strDate = null;
            String info = null;

            int month = date.getMonth();
            int day = date.getDay();
            int year = date.getYear();

            String stringDate = month + "/" + day + "/" + year;

            Database database = new Database(mContext);
            SQLiteDatabase db = database.getReadableDatabase();

            Cursor cursor = db.query(Database.DATES_TABLE_NAME, null, Database.DATE + " = ?", new String[]{stringDate}, null, null, null);

            if (cursor.moveToNext()) {
                strDate = cursor.getString(cursor.getColumnIndex(Database.DATE));
                info = cursor.getString(cursor.getColumnIndex(Database.INFO));
            }

            cursor.close();

            db.close();
            database.close();

            return new edu.uillinois.wseemann.uicombatschedule.utils.Date(strDate, info);
        }
    }
}
