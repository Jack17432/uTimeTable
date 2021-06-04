package com.temprist.utimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.Calendar;
import java.util.HashMap;

public class addClass extends AppCompatActivity {

    //String
    public String stringDebug = "DEBUG: ";

    //Referencing
    Button buttonAddClass;
    EditText editTextNameOfClass, editTextTeacherName, editTextTextEmailAddressOfTeacher;
    Chip day_1, day_2, day_3, day_4, day_5, day_6, day_7;
    TextView d1Start, d1End, d2Start, d2End, d3Start, d3End, d4Start, d4End, d5Start, d5End, d6Start, d6End, d7Start, d7End;
    int t1Hour, t1Minute, t2Hour, t2Minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        //Back Arrow
        {
            findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        //Setting Buttons and editText to id's
        buttonAddClass = findViewById(R.id.buttonAddClass);
        editTextNameOfClass = findViewById(R.id.editTextNameOfClass);
        editTextTeacherName = findViewById(R.id.editTextTeacherName);
        editTextTextEmailAddressOfTeacher = findViewById(R.id.editTextEmailAddressOfTeacher);

        //all chips id set
        day_1 = findViewById(R.id.ChipDay1Timetable);
        day_2 = findViewById(R.id.ChipDay2Timetable);
        day_3 = findViewById(R.id.ChipDay3Timetable);
        day_4 = findViewById(R.id.ChipDay4Timetable);
        day_5 = findViewById(R.id.ChipDay5Timetable);
        day_6 = findViewById(R.id.ChipDay6Timetable);
        day_7 = findViewById(R.id.ChipDay7Timetable);

        d1Start = findViewById(R.id.day1SelectTimeStart);
        d2Start = findViewById(R.id.day2SelectTimeStart);
        d3Start = findViewById(R.id.day3SelectTimeStart);
        d4Start = findViewById(R.id.day4SelectTimeStart);
        d5Start = findViewById(R.id.day5SelectTimeStart);
        d6Start = findViewById(R.id.day6SelectTimeStart);
        d7Start = findViewById(R.id.day7SelectTimeStart);

        d1End = findViewById(R.id.day1SelectTimeEnd);
        d2End = findViewById(R.id.day2SelectTimeEnd);
        d3End = findViewById(R.id.day3SelectTimeEnd);
        d4End = findViewById(R.id.day4SelectTimeEnd);
        d5End = findViewById(R.id.day5SelectTimeEnd);
        d6End = findViewById(R.id.day6SelectTimeEnd);
        d7End = findViewById(R.id.day7SelectTimeEnd);

        d1Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d1Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d1End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d1End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d1Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d2Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d1End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d2End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d3Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d3Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d3End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d3End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d4Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d4Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d4End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d4End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d5Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d5Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d6End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d6End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d7Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d7Start.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        d7End.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        addClass.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;

                                Calendar calendar = Calendar.getInstance();

                                calendar.set(0,0,0,t1Hour,t1Minute);

                                d7End.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }
        });

        buttonAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserClass userClass;
                DBClassTable dataBase = new DBClassTable(addClass.this);

                //Try catch to so that app doest crash if unexpected value is entered into UserClass class.
                try {
                    userClass = new UserClass(-1, editTextNameOfClass.getText().toString(), editTextTeacherName.getText().toString(), editTextTextEmailAddressOfTeacher.getText().toString());
                    boolean debugSuccess = dataBase.addUserClass(userClass);

                    Toast.makeText(addClass.this, userClass.getNameOfClass() + " has been added.", Toast.LENGTH_SHORT).show();

                    onBackPressed();
                }
                catch (Exception e){
                    Toast.makeText(addClass.this, "Unable to add new Class!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}