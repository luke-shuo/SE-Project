import entity.Administrator;
import entity.Director;
import fileHander.courseReader;
import fileHander.teacherReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class center {
    static courseReader courseReader;
    static teacherReader teacherReader;

    public static void main(String[] args) throws FileNotFoundException {
        initialize();

        while(true){
            System.out.println("-------- Teaching Management System --------");
            System.out.println("1 Find a suitable staff for the course");
            System.out.println("2 Organise training for staffs");
            System.out.println("3 Exit");

            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            switch (choice){
                case "1" :
                    Director chosenDirector = chooseCourse();
                    Administrator.INSTANCE.findSuitableStaff(teacherReader, chosenDirector);
                    break;
                case "2" :
                    Director needTrainDirector = chooseCourse();
                    Administrator.INSTANCE.getTraining(needTrainDirector);
                    break;
                case "3" :
                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }

    public static Director chooseCourse(){
        System.out.println("-------- Choose A Course --------");
        ArrayList<Director> directorList = courseReader.getDirectorList();

        for (int i = 0; i < directorList.size(); i++) {
            String courseName = directorList.get(i).getCourseName();
            System.out.println((i + 1) + " " + courseName);
        }

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        int index = Integer.valueOf(choice) - 1;
        Director chosenDirector = directorList.get(index);
        return chosenDirector;
    }

    public static void initialize() throws FileNotFoundException {
        courseReader = new courseReader("src/config/TeachingRequirement");
        teacherReader = new teacherReader("src/config/StaffAbility");
    }


}