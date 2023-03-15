import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff{
    private String staffName;
    public static int id;
    public ArrayList<String> ability = new ArrayList<>();
    private String fileName;        // file Address

    public Staff(String staffName,String fileName){
        this.staffName = staffName;
        this.fileName = fileName;
        id++;
    }

    public void ReadAbility(){
        try {
            FileReader fr = new FileReader(fileName);  // read teaching requirement from file
            Scanner sc = new Scanner(fr);

            while (sc.hasNext()){
                String[] require = sc.nextLine().split(" ");
                if(require[0].equals(staffName)){
                    for(int i =1;i<require.length;i++){
                        ability.add(require[i]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
