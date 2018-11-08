package UserInterfaceLib.MenuSections.Menus;

import UserInterfaceLib.MenuSections.Section;

public class SurveySection extends Section {

    public SurveySection() {
        totalChoices = 5;
        name = "Survey Section";
        addSelections("Create a new Survey", "Question Type Section");
        addSelections("Display a Survey", "");
        addSelections("Load a Survey", "");
        addSelections("Save a Survey", "");
        addSelections("Quit", "");
    }

}
