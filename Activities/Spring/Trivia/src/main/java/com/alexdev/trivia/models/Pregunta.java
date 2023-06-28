package com.alexdev.trivia.models;

public class Pregunta {
    private String category;
    private String question, explanation;
    private String[] options;
    private Integer answer;

    public Pregunta(String category, String question, String explanation, String[] options, Integer answer) {
        this.category = category;
        this.question = question;
        this.explanation = explanation;
        this.options = options;
        this.answer = answer;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
