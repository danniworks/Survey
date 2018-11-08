package UserInterfaceLib.MenuSections;

import javafx.util.Pair;

import java.util.ArrayList;

public class Section {

    /**
     * Different from UML, added totalChoices here instead of extended classes
     */
    protected int totalChoices;
    protected String name;


    /**
     * Differnt from UML, added selections list with its getter and setter
     */
    protected ArrayList<Pair<String, String>> selections = new ArrayList<Pair<String, String>>();

    public Section() {}

    public ArrayList<Pair<String, String>> getSelections() {
        return selections;
    }

    public void addSelections(String option, String toGo) {
        Pair<String, String> temp = new Pair<>(option, toGo);
        selections.add(temp);
    }

    public String getName() {
        return name;
    }

    public void removeSelection(int i){
        selections.remove(i);
    }
}
