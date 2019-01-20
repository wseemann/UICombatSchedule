package edu.uillinois.wseemann.uicombatschedule.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class Database extends SQLiteOpenHelper {

    private static final String TAG = Database.class.getName();

    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "dates";
    public static final String DATES_TABLE_NAME = "dates";

    public static final String CLUB = "club";
    public static final String DATE = "date";
    public static final String INFO = "info";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";

    private static final String LINKS_TABLE_CREATE =
            "CREATE TABLE " + DATES_TABLE_NAME + " ("
                    + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + CLUB + " TEXT,"
                    + DATE + " TEXT,"
                    + INFO + " INFO,"
                    + START_TIME + " TEXT,"
                    + END_TIME + " TEXT);";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LINKS_TABLE_CREATE);
        insertDates(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.delete(DATES_TABLE_NAME, null, null);
        insertDates(db);
    }

    private void buildValues(SQLiteDatabase db, String date, String info) {
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(INFO, info);

        db.insert(DATES_TABLE_NAME, null, values);
    }

    private void insertDates(SQLiteDatabase db) {

        //buildValues(db, "9/2/2015", "");
        List<String> schedule = Arrays.asList(
                "MMA: 3-4pm\n",

                "empty",

                "Brazilian Jiu Jitsu: 5-6:30pm\nJudo: 6:30-8:30pm",

                "Taekwondo: 6-7:30pm\nGoshin Jitsu: 7:30-9:30pm",

                "Judo: 6:30-8:30pm\nShotokan Karate: 8:30-10:30pm",

                "empty",

                "Shotokan Karate: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm\nBrazilian Jiu Jitsu: 4-5:30pm");

        Date startDate;
        Date endDate;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US); //yyyy-MM-dd 2017-02-07
        Calendar calendar = Calendar.getInstance();

        try {
            calendar.setTime(sdf.parse("05/01/2019"));
            endDate = calendar.getTime();

            calendar.setTime(sdf.parse("01/20/2019"));
            startDate = calendar.getTime();

            Date currentDate = startDate;

            Log.d(TAG, startDate.toString());
            Log.d(TAG, endDate.toString());

            int index = 0;

            while (currentDate.before(endDate)) {
                Log.d(TAG, currentDate.toString());

                SimpleDateFormat sdf1 = new SimpleDateFormat("M/d/yyyy");
                String stringDate = sdf1.format(calendar.getTime());

                Log.d(TAG, "Inserted: " + stringDate + " " + schedule.get(index));

                if (!schedule.get(index).equals("empty")) {
                    buildValues(db, stringDate, schedule.get(index));
                }

                // add a day, increment schedule counter
                calendar.add(Calendar.DAY_OF_MONTH, 1); // number of days to add, can also use Calendar.DAY_OF_MONTH in place of Calendar.DATE
                currentDate = calendar.getTime();

                if (++index >= schedule.size()) {
                    index = 0;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}