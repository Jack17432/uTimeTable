package com.temprist.utimetable;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClassesFragment extends Fragment {

    //References
    ListView listViewClasses;
    DBClassTable dataBase;
    ArrayAdapter<String> userClassArrayAdapter;
    View view;

    public ClassesFragment() {

    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classes, container, false);
        listViewClasses = view.findViewById(R.id.listViewClasses);
        dataBase = new DBClassTable(getActivity().getApplicationContext());

        refreshList();

        listViewClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userClass = (String) parent.getItemAtPosition(position);
                String IDString = userClass.substring(userClass.indexOf("(") + 1, userClass.indexOf(")"));
                Integer ID = Integer.parseInt(IDString);
                boolean isClassDeleted = dataBase.deleteUserClass(ID);

                refreshList();
                if (isClassDeleted) Toast.makeText(getActivity(), "Class has been deleted.", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getActivity(),  "Class has failed to deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    public void refreshList() {
        List<UserClass> listOfAllClasses = dataBase.getAllClasses();
        List<String> listOfAllClassesFormat = new ArrayList<>();

        for(int i = 0; i < listOfAllClasses.size(); i++){
            UserClass currClass = listOfAllClasses.get(i);
            listOfAllClassesFormat.add("ID: (" + currClass.getId() +
                            ")\nName of class: " + currClass.getNameOfClass() +
                            "\nTeacher Name: " + currClass.getNameOfTeacher() +
                            "\nIs on day 1: " + currClass.getDay1() +
                            "\nClass Time: " + currClass.getDay1Time() +
                            "\nIs on day 2: " + currClass.getDay2() +
                            "\nClass Time: " + currClass.getDay2Time() +
                            "\nIs on day 3: " + currClass.getDay3() +
                            "\nClass Time: " + currClass.getDay3Time() +
                            "\nIs on day 4: " + currClass.getDay4() +
                            "\nClass Time: " + currClass.getDay4Time() +
                            "\nIs on day 5: " + currClass.getDay5() +
                            "\nClass Time: " + currClass.getDay5Time() +
                            "\nIs on day 6: " + currClass.getDay6() +
                            "\nClass Time: " + currClass.getDay6Time() +
                            "\nIs on day 7: " + currClass.getDay7() +
                            "\nClass Time: " + currClass.getDay7Time()
            );
        }

        userClassArrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listOfAllClassesFormat);
        listViewClasses.setAdapter(userClassArrayAdapter);
    }
}