package com.temprist.utimetable;

public class UserClass {

    private int id;
    private String nameOfClass;
    private String nameOfTeacher;
    private String teacherEmail;

    //Constructor
    public UserClass(int id, String nameOfClass, String nameOfTeacher, String teacherEmail) {
        this.id = id;
        this.nameOfClass = nameOfClass;
        this.nameOfTeacher = nameOfTeacher;
        this.teacherEmail = teacherEmail;
    }

    public UserClass() {
    }

    //toString
    @Override
    public String toString() {
        return "userClass{" +
                "id=" + id +
                ", nameOfClass='" + nameOfClass + '\'' +
                ", nameOfTeacher='" + nameOfTeacher + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                '}';
    }

    //Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
