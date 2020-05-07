package com.vav.quizapp;

public class Question {
    private int QuestionResId;
    private boolean answerTrue;


    public Question(int questionResId, boolean answerTrue) {
        QuestionResId = questionResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionResId() {
        return QuestionResId;
    }

    public void setQuestionResId(int questionResId) {
        QuestionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
