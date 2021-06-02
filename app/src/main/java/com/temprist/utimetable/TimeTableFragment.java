package com.temprist.utimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TimeTableFragment extends Fragment {

    public static final int TOTALDAYS = 7 ;

    String dateSetString;
    Integer dateSetInt;
    TextView dateClasses;
    Button ButtonLeft, ButtonRight;

    public TimeTableFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_table, container, false);

        dateClasses = view.findViewById(R.id.textViewDateOfClass);
        ButtonLeft = view.findViewById(R.id.buttonLeft);
        ButtonRight = view.findViewById(R.id.buttonRight);

        //Back in date button click
        ButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateSetString = dateClasses.getText().toString();
                dateSetInt = Integer.parseInt(dateSetString);

                if (dateSetInt != 1)
                    dateSetInt--;
                else dateSetInt = TOTALDAYS;

                dateSetString = dateSetInt.toString();
                dateClasses.setText(dateSetString);
            }
        });

        //Forward in date button click
        ButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateSetString = dateClasses.getText().toString();
                dateSetInt = Integer.parseInt(dateSetString);

                if (dateSetInt != TOTALDAYS)
                    dateSetInt++;
                else dateSetInt = 1;

                dateSetString = dateSetInt.toString();
                dateClasses.setText(dateSetString);
            }
        });
        

        return view;
    }
}