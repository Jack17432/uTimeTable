package com.temprist.utimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBAssignmentTable extends SQLiteOpenHelper {

    public static final String ASSIGNMENT_TABLE = "ASSIGNMENT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ASSIGNMENT_NAME = "ASSIGNMENT_NAME";
    public static final String COLUMN_ASSIGNMENT_DESCRIPTION = "ASSIGNMENT_DESCRIPTION";
    public static final String COLUMN_ASSIGNMENT_DATE = "ASSIGNMENT_DATE";

    public DBAssignmentTable(@Nullable Context context) {
        super(context, "assignment.db", null, 1);
    }

    //Creates TABLE for assignments, This is currently only supporting NAME of assignment and description But this needs to be expended in the future.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ASSIGNMENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_ASSIGNMENT_NAME + " TEXT, " + COLUMN_ASSIGNMENT_DESCRIPTION + " TEXT, " + COLUMN_ASSIGNMENT_DATE + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUserAssignment(UserAssignment userAssignment){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ASSIGNMENT_NAME, userAssignment.getAssignmentName());
        cv.put(COLUMN_ASSIGNMENT_DESCRIPTION, userAssignment.getAssignmentDescription());
        cv.put(COLUMN_ASSIGNMENT_DATE, userAssignment.getAssignmentDate());

        long insert = db.insert(ASSIGNMENT_TABLE, null, cv);

        return insert != -1;
    }

    public boolean deleteUserAssignment(UserAssignment userAssignment){
        SQLiteDatabase database = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ASSIGNMENT_TABLE + " WHERE " + COLUMN_ID + " = " + userAssignment.getId();
        Cursor cursor = database.rawQuery(queryString, null);

        return !cursor.moveToFirst();
    }

    public List<UserAssignment> getAllAssignments(){
        List<UserAssignment> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + ASSIGNMENT_TABLE + " ORDER BY " + COLUMN_ASSIGNMENT_DATE + " ASC";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do{
                int assignmentID = cursor.getInt(0);
                String assignmentName = cursor.getString(1);
                String assignmentDescription = cursor.getString(2);
                String assignmentDate = cursor.getString(3);

                UserAssignment userAssignment = new UserAssignment(assignmentID, assignmentName, assignmentDescription, assignmentDate);
                returnList.add(userAssignment);
            }while (cursor.moveToNext());
        }

        //Closes Database and cursor as to not take up usage of database.
        database.close();
        cursor.close();

        return returnList;
    }
}
