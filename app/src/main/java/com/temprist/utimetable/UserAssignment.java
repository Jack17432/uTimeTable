package com.temprist.utimetable;

public class UserAssignment {

    int id;
    String assignmentName, assignmentDescription;

    //One constructor to define all values and one constructor if a UserAssignment is needed without values being set.

    public UserAssignment(int id, String assignmentName, String assignmentDescription) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
    }
    public UserAssignment() {
    }

    //toString used to display all values for debugging and displaying raw data.

    @Override
    public String toString() {
        return "UserAssignment{" +
                "id=" + id +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                '}';
    }


    //Getters and setters for all values in the class.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }
}
