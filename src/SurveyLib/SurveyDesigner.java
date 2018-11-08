package SurveyLib;

import QuestionLib.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SurveyDesigner {

    private boolean isTest = false;
    private Survey currentSurvey;
    private Question currentQuestion;
    private SurveyView surveyView = new SurveyView();
    private Scanner scanner = new Scanner(System.in);
    private String userIn;

    public SurveyDesigner() {}

    public void setSurvey(Survey survey) {
        currentSurvey = survey;
    }

    public void addQuestion(int input) {
        if(input == 1) {
            currentQuestion = new TrueFalse();
        }
        if(input == 2) {
            currentQuestion = new MultipleChoice();
        }
        if(input == 3) {
            currentQuestion = new ShortAnswer();
        }
        if(input == 4) {
            currentQuestion = new Essay();
        }
        if(input == 5) {
            currentQuestion = new Ranking();
        }
        if(input == 6) {
            currentQuestion = new Matching();
        }

        currentSurvey.getQuestionList().add(currentQuestion);
        surveyView.printPrompt(currentQuestion);
        userIn = scanner.nextLine();
        currentQuestion.setPrompt(userIn);

        if(currentQuestion.getType().equals("mc") || currentQuestion.getType().equals("ma") || currentQuestion.getType().equals("ra")) {
            System.out.println("Enter the number of choices.");
            userIn = scanner.nextLine();
            addOptions(Integer.valueOf(userIn));
        }
        if(currentQuestion.getType().equals("tf")) {
            currentSurvey.getOptionList().put(currentQuestion, currentQuestion.getChoiceList());
        }
        if(currentQuestion.getType().equals("essay") || currentQuestion.getType().equals("sa")) {
            currentSurvey.getOptionList().put(currentQuestion, null);
        }
        if(currentQuestion.getType().equals("sa")) {
            System.out.println("Enter max response length for short answer question.");
            userIn = scanner.nextLine();
        }

        if(isTest) {
            addResponse();
        }
    }

    public void addResponse() {
        System.out.println("Enter correct response : ");
        userIn = scanner.nextLine();
        currentQuestion.setResponse(userIn);
    }

    public void addOptions(int num) {
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Choice " + (i+1) + " :");
            userIn = scanner.nextLine();
            options.add(userIn);
        }
        currentSurvey.getOptionList().put(currentQuestion, options);
    }

    public void setName() {
        if (currentSurvey != null) {
            System.out.println("Enter name for survey");
            userIn = scanner.nextLine();
            currentSurvey.setTitle(userIn);
        }
    }

    public void setTest(boolean b) {
        isTest = b;
    }
}
