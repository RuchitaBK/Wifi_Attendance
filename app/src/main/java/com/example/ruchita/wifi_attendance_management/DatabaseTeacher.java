package com.example.ruchita.wifi_attendance_management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruchita on 21-10-2017.
 */

public class DatabaseTeacher extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Teacher_Data.db";
    public static final String TEACH_TABLE_NAME = "teacher_table";
    public static final String COLL_1 = "ID";
    public static final String COLL_2 = "NAME";
    public static final String COLL_3 = "SUBJECT";
    public static final String COLL_4 = "USERNAME";
    public static final String COLL_5 = "TEACH_PASSWORD";


    public DatabaseTeacher(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase teach_db) {
        teach_db.execSQL("CREATE TABLE teacher_table" + "(ID INTEGER PRIMARY KEY,NAME TEXT,SUBJECT TEXT,USERNAME TEXT,TEACH_PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase teach_db, int old, int newVersion) {

        teach_db.execSQL("DROP TABLE IF EXISTS teacher_table");
        onCreate(teach_db);
    }


    public boolean updateTeacherData(Integer id,String name,String subject,String user,String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLL_1,id);
        contentValues.put(COLL_2,name);
        contentValues.put(COLL_3,subject);
        contentValues.put(COLL_4,user);
        contentValues.put(COLL_5,pwd);
        db.update(TEACH_TABLE_NAME, contentValues, "ID = ?", new String[]{ id.toString() });
        return true;
    }

    public boolean insert_Teacher_Record(Integer id, String name, String sub,String username,String pwd) {
        SQLiteDatabase teach_db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("NAME", name);
        contentValues.put("SUBJECT", sub);
        contentValues.put("USERNAME",username);
        contentValues.put("TEACH_PASSWORD",pwd);


        long result = teach_db.insert("teacher_table",null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    int getRecord(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TEACH_TABLE_NAME, new String[] {COLL_1, COLL_2}, COLL_2 + "=? ",
                new String[] { String.valueOf(name) }, null, null, null, null);

        if (cursor.moveToFirst())
            return 1;
        else
            return 0;


    }


}