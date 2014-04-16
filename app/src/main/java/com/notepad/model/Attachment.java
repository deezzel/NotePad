package com.notepad.model;

import android.database.sqlite.SQLiteDatabase;

import com.notepad.common.Util;

/**
 * Created by deezzel on 4/14/14.
 */
public class Attachment extends AbstractModel {

    public static final String COL_ID = AbstractModel.COL_ID;
    public static final String COL_NOTEID = "note_id";
    public static final String COL_NAME = "name";
    public static final String COL_URI = "uri";
    public static final String TABLE_NAME = "attachment";

    private String name;
    private String uri;
    private long noteId;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public static String getSql(){
        return Util.concat("CREATE TABLE", TABLE_NAME, " (",
        COL_ID, " INTEGER PRIMARY KEY AUTOINCREMENT ",
                COL_NOTEID, " INTEGER ",
                COL_NAME, " TEXT ",
                COL_URI, " TEXT ", ");");
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
