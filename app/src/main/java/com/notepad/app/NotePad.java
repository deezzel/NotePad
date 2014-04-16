package com.notepad.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.notepad.db.DbHelper;

/**
 * Created by deezzel on 4/16/14.
 */
public class NotePad extends Application {
    public static DbHelper dbHelper;
    public static SQLiteDatabase db;
    public static SharedPreferences sp;

    public static final String HIDE_LOCKED = "hideLocked";
    public static final String PASSWORD = "password";
    public static final String LAST_AUTH = "lastAuth";
    public static final String DEFAULT_SORT = "defaultSort";
    public static final String DEFAULT_CATEGORY_OPT = "defaultCategoryOpt";
    public static final String TIME_OPTION = "timeOpt";
    public static final String DATE_FORMAT = "date_format";
    public static final String TIME_FORMAT = "time_format";

    public static final String DEFAULT_DATE_FORMAT = "MMM dd, yyyy";

    public static long PUBLIC_CATEGORYID = 1;
    public static long LASTCREATED_CATEGORYID;
    public static long LASTSELECTED_CATEGORYID;
}
