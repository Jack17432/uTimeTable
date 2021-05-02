package com.temprist.utimetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addClass extends AppCompatActivity {

    //String
    public String stringDebug = "DEBUG: ";

    //Referencing
    Button buttonAddClass;
    EditText editTextNameOfClass, editTextTeacherName, editTextTextEmailAddressOfTeacher;

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

        buttonAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserClass userClass;
                DataBase dataBase = new DataBase(addClass.this);

                //Try catch to so that app doest crash if unexpected value is entered into UserClass class.
                try {
                    userClass = new UserClass(-1, editTextNameOfClass.getText().toString(), editTextTeacherName.getText().toString(), editTextTextEmailAddressOfTeacher.getText().toString());
                    boolean debugSuccess = dataBase.addUserClass(userClass);

                    Toast.makeText(addClass.this, userClass.getNameOfClass(), Toast.LENGTH_SHORT).show();

                    onBackPressed();
                }
                catch (Exception e){
                    Toast.makeText(addClass.this, "Unable to add new Class!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}