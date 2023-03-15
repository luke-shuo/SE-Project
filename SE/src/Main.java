import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Staff A = new Staff("C","SE/Database/StaffAbility");
        A.ReadAbility();
        for(int i=0;i<A.ability.size();i++){
            System.out.println(A.ability.get(i));
        }
    }
}