package edu.uillinois.wseemann.uicombatschedule;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.support.v7.view.ActionMode;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Calendar;
import java.util.Date;

import edu.uillinois.wseemann.uicombatschedule.database.Database;
import edu.uillinois.wseemann.uicombatschedule.fragment.AboutDialog;
import edu.uillinois.wseemann.uicombatschedule.fragment.CustomCaldroidFragment;
import edu.uillinois.wseemann.uicombatschedule.fragment.GenericDialog;
import edu.uillinois.wseemann.uicombatschedule.fragment.ScheduleDialog;

public class MainActivity extends AppCompatActivity {

    private CustomCaldroidFragment caldroidFragment;
    private ActionMode mActionMode;

    private Date mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caldroidFragment = new CustomCaldroidFragment();

        if (savedInstanceState != null) {
            caldroidFragment.restoreStatesFromKey(savedInstanceState,
                    "CALDROID_SAVED_STATE");
        } else {
            Bundle args = new Bundle();
            Calendar cal = Calendar.getInstance();
            args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
            args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
            args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
            args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);

            caldroidFragment.setArguments(args);
        }

        // Attach to the activity
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(android.R.id.content, caldroidFragment);
        t.commit();

        // Setup listener
        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                String strDate = null;
                String info = null;

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int year = cal.get(Calendar.YEAR);

                String stringDate = month + "/" + day + "/" + year;

                Database database = new Database(MainActivity.this);
                SQLiteDatabase db = database.getReadableDatabase();

                Cursor cursor = db.query(Database.DATES_TABLE_NAME, null, Database.DATE + " = ?" , new String[] {stringDate}, null, null, null);

                if (cursor.moveToNext()) {
                    strDate = cursor.getString(cursor.getColumnIndex(Database.DATE));
                    info = cursor.getString(cursor.getColumnIndex(Database.INFO));
                }

                cursor.close();

                db.close();
                database.close();

                if (strDate != null && info != null) {
                    ScheduleDialog dialog = ScheduleDialog.newInstance(strDate, info);
                    dialog.show(getSupportFragmentManager(), "schedule");
                }
            }

            @Override
            public void onChangeMonth(int month, int year) {

            }

            @Override
            public void onLongClickDate(Date date, View view) {
                mDate = date;
                startActionMode();
            }

            @Override
            public void onCaldroidViewCreated() {

            }

        };

        caldroidFragment.setCaldroidListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            AboutDialog dialog = AboutDialog.newInstance(getString(R.string.action_info), getString(R.string.about_text));
            dialog.show(getSupportFragmentManager(), "about");
            return true;
        } else if (id == R.id.action_licenses) {
            GenericDialog dialog = GenericDialog.newInstance("", "This application uses <a href=\"https://github.com/roomorama/Caldroid\">Caldroid</a> released under the released under the <a href=\"https://opensource.org/licenses/MIT\">MIT License</a>.");
            dialog.show(getSupportFragmentManager(), getString(R.string.licenses));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (caldroidFragment != null) {
            caldroidFragment.saveStatesToKey(outState, "CALDROID_SAVED_STATE");
        }
    }

    private void startActionMode() {
        if (mActionMode != null) {
            return;
        }

        // Start the CAB using the ActionMode.Callback defined above
        MainActivity.this.startSupportActionMode(mActionModeCallback);
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_share:
                    shareCurrentItem(mDate);
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    private void shareCurrentItem(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);

        String stringDate = month + "/" + day + "/" + year;

        String text = "Combat Room Schedule for " + stringDate + ": \n";

        text = text + getDateInfo(date);

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private String getDateInfo(Date date) {
        String strDate = null;
        String info = null;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);

        String stringDate = month + "/" + day + "/" + year;

        Database database = new Database(MainActivity.this);
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.query(Database.DATES_TABLE_NAME, null, Database.DATE + " = ?" , new String[] {stringDate}, null, null, null);

        if (cursor.moveToNext()) {
            strDate = cursor.getString(cursor.getColumnIndex(Database.DATE));
            info = cursor.getString(cursor.getColumnIndex(Database.INFO));
        }

        cursor.close();

        db.close();
        database.close();

        return info;
    }
}
