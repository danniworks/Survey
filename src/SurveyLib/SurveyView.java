package SurveyLib;

import QuestionLib.Question;
import SurveyLib.Menus.PromptSection;
import UserInterfaceLib.MenuSections.MenuNavigator;

import java.util.ArrayList;

public class SurveyView {

    private MenuNavigator menuNavigator = new MenuNavigator();

    public SurveyView(){ }

    public void printPrompt(Question q) {
        PromptSection promptSection = new PromptSection();
        promptSection.removeSelection(0);
        promptSection.addSelections(q.getPrompt(), "Question Type Section");
        menuNavigator.addSection(promptSection);
        menuNavigator.addDisplay(promptSection);
        menuNavigator.setCurrentSection(promptSection);
        menuNavigator.print();
    }

    public void printSurvey(Survey survey) {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
        System.out.println("Title : " + survey.getTitle());
        System.out.println();
        for (int i = 0; i < survey.getQuestionList().size(); i++) {
            System.out.print((i+1) + ") ");
            System.out.println(survey.getQuestionList().get(i).getPrompt());
            ArrayList<String> choices = survey.getOptionList().get(survey.getQuestionList().get(i));
            if (choices != null) {
                for (int x = 0; x < choices.size(); x++) {
                    System.out.print(letters[x] + ") ");
                    System.out.println(choices.get(x));
                }
            }
            if (survey.getQuestionList().get(i).getResponse() != null) {
                System.out.print("Correct response is... " + survey.getQuestionList().get(i).getResponse());
                System.out.println();
            }
            System.out.println();
        }
    }
}
