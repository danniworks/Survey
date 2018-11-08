package QuestionLib;

public class Essay extends Question {
    public int totalAnswer = 1;
    public Essay() {
        setType("essay");
        setPrompt("Enter the prompt or your essay question");
    }
}
