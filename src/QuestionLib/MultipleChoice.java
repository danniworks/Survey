package QuestionLib;
import java.util.ArrayList;

public class MultipleChoice extends Question{

    private int totalAnswer = 1;

    public MultipleChoice() {
        setType("mc");
        setPrompt("Enter the prompt or your multiple-choice question");
    }
}

