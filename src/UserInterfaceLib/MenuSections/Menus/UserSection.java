package UserInterfaceLib.MenuSections.Menus;


import UserInterfaceLib.MenuSections.Section;

public class UserSection extends Section {

    public UserSection() {
        totalChoices = 2;
        name = "User Section";
        addSelections("Survey", "Survey Section");
        addSelections("Test", "Test Section");
    }
}
