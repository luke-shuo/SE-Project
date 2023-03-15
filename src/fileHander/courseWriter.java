package fileHander;

import entity.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class courseWriter {
    private static int courseCount = 1;
    private String fileName;

    public courseWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeStaffNamesToFile(String courseName, ArrayList<Staff> suitStaff, boolean append) {
            try {
                File file = new File(fileName);
                FileWriter writer = new FileWriter(file, append);

                writer.write(courseCount + ". " + courseName + ": ");
                for (Staff staff : suitStaff) {
                    writer.write(staff.getName() + "、 ");
                }
                writer.write("\n");
                writer.close();
                System.out.println("Course and its suitable staff written to file: " + fileName);
                courseCount++;
            } catch (IOException e) {
                System.out.println("Error writing staff names to file: " + e.getMessage());
            }
        }
}

