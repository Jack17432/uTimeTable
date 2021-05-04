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

public class AssignmentFragment extends Fragment {

    ListView listViewAssignments;
    DBAssignmentTable database;
    ArrayAdapter<UserAssignment> userAssignmentArrayAdapter;

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
                UserAssignment userAssignment = (UserAssignment) parent.getItemAtPosition(position);
                boolean isClassDeleted = database.deleteUserAssignment(userAssignment);

                refreshList();
                if (isClassDeleted) Toast.makeText(getActivity(), userAssignment.getAssignmentName() + " has been deleted.", Toast.LENGTH_SHORT).show();
                else Toast.makeText(getActivity(), userAssignment.getAssignmentName() + " has failed to deleted.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void refreshList(){
        userAssignmentArrayAdapter = new ArrayAdapter<UserAssignment>(getActivity(), android.R.layout.simple_list_item_1, database.getAllAssignments());
        listViewAssignments.setAdapter(userAssignmentArrayAdapter);
    }
}