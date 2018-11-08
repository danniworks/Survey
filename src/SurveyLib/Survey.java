package SurveyLib;

import QuestionLib.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Survey implements java.io.Serializable {

    private String title = "";
    private ArrayList<Question> questionList = new ArrayList<>();
    private Map<Question, ArrayList<String>> option = new HashMap<Question, ArrayList<String>>();

    public Survey() { }

    public void setTitle(String input) {
        title = input;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public Map<Question, ArrayList<String>> getOptionList() {
        return option;
    }
}
