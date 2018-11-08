package QuestionLib;

public class ShortAnswer extends Essay {
    int responseLength;

    public ShortAnswer() {
        setType("sa");
        setPrompt("Enter the prompt or your short answer question");
    }

    public void setResponseLength(int size) {
        responseLength = size;
    }
}
