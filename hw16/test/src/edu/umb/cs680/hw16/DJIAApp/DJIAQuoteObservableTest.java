package edu.umb.cs680.hw16.DJIAApp;

import edu.umb.cs680.hw16.Observable;
import edu.umb.cs680.hw16.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DJIAQuoteObservableTest {

    @Test
    void testChangeQuote() {
        DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable();
        double quote = 35000.0;
        double[] receivedEvent = new double[1];

        djiaObservable.addObserver((Observable<Double> o, Double event) -> receivedEvent[0] = event);
        djiaObservable.changeQuote(quote);

        assertEquals(quote, receivedEvent[0]);
    }

    @Test
    void testMultipleObservers() {
        DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable();
        double quote = 37000.0;
        double[] receivedEvent1 = new double[1];
        double[] receivedEvent2 = new double[1];

        djiaObservable.addObserver((o, event) -> receivedEvent1[0] = event);
        djiaObservable.addObserver((o, event) -> receivedEvent2[0] = event);
        djiaObservable.changeQuote(quote);

        assertEquals(quote, receivedEvent1[0]);
        assertEquals(quote, receivedEvent2[0]);
    }

    @Test
    void testNoObservers() {
        DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable();
        double quote = 38000.0;

        djiaObservable.changeQuote(quote);

        // No observers added, so no event should be received
        // This test is to ensure no exceptions are thrown
    }

    @Test
    void testRemoveObserver() {
        DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable();
        double quote = 39000.0;
        double[] receivedEvent = new double[1];

        Observer<Double> observer = (o, event) -> receivedEvent[0] = event;
        djiaObservable.addObserver(observer);
        djiaObservable.changeQuote(quote);

        assertEquals(quote, receivedEvent[0]);

        djiaObservable.removeObserver(observer);
        double newQuote = 40000.0;
        djiaObservable.changeQuote(newQuote);

        // Observer removed, so it should not receive the new event
        assertEquals(quote, receivedEvent[0]);
    }

    @Test
    void testMultipleEvents() {
        DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable();
        double quote1 = 41000.0;
        double quote2 = 42000.0;
        double quote3 = 43000.0;
        double[] receivedEvent = new double[1];

        djiaObservable.addObserver((o, event) -> receivedEvent[0] = event);
        djiaObservable.changeQuote(quote1);
        assertEquals(quote1, receivedEvent[0]);

        djiaObservable.changeQuote(quote2);
        assertEquals(quote2, receivedEvent[0]);

        djiaObservable.changeQuote(quote3);
        assertEquals(quote3, receivedEvent[0]);
    }
}
