package edu.umb.cs680.hw15;

public class RemoveNumbersTextProcessor implements TextProcessor {
    public String processText(String text) {
        return text.replaceAll("\\d+", "");
    }
}
