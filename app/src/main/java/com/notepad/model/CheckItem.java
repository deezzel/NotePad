package com.notepad.model;

import android.database.sqlite.SQLiteDatabase;

import com.notepad.common.Util;

/**
 * Created by deezzel on 4/14/14.
 */
public class CheckItem extends AbstractModel {

    public static final String COL_ID = AbstractModel.COL_ID;
    public static final String COL_NOTEID = "noteId";
    public static final String COL_NAME = "name";
    public static final String COL_STATUS = "status";
    public static final String TABLE_NAME = "checkitem";

    public static String getSql(){
        return Util.concat("CREATE TABLE", TABLE_NAME, " (",
                COL_ID, " INTEGER PRIMARY KEY AUTOINCREMENT ",
                COL_NOTEID, " INTEGER ",
                COL_NAME, " TEXT ",
                COL_STATUS, " INTEGER ", ");");
    }

    @Override
    long save(SQLiteDatabase db) {
        return 0;
    }

    @Override
    boolean update(SQLiteDatabase db) {
        return false;
    }
}
