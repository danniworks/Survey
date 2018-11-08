package SurveyLib;

import java.io.*;
import java.util.Scanner;

public class SurveyController {

    private Survey survey;
    private SurveyView surveyView = new SurveyView();
    private SurveyDesigner surveyDesigner = new SurveyDesigner();

    public SurveyController() { }

    public void createSurvey() {
        survey = new Survey();
    }

    public void createTest() {
        survey = new Test();
        surveyDesigner.setTest(true);
    }

    public void createQuestion(int choice) {
        surveyDesigner.setSurvey(survey);
        surveyDesigner.addQuestion(choice);
    }

    public void displaySurvey() {
        if(survey != null) {
            surveyView.printSurvey(survey);
        } else {
            System.out.println("No Survey Created/Loaded");
        }
    }

    public void saveSurvey() throws IOException {
        surveyDesigner.setName();
        try {
            File f = new File("SavedSurveys/" + survey.getTitle());
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(survey);
            out.flush();
            out.close();
        } catch(Exception e) {
            System.out.println("No Survey Found");
        }
    }

    public void loadSurvey() {
        File folder = new File("SavedSurveys/");
        File[] files = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println((i+1) + ") " + files[i].getName());
            }
        }

        String fileName;
        int in = files.length + 2;

        while (in > files.length + 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose File :");
            try {
                in = scanner.nextInt();
            } catch (Exception e) { System.out.println("Invalid Option, Please choose again."); }
        }

        fileName = files[in-1].getName();

        try {
            InputStream file = new FileInputStream("SavedSurveys/" + fileName);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            survey = (Survey)input.readObject();
            surveyDesigner.setSurvey(survey);
            System.out.println("File has loaded successfully.");
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
