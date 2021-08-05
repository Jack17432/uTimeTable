package com.temprist.utimetable;

public class UserAssignment {

    int id;
    String assignmentName, assignmentDescription, assignmentDate, assignmentTime;

    //One constructor to define all values and one constructor if a UserAssignment is needed without values being set.

    public UserAssignment(int id, String assignmentName, String assignmentDescription, String assignmentDate, String assignmentTime) {
        this.id = id;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentDate = assignmentDate;
        this.assignmentTime = assignmentTime;
    }

    //toString used to display all values for debugging and displaying raw data.

    @Override
    public String toString() {
        return "UserAssignment{" +
                "id=" + id +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", assignmentDate='" + assignmentDate + '\'' +
                ", assignmentTime='" + assignmentTime + '\'' +
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

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public String getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(String assignmentTime) {
        this.assignmentTime = assignmentTime;
    }
}
