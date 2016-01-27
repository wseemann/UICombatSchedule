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

    private static final int DATABASE_VERSION = 2;
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

        buildValues(db, "1/19/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "1/20/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "1/21/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "1/23/2016", "Taekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "1/24/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "1/25/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "1/26/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "1/27/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "1/28/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "1/30/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "1/31/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "2/1/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "2/2/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/3/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "2/4/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/6/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "2/7/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "2/8/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "2/9/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/10/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "2/11/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/13/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "2/14/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "2/15/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "2/16/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/17/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "2/18/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/20/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "2/21/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "2/22/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "2/23/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/24/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "2/25/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "2/27/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "2/28/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "2/29/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "3/1/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/2/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "3/3/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/5/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "3/6/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "3/7/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "3/8/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/9/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "3/10/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/12/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "3/13/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "3/14/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "3/15/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/16/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "3/17/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/19/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "3/20/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "3/21/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "3/22/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/23/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "3/24/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/26/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "3/27/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "3/28/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "3/29/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "3/30/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "3/31/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/2/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "4/3/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "4/4/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "4/5/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/6/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "4/7/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/9/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "4/10/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "4/11/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "4/12/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/13/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "4/14/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/16/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "4/17/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "4/18/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "4/19/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/20/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "4/21/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/23/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "4/24/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "4/25/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "4/26/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/27/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
        buildValues(db, "4/28/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "4/30/2016", "Shotokan: 10:30-11:45am\nTaekwondo: 12-2pm\nGoshin Jiu-Jitsu: 2-4pm");
        buildValues(db, "5/1/2016", "Students: 1-3pm\nIllini Judo: 3-5pm\nGoshin Jiu-Jitsu: 5-7pm");
        buildValues(db, "5/2/2016", "Taekwondo: 6-7:30pm\nShotokan: 8-9pm");

        buildValues(db, "5/3/2016", "Club unknown: 6:30-8:30pm\nClub unknown: 8:30-10:30pm");
        buildValues(db, "5/4/2016", "Taekwondo: 5:30-7pm\nGoshin Jiu-Jitsu: 7-9pm");
    }
}