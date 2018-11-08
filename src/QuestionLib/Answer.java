package QuestionLib;

public class Answer {

    private String answer_string;
    private int answer_questionNo;
    private String question;

    public Answer(){}

    public int getAnswerInt() {
        return answer_questionNo;
    }

    public String getAnswerString() {
        return answer_string;
    }

    public void setAnswerString(String s) {
        answer_string = s;
    }

    public void setAnswerQuestionNo(int i) {
        answer_questionNo = i;
    }

    public void setQuestion(String q) {
        question = q;
    }

    public String getQuestion() {
        return question;
    }
}
