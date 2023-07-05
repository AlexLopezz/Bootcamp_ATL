package models;

import java.util.ArrayList;
import java.util.List;

public class MisteryWord {
    private String word,
                   description;
    private List<String> options = new ArrayList<>();

    public MisteryWord(String word, String description) {
        this.word = word;
        this.description = description;
        options.add(word);
    }

    public MisteryWord(String word, String description,List<String> options) {
        this.word = word;
        this.description = description;
        this.options = options;
        options.add(this.word);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
        this.options.add(word);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addOptionsMisteryWord(String misteryWord){
        options.add(misteryWord);
    }

    public boolean checkIsCorrectOption(int option){
        return word.equals(options.get(option));
    }
    public boolean checkIsCorrectOption(String wordUser){
        return word.equalsIgnoreCase(wordUser);
    }

    @Override
    public String toString() {
        return "Palabra misteriosa: "+ word;
    }
}
