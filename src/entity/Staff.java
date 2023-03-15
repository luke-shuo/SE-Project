package entity;

import java.util.ArrayList;

public class Staff {
    private String Name;
    private ArrayList<String> ability = new ArrayList<>();

    private ArrayList<String> training = new ArrayList<>();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getAbility() {
        return ability;
    }

    public void setAbility(ArrayList<String> ability) {
        this.ability = ability;
    }

    public ArrayList<String> getTraining() {
        return training;
    }

    public void setTraining(ArrayList<String> training) {
        this.training = training;
    }
}
