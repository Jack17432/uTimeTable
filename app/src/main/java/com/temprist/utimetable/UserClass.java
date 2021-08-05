package com.temprist.utimetable;

public class UserClass {

    private int id;
    private String nameOfClass;
    private String nameOfTeacher;
    private String teacherEmail;
    private int day1, day2, day3, day4, day5, day6, day7;
    private String day1Time, day2Time, day3Time, day4Time, day5Time, day6Time, day7Time;

    public UserClass(int id,
                     String nameOfClass,
                     String nameOfTeacher,
                     String teacherEmail,
                     int day1,
                     int day2,
                     int day3,
                     int day4,
                     int day5,
                     int day6,
                     int day7,
                     String day1Time,
                     String day2Time,
                     String day3Time,
                     String day4Time,
                     String day5Time,
                     String day6Time,
                     String day7Time) {
        this.id = id;
        this.nameOfClass = nameOfClass;
        this.nameOfTeacher = nameOfTeacher;
        this.teacherEmail = teacherEmail;
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
        this.day1Time = day1Time;
        this.day2Time = day2Time;
        this.day3Time = day3Time;
        this.day4Time = day4Time;
        this.day5Time = day5Time;
        this.day6Time = day6Time;
        this.day7Time = day7Time;
    }

    @Override
    public String toString() {
        return "UserClass{" +
                "id=" + id +
                ", nameOfClass='" + nameOfClass + '\'' +
                ", nameOfTeacher='" + nameOfTeacher + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", day1=" + day1 +
                ", day2=" + day2 +
                ", day3=" + day3 +
                ", day4=" + day4 +
                ", day5=" + day5 +
                ", day6=" + day6 +
                ", day7=" + day7 +
                ", day1Time='" + day1Time + '\'' +
                ", day2Time='" + day2Time + '\'' +
                ", day3Time='" + day3Time + '\'' +
                ", day4Time='" + day4Time + '\'' +
                ", day5Time='" + day5Time + '\'' +
                ", day6Time='" + day6Time + '\'' +
                ", day7Time='" + day7Time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public int getDay1() {
        return day1;
    }

    public int getDay2() {
        return day2;
    }

    public int getDay3() {
        return day3;
    }

    public int getDay4() {
        return day4;
    }

    public int getDay5() {
        return day5;
    }

    public int getDay6() {
        return day6;
    }

    public int getDay7() {
        return day7;
    }

    public String getDay1Time() {
        return day1Time;
    }

    public String getDay2Time() {
        return day2Time;
    }

    public String getDay3Time() {
        return day3Time;
    }

    public String getDay4Time() {
        return day4Time;
    }

    public String getDay5Time() {
        return day5Time;
    }

    public String getDay6Time() {
        return day6Time;
    }

    public String getDay7Time() {
        return day7Time;
    }
}
