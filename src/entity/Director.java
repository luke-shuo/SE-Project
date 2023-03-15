package entity;

import java.util.ArrayList;

public class Director {
    private String courseName;

    private ArrayList<String> requirementList = new ArrayList<>();

    private ArrayList<Staff> courseSuitableStaffList = new ArrayList<>();

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<String> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(ArrayList<String> requirementList) {
        this.requirementList = requirementList;
    }

    public ArrayList<Staff> getCourseSuitableStaffList() {
        return courseSuitableStaffList;
    }

    public void setCourseSuitableStaffList(ArrayList<Staff> courseSuitableStaffList) {
        this.courseSuitableStaffList = courseSuitableStaffList;
    }
}
