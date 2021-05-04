package com.temprist.utimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBClassTable extends SQLiteOpenHelper {

    public static final String CLASS_TABLE = "CLASS_TABLE";
    public static final String COLUMN_CLASS_NAME = "CLASS_NAME";
    public static final String COLUMN_TEACHER_NAME = "TEACHER_NAME";
    public static final String COLUMN_TEACHER_EMAIL = "TEACHER_EMAIL";
    public static final String COLUMN_ID = "ID";

    public DBClassTable(@Nullable Context context) {
        super(context, "class.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CLASS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CLASS_NAME + " TEXT, " + COLUMN_TEACHER_NAME + " TEXT, " + COLUMN_TEACHER_EMAIL + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUserClass(UserClass userClass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CLASS_NAME, userClass.getNameOfClass());
        cv.put(COLUMN_TEACHER_NAME, userClass.getNameOfTeacher());
        cv.put(COLUMN_TEACHER_EMAIL, userClass.getTeacherEmail());

        long insert = db.insert(CLASS_TABLE, null, cv);

        return insert != -1;
    }

    public List<UserClass> getAllClasses(){
        List<UserClass> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CLASS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do {
                int classID = cursor.getInt(0);
                String className = cursor.getString(1);
                String classTeacherName = cursor.getString(2);
                String classTeacherEmail = cursor.getString(3);

                UserClass userClass = new UserClass(classID, className, classTeacherName, classTeacherEmail);
                returnList.add(userClass);

            }while (cursor.moveToNext());
        }
        else {
            //No classes are added. This is so application dose not crash if there is no classes.
        }

        //Close cursor and db
        cursor.close();
        db.close();

        return returnList;
    }

    public boolean deleteUserClass(UserClass userClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CLASS_TABLE + " WHERE " + COLUMN_ID + " = " + userClass.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        return !cursor.moveToFirst();
    }
}
