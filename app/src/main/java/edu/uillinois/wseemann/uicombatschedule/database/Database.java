package edu.uillinois.wseemann.uicombatschedule.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by wfseeman on 10/2/2015.
 */
public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
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

        //buildValues(db, "10/2/2015", "");
        buildValues(db, "10/3/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "10/4/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "10/5/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "10/6/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "10/7/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "10/8/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "10/9/2015", "Taekwondo: 5-6pm");
        buildValues(db, "10/10/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "10/11/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "10/12/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "10/13/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "10/14/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "10/15/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "10/16/2015", "Taekwondo: 5-6pm");
        buildValues(db, "10/17/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "10/18/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "10/19/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "10/20/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "10/21/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "10/22/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "10/23/2015", "Taekwondo: 5-6pm");
        buildValues(db, "10/24/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "10/25/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "10/26/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "10/27/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "10/28/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "10/29/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "10/30/2015", "Taekwondo: 5-6pm");
        buildValues(db, "10/31/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "11/1/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "11/2/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "11/3/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "11/4/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "11/5/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "11/6/2015", "Taekwondo: 5-6pm");
        buildValues(db, "11/7/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "11/8/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "11/9/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "11/10/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "11/11/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "11/12/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "11/13/2015", "Taekwondo: 5-6pm");
        buildValues(db, "11/14/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "11/15/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "11/16/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "11/17/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "11/18/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "11/19/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "11/20/2015", "Taekwondo: 5-6pm");
        buildValues(db, "11/21/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "11/22/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "11/23/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "11/24/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "11/25/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "11/26/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "11/27/2015", "Taekwondo: 5-6pm");
        buildValues(db, "11/28/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "11/29/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "11/30/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "12/1/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "12/2/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "12/3/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");

        buildValues(db, "12/4/2015", "Taekwondo: 5-6pm");
        buildValues(db, "12/5/2015", "Club unknown 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "12/6/2015", "Illini Boxing 1-3pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "12/7/2015", "Taekwondo: 6-7:30pm\nIllinois s: 8-9pm");
        buildValues(db, "12/8/2015", "Club unknown 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "12/9/2015", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    private void buildValues(SQLiteDatabase db, String date, String info) {
        ContentValues values = new ContentValues();
        values.put(DATE, date);
        values.put(INFO, info);

        db.insert(DATES_TABLE_NAME, null, values);
    }
}