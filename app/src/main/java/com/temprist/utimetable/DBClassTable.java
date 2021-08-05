package com.temprist.utimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBClassTable extends SQLiteOpenHelper {

    public static final String CLASS_TABLE = "CLASS_TABLE";
    public static final String COLUMN_CLASS_NAME = "CLASS_NAME";
    public static final String COLUMN_TEACHER_NAME = "TEACHER_NAME";
    public static final String COLUMN_TEACHER_EMAIL = "TEACHER_EMAIL";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_DAY_1 = "DAY_1";
    public static final String COLUMN_DAY_2 = "DAY_2";
    public static final String COLUMN_DAY_3 = "DAY_3";
    public static final String COLUMN_DAY_4 = "DAY_4";
    public static final String COLUMN_DAY_5 = "DAY_5";
    public static final String COLUMN_DAY_6 = "DAY_6";
    public static final String COLUMN_DAY_7 = "DAY_7";
    public static final String COLUMN_DAYTIME_1 = "DAYTIME_1";
    public static final String COLUMN_DAYTIME_2 = "DAYTIME_2";
    public static final String COLUMN_DAYTIME_3 = "DAYTIME_3";
    public static final String COLUMN_DAYTIME_4 = "DAYTIME_4";
    public static final String COLUMN_DAYTIME_5 = "DAYTIME_5";
    public static final String COLUMN_DAYTIME_6 = "DAYTIME_6";
    public static final String COLUMN_DAYTIME_7 = "DAYTIME_7";


    public DBClassTable(@Nullable Context context) {
        super(context, "class.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CLASS_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CLASS_NAME + " TEXT, " +
                COLUMN_TEACHER_NAME + " TEXT, " +
                COLUMN_TEACHER_EMAIL + " TEXT, " +
                COLUMN_DAY_1 + " INTEGER, " +
                COLUMN_DAY_2 + " INTEGER, " +
                COLUMN_DAY_3 + " INTEGER, " +
                COLUMN_DAY_4 + " INTEGER, " +
                COLUMN_DAY_5 + " INTEGER, " +
                COLUMN_DAY_6 + " INTEGER, " +
                COLUMN_DAY_7 + " INTEGER, " +
                COLUMN_DAYTIME_1 + " TEXT, " +
                COLUMN_DAYTIME_2 + " TEXT, " +
                COLUMN_DAYTIME_3 + " TEXT, " +
                COLUMN_DAYTIME_4 + " TEXT, " +
                COLUMN_DAYTIME_5 + " TEXT, " +
                COLUMN_DAYTIME_6 + " TEXT, " +
                COLUMN_DAYTIME_7 + " TEXT)";

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
        cv.put(COLUMN_DAY_1, userClass.getDay1());
        cv.put(COLUMN_DAY_2, userClass.getDay2());
        cv.put(COLUMN_DAY_3, userClass.getDay3());
        cv.put(COLUMN_DAY_4, userClass.getDay4());
        cv.put(COLUMN_DAY_5, userClass.getDay5());
        cv.put(COLUMN_DAY_6, userClass.getDay6());
        cv.put(COLUMN_DAY_7, userClass.getDay7());
        cv.put(COLUMN_DAYTIME_1, userClass.getDay1Time());
        cv.put(COLUMN_DAYTIME_2, userClass.getDay2Time());
        cv.put(COLUMN_DAYTIME_3, userClass.getDay3Time());
        cv.put(COLUMN_DAYTIME_4, userClass.getDay4Time());
        cv.put(COLUMN_DAYTIME_5, userClass.getDay5Time());
        cv.put(COLUMN_DAYTIME_6, userClass.getDay6Time());
        cv.put(COLUMN_DAYTIME_7, userClass.getDay7Time());

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
                int day1 = cursor.getInt(4);
                int day2 = cursor.getInt(5);
                int day3 = cursor.getInt(6);
                int day4 = cursor.getInt(7);
                int day5 = cursor.getInt(8);
                int day6 = cursor.getInt(9);
                int day7 = cursor.getInt(10);
                String dayTime1 = cursor.getString(11);
                String dayTime2 = cursor.getString(12);
                String dayTime3 = cursor.getString(13);
                String dayTime4 = cursor.getString(14);
                String dayTime5 = cursor.getString(15);
                String dayTime6 = cursor.getString(16);
                String dayTime7 = cursor.getString(17);

                UserClass userClass = new UserClass(classID,
                        className,
                        classTeacherName,
                        classTeacherEmail,
                        day1,
                        day2,
                        day3,
                        day4,
                        day5,
                        day6,
                        day7,
                        dayTime1,
                        dayTime2,
                        dayTime3,
                        dayTime4,
                        dayTime5,
                        dayTime6,
                        dayTime7);
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

    public List<UserClass> getAllClassesOnSetDay(Integer day){
        List<UserClass> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CLASS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {

            do {
                if (cursor.getInt(day + 3) == 1) {
                    int classID = cursor.getInt(0);
                    String className = cursor.getString(1);
                    String classTeacherName = cursor.getString(2);
                    String classTeacherEmail = cursor.getString(3);
                    int day1 = cursor.getInt(4);
                    int day2 = cursor.getInt(5);
                    int day3 = cursor.getInt(6);
                    int day4 = cursor.getInt(7);
                    int day5 = cursor.getInt(8);
                    int day6 = cursor.getInt(9);
                    int day7 = cursor.getInt(10);
                    String dayTime1 = cursor.getString(11);
                    String dayTime2 = cursor.getString(12);
                    String dayTime3 = cursor.getString(13);
                    String dayTime4 = cursor.getString(14);
                    String dayTime5 = cursor.getString(15);
                    String dayTime6 = cursor.getString(16);
                    String dayTime7 = cursor.getString(17);

                    UserClass userClass = new UserClass(classID,
                            className,
                            classTeacherName,
                            classTeacherEmail,
                            day1,
                            day2,
                            day3,
                            day4,
                            day5,
                            day6,
                            day7,
                            dayTime1,
                            dayTime2,
                            dayTime3,
                            dayTime4,
                            dayTime5,
                            dayTime6,
                            dayTime7);
                    returnList.add(userClass);
                }
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

    public boolean deleteUserClass(Integer ID){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CLASS_TABLE + " WHERE " + COLUMN_ID + " = " + ID;
        Cursor cursor = db.rawQuery(queryString, null);

        return !cursor.moveToFirst();
    }

}
