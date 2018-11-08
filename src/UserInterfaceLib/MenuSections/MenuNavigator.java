package UserInterfaceLib.MenuSections;

import UserInterfaceLib.DisplayComponent;

import UserInterfaceLib.TextComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenuNavigator {

    private Section currentSection;
    private ArrayList<Section> sectionList = new ArrayList<Section>();

    /**
     * Different From UYML
     * displayList should be a HashMap, changed var name to displayMap
     */
    private Map<Section, ArrayList<DisplayComponent>> displayMap = new HashMap<>();

    public MenuNavigator() { }

    /**
     * Different from UML
     * Added section parameter
     * @param section
     */
    public void addSection(Section section) {
        sectionList.add(section);
    }

    public void addDisplay(Section section) {
        TextComponent temp;
        ArrayList<DisplayComponent> displayList = new ArrayList<DisplayComponent>();

        for (int i = 0; i < section.totalChoices; i++) {
            temp = new TextComponent();
            temp.setConsoleText(section.getSelections().get(i).getKey());
            displayList.add(temp);
        }

        displayMap.put(section, displayList);
    }

    public void print() {
        ArrayList<DisplayComponent> displayList = displayMap.get(currentSection);

        for (int i = 0; i < displayList.size(); i++) {
            System.out.print("(" + (i+1) + ") ");
            displayList.get(i).print();
        }
    }

    /**
     * switchMenus is actually suppose to be in here
     */
    public void switchMenus(String input) {
        int choice = Integer.valueOf(input);
        int i = 0;
        while (i != sectionList.size()) {

            try {
                if (sectionList.get(i).name.equals(currentSection.getSelections().get(choice - 1).getValue())) {
                    currentSection = sectionList.get(i);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Selection is Invalid, please select a new option.");
                break;
            }
            i++;
        }
    }

    /**
     * Was not included in UML
     */
    public Section getCurrentSection() {
        return currentSection;
    }

    /**
     * Was also not included in UML
     */
    public void setCurrentSection(Section section) {
        currentSection = section;
    }
}
