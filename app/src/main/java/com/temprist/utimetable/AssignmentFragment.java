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

public class AssignmentFragment extends Fragment {

    ListView listViewAssignments;
    DBAssignmentTable database;
    ArrayAdapter<String> userAssignmentArrayAdapter;

    public AssignmentFragment() {

    }

    @Override
    public void onResume() {
        super.onResume();
        refreshList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assignment, container, false);
        listViewAssignments = view.findViewById(R.id.listViewAssignment);
        database = new DBAssignmentTable(getActivity());

        refreshList();

        listViewAssignments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String userAssignment = (String) parent.getItemAtPosition(position);
                String IDString = userAssignment.substring(userAssignment.indexOf("(") + 1, userAssignment.indexOf(")"));
                Integer ID = Integer.parseInt(IDString);
                boolean isClassDeleted = database.deleteUserAssignment(ID);

                refreshList();
                if (isClassDeleted) Toast.makeText(getActivity(), "Assignment has been deleted.", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getActivity(),  "Assignment has failed to deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void refreshList(){
        List<UserAssignment> listOfAllAssignments = database.getAllAssignments();
        List<String> listOfAllAssignmentsFormat = new ArrayList<>();

        for(int i = 0; i < listOfAllAssignments.size(); i++){
            UserAssignment currAssi = listOfAllAssignments.get(i);
            listOfAllAssignmentsFormat.add("ID: (" + currAssi.getId() +
                    ")\nName: " + currAssi.getAssignmentName() +
                    "\nDue Time: " + currAssi.getAssignmentTime() +
                    "\nDue Date: " + currAssi.getAssignmentDate() +
                    "\nDescription: " + currAssi.getAssignmentDescription()
            );
        }

        userAssignmentArrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listOfAllAssignmentsFormat);
        listViewAssignments.setAdapter(userAssignmentArrayAdapter);
    }
}