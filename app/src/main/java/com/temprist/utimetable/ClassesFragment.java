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

public class ClassesFragment extends Fragment {

    //References
    ListView listViewClasses;
    DBClassTable dataBase;
    ArrayAdapter<UserClass> userClassArrayAdapter;
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
                UserClass clickedUserClass = (UserClass) parent.getItemAtPosition(position);
                boolean isClassDeleted = dataBase.deleteUserClass(clickedUserClass);

                refreshList();
                if (isClassDeleted) Toast.makeText(getActivity().getApplicationContext(), clickedUserClass.getNameOfClass() + " has been deleted." , Toast.LENGTH_SHORT).show();
                else Toast.makeText(getActivity().getApplicationContext(), "Unable to delete Class." , Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    public void refreshList() {
        userClassArrayAdapter = new ArrayAdapter<UserClass>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, dataBase.getAllClasses());
        listViewClasses.setAdapter(userClassArrayAdapter);
    }
}