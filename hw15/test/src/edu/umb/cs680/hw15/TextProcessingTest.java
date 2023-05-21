package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessingTest {

    @Test
    void testLowerCaseProcessing() {
        String input = "Hello, World!";
        TextProcessing textProcessing = new TextProcessing(input);

        String processedText = textProcessing.processText(new LowercaseTextProcessor());

        assertEquals("hello, world!", processedText);
    }

    @Test
    void testUpperCaseProcessing() {
        String input = "Hello, World!";
        TextProcessing textProcessing = new TextProcessing(input);

        String processedText = textProcessing.processText(new UppercaseTextProcessor());

        assertEquals("HELLO, WORLD!", processedText);
    }

    @Test
    void testRemoveNumbersProcessing() {
        String input = "He123llo, World!";
        TextProcessing textProcessing = new TextProcessing(input);

        String processedText = textProcessing.processText(new RemoveNumbersTextProcessor());

        assertEquals("Hello, World!", processedText);
    }


}