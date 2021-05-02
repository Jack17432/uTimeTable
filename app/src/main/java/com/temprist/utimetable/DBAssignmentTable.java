package com.temprist.utimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBAssignmentTable extends SQLiteOpenHelper {

    public static final String ASSIGNMENT_TABLE = "ASSIGNMENT_TABLE";
    public static final String COLUMN_ASSIGNMENT_NAME = "ASSIGNMENT_NAME";
    public static final String COLUMN_ASSIGNMENT_PROGRESS = "ASSIGNMENT_PROGRESS";
    public static final String COLUMN_ASSIGNMENT_TIME = "ASSIGNMENT_TIME";
    public static final String COLUMN_ASSIGNMENT_DATE = "ASSIGNMENT_DATE";
    public static final String COLUMN_ASSIGNMENT_CLASS = "ASSIGNMENT_CLASS";
    public static final String COLUMN_ASSIGNMENT_DESCRIPTION = "ASSIGNMENT_DESCRIPTION";
    public static final String COLUMN_ID = "ID";

    public DBAssignmentTable(@Nullable Context context) {
        super(context, "class.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ASSIGNMENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ASSIGNMENT_NAME + " TEXT, " + COLUMN_ASSIGNMENT_PROGRESS + " INT, " + COLUMN_ASSIGNMENT_TIME + " TEXT, " + COLUMN_ASSIGNMENT_DATE + " TEXT, " + COLUMN_ASSIGNMENT_CLASS + " TEXT, " + COLUMN_ASSIGNMENT_DESCRIPTION + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUserAssignment(UserAssignment userAssignment){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ASSIGNMENT_NAME, userAssignment.getNameOfAssignment());
        cv.put(COLUMN_ASSIGNMENT_DESCRIPTION, userAssignment.getProgressOfAssignment());
        cv.put(COLUMN_ASSIGNMENT_TIME, userAssignment.getTimeDueOfAssignment());
        cv.put(COLUMN_ASSIGNMENT_DATE, userAssignment.getDateDueOfAssignment());
        cv.put(COLUMN_ASSIGNMENT_CLASS, userAssignment.getClassOfAssignment());
        cv.put(COLUMN_ASSIGNMENT_DESCRIPTION, userAssignment.getDescriptionOfAssignment());

        long insert = db.insert(ASSIGNMENT_TABLE, null, cv);

        if (insert == -1) return false;
        else return true;
    }

    public boolean deleteUserAssignment(UserAssignment userAssignment) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ASSIGNMENT_TABLE + " WHERE " + COLUMN_ID + " = " + userAssignment.getId();
        Cursor cursor = db.rawQuery(queryString, null);

        return !cursor.moveToFirst();
    }
}
