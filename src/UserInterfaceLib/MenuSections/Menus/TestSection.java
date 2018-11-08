package UserInterfaceLib.MenuSections.Menus;

import UserInterfaceLib.MenuSections.Section;

public class TestSection extends Section {

    public TestSection() {
        totalChoices = 5;
        name = "Test Section";
        addSelections("Create a new Test", "Question Type Section");
        addSelections("Display a Test", "");
        addSelections("Load a Test", "");
        addSelections("Save a Test", "");
        addSelections("Quit", "");
    }
}
