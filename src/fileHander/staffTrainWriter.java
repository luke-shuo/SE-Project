package fileHander;

import entity.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class staffTrainWriter {
    private String fileName;

    public staffTrainWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeStaffListToFile(ArrayList<Staff> staffList, boolean append) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file, append);
            int index = 1;
            for (Staff staff : staffList) {
                writer.write(index + ". " + staff.getName() + "need training : ");
                for (String training : staff.getTraining()) {
                    writer.write(training + "、 ");
                }
                writer.write("\n");
                index++;
            }
            writer.close();
            System.out.println("Staff training list written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing staff list to file: " + e.getMessage());
        }
    }

    }


