package SurveyLib.Menus;

import UserInterfaceLib.MenuSections.Section;

public class SurveyCreateSection extends Section {

    public SurveyCreateSection() {
        totalChoices = 3;
        name = "Survey Create Section";
        addSelections("Change Survey Name", "");
        addSelections("Add Question", "Question Type Section");
        addSelections("Delete Question", "");
    }
}
