package com.temprist.utimetable;

public class UserAssignment {

    private int id;
    private String nameOfAssignment;
    private int progressOfAssignment;
    private String timeDueOfAssignment;
    private String dateDueOfAssignment;
    private String classOfAssignment;
    private String descriptionOfAssignment;

    //Constructors

    public UserAssignment(int id, String nameOfAssignment, int progressOfAssignment, String timeDueOfAssignment, String dateDueOfAssignment, String classOfAssignment, String descriptionOfAssignment) {
        this.id = id;
        this.nameOfAssignment = nameOfAssignment;
        this.progressOfAssignment = progressOfAssignment;
        this.timeDueOfAssignment = timeDueOfAssignment;
        this.dateDueOfAssignment = dateDueOfAssignment;
        this.classOfAssignment = classOfAssignment;
        this.descriptionOfAssignment = descriptionOfAssignment;
    }

    public UserAssignment() {
    }

    //toString

    @Override
    public String toString() {
        return "UserAssignment{" +
                "id=" + id +
                ", nameOfAssignment='" + nameOfAssignment + '\'' +
                ", progressOfAssignment=" + progressOfAssignment +
                ", timeDueOfAssignment=" + timeDueOfAssignment +
                ", dateDueOfAssignment='" + dateDueOfAssignment + '\'' +
                ", classOfAssignment=" + classOfAssignment +
                ", descriptionOfAssignment='" + descriptionOfAssignment + '\'' +
                '}';
    }


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfAssignment() {
        return nameOfAssignment;
    }

    public void setNameOfAssignment(String nameOfAssignment) {
        this.nameOfAssignment = nameOfAssignment;
    }

    public int getProgressOfAssignment() {
        return progressOfAssignment;
    }

    public void setProgressOfAssignment(int progressOfAssignment) {
        this.progressOfAssignment = progressOfAssignment;
    }

    public String getTimeDueOfAssignment() {
        return timeDueOfAssignment;
    }

    public void setTimeDueOfAssignment(String timeDueOfAssignment) {
        this.timeDueOfAssignment = timeDueOfAssignment;
    }

    public String getDateDueOfAssignment() {
        return dateDueOfAssignment;
    }

    public void setDateDueOfAssignment(String dateDueOfAssignment) {
        this.dateDueOfAssignment = dateDueOfAssignment;
    }

    public String getClassOfAssignment() {
        return classOfAssignment;
    }

    public void setClassOfAssignment(String classOfAssignment) {
        this.classOfAssignment = classOfAssignment;
    }

    public String getDescriptionOfAssignment() {
        return descriptionOfAssignment;
    }

    public void setDescriptionOfAssignment(String descriptionOfAssignment) {
        this.descriptionOfAssignment = descriptionOfAssignment;
    }
}
