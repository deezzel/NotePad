package com.notepad.model;

import android.database.sqlite.SQLiteDatabase;

import com.notepad.common.Util;

import java.util.List;

/**
 * Created by deezzel on 4/14/14.
 */
public class Category  extends BaseModel {

    public static final String TABLE_NAME = "category";
    public static final String COL_ID = BaseModel.COL_ID;
    public static final String COL_CREATEDTIME = BaseModel.COL_CREATEDTIME;
    public static final String COL_MODIFIEDTIME = BaseModel.COL_MODIFIEDTIME;
    public static final String COL_LOCKED = BaseModel.COL_LOCKED;
    public static final String COL_NAME = "name";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    private List<Note> notes;

    public static String getSql(){
        return Util.concat("CREATE TABLE ", TABLE_NAME,
                " (", BaseModel.getSql(), COL_NAME, " TEXT ", ");");
    }

    @Override
    public long save(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public boolean update(SQLiteDatabase db) {
        return false;
    }

    public void reset(){
        super.reset();
        name = null;
        notes = null;
    }
}
