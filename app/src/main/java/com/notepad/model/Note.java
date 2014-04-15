package com.notepad.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.notepad.common.Util;

import java.util.List;

/**
 * Created by deezzel on 4/14/14.
 */
public class Note extends BaseModel {

    public static final String TABLE_NAME = "note";
    public static final String COL_ID = BaseModel.COL_ID;
    public static final String COL_CREATEDTIME = BaseModel.COL_CREATEDTIME;
    public static final String COL_MODIFIEDTIME = BaseModel.COL_MODIFIEDTIME;
    public static final String COL_CATEGORYID = "category_id";
    public static final String COL_TITLE = "title";
    public static final String COL_CONTENT = "content";
    public static final String COL_TYPE = "type";

    public static final String BASIC = "basic";
    public static final String CHECKLIST = "checklist";
    public static final String SNAPSHOT = "snapshot";

    private long categoryId;
    private String title;
    private String content;
    private String type;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CheckItem> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<CheckItem> checkList) {
        this.checkList = checkList;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    private List<CheckItem> checkList;
    private List<Attachment> attachments;

    static String getSql(){
        return Util.concat("CREATE TABLE ", TABLE_NAME, " (", BaseModel.getSql(),
                COL_CATEGORYID, " INTEGER ",
                COL_TITLE, " TEXT ",
                COL_CONTENT, " TEXT ",
                COL_TYPE, " TEXT ",");");
    }

    @Override
    long save(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        super.save(cv);
        cv.put(COL_CATEGORYID, categoryId);
        cv.put(COL_TITLE, title==null ? "" : title);
        cv.put(COL_CONTENT, content==null ? "" : content);
        cv.put(COL_TYPE, type==null ? BASIC : type);

        return db.insert(TABLE_NAME,null,cv);
    }

    @Override
    boolean update(SQLiteDatabase db) {
        return false;
    }
}
