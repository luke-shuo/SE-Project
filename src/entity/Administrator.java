package entity;

import fileHander.courseWriter;
import fileHander.staffTrainWriter;
import fileHander.teacherReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Administrator{
    INSTANCE;

    public void findSuitableStaff(teacherReader teacher, Director director){
        ArrayList<Staff> staffList = teacher.getStaffList();
        ArrayList<String> requirement = director.getRequirementList();
        ArrayList<Staff> suitStaff = new ArrayList<>();
        HashMap<Staff, Integer> suitMarkMap = new HashMap<>();

        int result = 0;
        int maxResult = Integer.MIN_VALUE;
        for(Staff staff : staffList){
            result = 0;
            for(String ability : staff.getAbility()){
                if(requirement.contains(ability)){
                    result++;
                }
            }
            suitMarkMap.put(staff, result);
            maxResult = Math.max(maxResult, result);
        }

        for(Map.Entry<Staff, Integer> entry : suitMarkMap.entrySet()){
            if(entry.getValue() == maxResult){
                suitStaff.add(entry.getKey());
            }
        }

        director.setCourseSuitableStaffList(suitStaff);

        courseWriter courseWriter = new courseWriter("src/config/CourseSuitableStaff");
        courseWriter.writeStaffNamesToFile(director.getCourseName(), suitStaff, true);

    }



    public void getTraining(Director director){
        ArrayList<Staff> suitStaff = director.getCourseSuitableStaffList();
        ArrayList<String> requirement = director.getRequirementList();

        if(suitStaff.isEmpty()){
            System.out.println("--------This course has not been assigned staff by the administrator-------");
            System.out.println("--------Please contact the administrator to assign a staff member first--------");
            return;
        }

        for(Staff staff : suitStaff){
            ArrayList<String> trainingList = new ArrayList<>();

            for(String require : requirement){
                if (!staff.getAbility().contains(require)) {
                    trainingList.add(require);
                }
            }

            staff.setTraining(trainingList);
        }

        staffTrainWriter staffTrainWriter = new staffTrainWriter("src/config/StaffTraining");

        staffTrainWriter.writeStaffListToFile(suitStaff, true);
    }
}
