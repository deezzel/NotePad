package com.notepad.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.notepad.app.NotePad;
import com.notepad.model.Attachment;
import com.notepad.model.Category;
import com.notepad.model.CheckItem;
import com.notepad.model.Note;

/**
 * Created by deezzel on 4/14/14.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "notepad";
    public static final int DB_VERSION = 1;

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Category.getSql());
        db.execSQL(Note.getSql());
        db.execSQL(Attachment.getSql());
        db.execSQL(CheckItem.getSql());

        populateData(db);
    }

    private void populateData(SQLiteDatabase db) {
        Category category = new Category();
        category.setName("Public");
        long categoryId = category.save(db);
        NotePad.PUBLIC_CATEGORYID = categoryId;

        Note note = new Note();
        note.setCategoryId(categoryId);
        note.setTitle("Read Me");
        note.setType(Note.BASIC);
        note.setContent("Please set password in Settings page to restrict access to locked items. \\n\\nRemember to long press an item in Browse/Manage tab to see more options.");
        note.save(db);

        category.reset();
        category.setName("Personal");
        category.setIsLocked(true);
        categoryId = category.save(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + Category.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Attachment.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CheckItem.TABLE_NAME);

        onCreate(db);
    }
}
