package com.temprist.utimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TimeTableFragment extends Fragment {

    public static final int TOTALDAYS = 7 ;

    String dateSetString;
    String timeSetString = "No time Selected";
    Integer dateSetInt = 1;
    TextView dateClasses;
    ListView listViewClasses;
    DBClassTable dataBase;
    ArrayAdapter<String> userClassArrayAdapter;
    Button ButtonLeft, ButtonRight;

    public TimeTableFragment() {
        
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
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
                refreshList();

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
                refreshList();

                dateSetString = dateSetInt.toString();
                dateClasses.setText(dateSetString);
            }
        });

        listViewClasses = view.findViewById(R.id.ListViewTimeTable);
        dataBase = new DBClassTable(getActivity().getApplicationContext());
        refreshList();

        return view;
    }

    public void refreshList() {
        List<UserClass> listOfCurrentDay = dataBase.getAllClassesOnSetDay(dateSetInt);
        List<String> listOfCurrentDayFormat = new ArrayList<>();

        for (int i = 0; i < listOfCurrentDay.size(); i++){
            UserClass currClass = listOfCurrentDay.get(i);

            switch (dateSetInt) {
                case 1:
                    timeSetString = currClass.getDay1Time();
                    break;

                case 2:
                    timeSetString = currClass.getDay2Time();
                    break;

                case 3:
                    timeSetString = currClass.getDay3Time();
                    break;

                case 4:
                    timeSetString = currClass.getDay4Time();
                    break;

                case 5:
                    timeSetString = currClass.getDay5Time();
                    break;

                case 6:
                    timeSetString = currClass.getDay6Time();
                    break;

                case 7:
                    timeSetString = currClass.getDay7Time();
                    break;
            }

            listOfCurrentDayFormat.add("Name of class: " + currClass.getNameOfClass() + "\nTeacher Name: " + currClass.getNameOfTeacher() + "\nClass time: " + timeSetString);
        }

        userClassArrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listOfCurrentDayFormat);
        listViewClasses.setAdapter(userClassArrayAdapter);
    }
}