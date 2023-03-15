import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

public class Requirement {
    private String courseName;
    public static int id;
    public ArrayList<String> requirement = new ArrayList<>();
    private String fileName;        // file Address

    public Requirement(String courseName,String fileName){
        this.courseName = courseName;
        this.fileName = fileName;
        id++;
    }
    public void ReadRequirement(){
        try {
            FileReader fr = new FileReader(fileName);  // read teaching requirement from file
            Scanner sc = new Scanner(fr);

            while (sc.hasNext()){
                String[] require = sc.nextLine().split(" ");
                if(require[0].equals(courseName)){
                    for(int i =1;i<require.length;i++){
                        requirement.add(require[i]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String toString(){
        return courseName+" "+"ID:"+id;
    }


}
