package QuestionLib;

public class TrueFalse extends MultipleChoice {

    public TrueFalse() {
        setType("tf");
        getChoiceList().add("True");
        getChoiceList().add("False");
        setPrompt("Enter the prompt or your True/False question");
    }
}
