package fileHander;


import entity.Staff;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class teacherReader {
    private String staffName;
    private ArrayList<String> ability = new ArrayList<>();
    private String fileName;        // file Address
    private ArrayList<Staff> staffList = new ArrayList<>();

    public teacherReader(String fileName) {
        this.fileName = fileName;

        try {
            FileReader fr = new FileReader(fileName);  // read teaching requirement from file
            Scanner sc = new Scanner(fr);

            while (sc.hasNext()){
                String[] require = sc.nextLine().split(" ");

                staffName = require[0];

                for(int i =1;i<require.length;i++){
                    ability.add(require[i]);
                }

                boolean flag = true;

                for(Staff staff : staffList){
                    if(staffName.equals(staff.getName())){
                        flag = false;
                        staff.setAbility(ability);
                    }
                }

                if(flag){
                    Staff staff = new Staff();
                    staff.setName(staffName);
                    staff.setAbility(ability);
                    staffList.add(staff);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Staff> getStaffList(){
        return staffList;
    }
}
