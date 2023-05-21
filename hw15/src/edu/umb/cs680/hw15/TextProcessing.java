package edu.umb.cs680.hw15;

public class TextProcessing {
    String text;

    TextProcessing(String s) {
        text = s;
    }

    public String processText(TextProcessor p) {
        return p.processText(text);
    }
}

