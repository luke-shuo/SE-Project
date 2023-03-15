package fileHander;

import entity.Director;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class courseReader {

    static String courseName;
    static ArrayList<String> requirement = new ArrayList<>();
    private String fileName;        // file Address
    private ArrayList<Director> directorList = new ArrayList<>();

    public courseReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;


            FileReader fr = new FileReader(fileName);  // read teaching requirement from file
            Scanner sc = new Scanner(fr);

            while (sc.hasNext()){
                String[] require = sc.nextLine().split(" ");

                courseName = require[0];

                for(int i =1;i<require.length;i++){
                    requirement.add(require[i]);
                }

                boolean flag = true;

                for(Director director : directorList){
                    if(courseName.isEmpty()){
                        break;
                    }

                    if(courseName.equals(director.getCourseName())){
                        flag = false;
                        director.setRequirementList(requirement);
                    }
                }

                if(flag){
                    Director director = new Director();
                    director.setCourseName(courseName);
                    director.setRequirementList(requirement);
                    directorList.add(director);
                }
            }
    }

    public ArrayList<Director> getDirectorList() {
        return directorList;
    }

}

