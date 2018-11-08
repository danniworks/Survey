package SurveyLib.Menus;

import UserInterfaceLib.MenuSections.Section;

public class QuestionTypeSection extends Section {

    public QuestionTypeSection() {
        name = "Question Type Section";
        addSelections("Add a new T/F question", "");
        addSelections("Add a new multiple choice question", "");
        addSelections("Add a new short answer question", "");
        addSelections("Add a new essay question", "");
        addSelections("Add a new ranking question", "");
        addSelections("Add a new matching question", "");
        totalChoices = 6;
    }

    public void updateChoices() {
        totalChoices = getSelections().size();
    }
}
