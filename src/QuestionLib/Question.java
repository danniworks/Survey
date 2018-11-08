package QuestionLib;

import java.util.ArrayList;

public abstract class Question implements java.io.Serializable{

    private String prompt;
    private String type;
    private ArrayList<String> choiceList = new ArrayList<String>();
    private String response;

    public Question(){}

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String userPrompt) {
        prompt = userPrompt;
    }

    public String getType() {
        return type;
    }

    public void setType(String s) {
        type = s;
    }

    public ArrayList<String> getChoiceList() {
        return choiceList;
    }

    public void setResponse(String s) {
        response = s;
    }

    public String getResponse() {
        return response;
    }
}
