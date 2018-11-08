
import SurveyLib.Menus.QuestionTypeSection;
import SurveyLib.SurveyController;
import UserInterfaceLib.MenuSections.MenuNavigator;
import UserInterfaceLib.MenuSections.Menus.SurveySection;
import UserInterfaceLib.MenuSections.Menus.TestSection;
import UserInterfaceLib.MenuSections.Menus.UserSection;

import java.io.IOException;
import java.util.Scanner;

public class main {

    private static SurveyController surveyController = new SurveyController();
    private static MenuNavigator menuNavigator = new MenuNavigator();

    public static void main(String []args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        /***********************************************************************
         * Set up Menus
         **********************************************************************/
        UserSection userSection = new UserSection();

        menuNavigator.addSection(userSection);
        menuNavigator.addDisplay(userSection);
        menuNavigator.setCurrentSection(userSection);

        SurveySection surveySection = new SurveySection();
        menuNavigator.addSection(surveySection);
        menuNavigator.addDisplay(surveySection);

        TestSection testSection = new TestSection();
        menuNavigator.addSection(testSection);
        menuNavigator.addDisplay(testSection);

        QuestionTypeSection questionTypeSection = new QuestionTypeSection();

        /***********************************************************************
         * Set up Menus
         **********************************************************************/

        System.out.println();
        boolean running = true;


        while (running) {

            menuNavigator.print();
            System.out.print("Enter : ");
            input = scanner.next();

            int choice = 0;
            try {
                choice = Integer.valueOf(input);
            } catch (Exception e) { }
            System.out.println();

            if(menuNavigator.getCurrentSection().getName().equals("User Section")) {
                if (choice == 1) { // Survey Section
                    questionTypeSection.addSelections("Back", "Survey Section");
                } else if (choice == 2){ // Test Section
                    questionTypeSection.addSelections("Back", "Test Section");
                }
                questionTypeSection.updateChoices();
                menuNavigator.addSection(questionTypeSection);
                menuNavigator.addDisplay(questionTypeSection);
            }

            try {
                if (menuNavigator.getCurrentSection().getSelections().get(choice - 1).getKey().equals("Quit")) {
                    break;
                }
            } catch (Exception e) { }

            /*********************************************
             * Survey Menu Options
             *********************************************/
            if (menuNavigator.getCurrentSection().getName().equals("Survey Section")
                || menuNavigator.getCurrentSection().getName().equals("Test Section")) {
                if (choice == 1 && menuNavigator.getCurrentSection().getName().equals("Survey Section")) {
                    surveyController.createSurvey();
                }
                if (choice == 1 && menuNavigator.getCurrentSection().getName().equals("Test Section")) {
                    surveyController.createTest();
                }
                if (choice == 2) {
                    surveyController.displaySurvey();
                }
                if (choice == 3) {
                    surveyController.loadSurvey();
                }
                if (choice == 4) {
                    try {
                        surveyController.saveSurvey();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            /*********************************************
             * Add Question Menu Options
             *********************************************/
            if (menuNavigator.getCurrentSection().getName().equals("Question Type Section")) {
                try {
                    if (choice < 7) {
                        surveyController.createQuestion(choice);
                    }
                } catch (Exception e) { }
            }

            try {
                menuNavigator.switchMenus(input);
            } catch (Exception e) {
                System.out.println("Invalid Option");
            }

            System.out.println();
        }

        System.out.println("Survey Program has now exited");

    }

}
