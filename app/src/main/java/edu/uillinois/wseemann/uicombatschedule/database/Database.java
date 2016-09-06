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

    private static final int DATABASE_VERSION = 4;
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
        //buildValues(db, "10/2/2015", "");
        buildValues(db, "8/27/2016", "Taekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "8/28/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "8/29/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "8/30/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "8/31/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "9/1/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "9/3/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "9/4/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "9/5/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "9/6/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "9/7/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "9/8/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "9/10/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "9/11/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "9/12/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "9/13/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "9/14/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "9/15/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "9/17/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "9/18/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "9/19/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "9/20/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "9/21/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "9/22/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "9/24/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "9/25/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "9/26/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "9/27/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "9/28/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "9/29/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "10/1/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "10/2/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "10/3/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "10/4/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "10/5/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "10/6/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "10/8/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "10/9/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "10/10/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "10/11/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "10/12/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "10/13/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "10/15/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "10/16/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "10/17/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "10/18/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "10/19/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "10/20/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "10/22/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "10/23/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "10/24/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "10/25/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "10/26/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "10/27/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "10/29/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "10/30/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "10/31/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "11/1/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "11/2/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "11/3/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "11/5/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "11/6/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "11/7/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "11/8/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "11/9/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "11/10/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "11/12/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "11/13/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "11/14/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "11/15/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "11/16/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "11/17/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "11/19/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "11/20/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "11/21/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "11/22/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "11/23/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "11/24/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "11/26/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "11/27/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "11/28/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "11/29/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "11/30/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "12/1/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "12/3/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "12/4/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "12/5/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "12/6/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "12/7/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "12/8/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //

        buildValues(db, "12/10/2016", "Illini Shotokan Karate 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jitsu: 2-4pm");
        buildValues(db, "12/11/2016", "Goshin Jitsu: 5-7pm\nIllini Taekwondo 8-10pm");
        buildValues(db, "12/12/2016", "Taekwondo: 5:30-7pm");
        buildValues(db, "12/13/2016", "Illini Judo 6:30-8:30pm\nIllini Taekwondo 8:30-10:30pm");
        buildValues(db, "12/14/2016", "Taekwondo: 5:30-7pm\nGoshin Jitsu: 7-9pm");
        buildValues(db, "12/15/2016", "Illini Judo 6:30-8pm\nIllini Taekwondo 8-10pm");
        //
    }
}