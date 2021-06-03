package com.temprist.utimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class addClass extends AppCompatActivity {

    //String
    public String stringDebug = "DEBUG: ";

    //Referencing
    Button buttonAddClass;
    EditText editTextNameOfClass, editTextTeacherName, editTextTextEmailAddressOfTeacher;
    Chip day_1, day_2, day_3, day_4, day_5, day_6, day_7;
    CardView day_1_card, day_2_card, day_3_card, day_4_card, day_5_card, day_6_card, day_7_card;

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