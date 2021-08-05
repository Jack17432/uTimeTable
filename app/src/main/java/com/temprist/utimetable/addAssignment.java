package com.temprist.utimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class addAssignment extends AppCompatActivity {

    //Referencing
    Button addAssignment;
    TextView nameOfAssignment, timeDueOfAssignment, dateDueOfAssignment, descriptionOfAssignment;
    SeekBar completionOfAssignment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assignment);

        //Definition
        addAssignment = findViewById(R.id.buttonAddAssignment);
        nameOfAssignment = findViewById(R.id.editTextNameOfAssignment);
        timeDueOfAssignment = findViewById(R.id.editTextTimeDueOfAssignment);
        dateDueOfAssignment = findViewById(R.id.editTextDateDueOfAssignment);
        descriptionOfAssignment = findViewById(R.id.editTextDescription);

        //Back Arrow
        {
            findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        addAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserAssignment userAssignment;
                DBAssignmentTable database = new DBAssignmentTable(addAssignment.this);

                try {
                    userAssignment = new UserAssignment(-1, nameOfAssignment.getText().toString(), descriptionOfAssignment.getText().toString(), dateDueOfAssignment.getText().toString(), timeDueOfAssignment.getText().toString());
                    database.addUserAssignment(userAssignment);

                    Toast.makeText(addAssignment.this, userAssignment.getAssignmentName() + " assignment has been added.", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
                catch (Exception e){
                    Toast.makeText(addAssignment.this, "Failed to add assignment!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}