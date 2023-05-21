package edu.umb.cs680.hw16.StockApp;

import edu.umb.cs680.hw16.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StockQuoteObservableTest {


    private StockQuoteObservable stockQuoteObservable;

    @BeforeEach
    void setUp() {
        stockQuoteObservable = new StockQuoteObservable();
    }

    @Test
    void testAddObserver() {
        Observer<StockEvent> observer = new TableObserver();
        stockQuoteObservable.addObserver(observer);

        assertEquals(1, stockQuoteObservable.countObservers());
        assertTrue(stockQuoteObservable.getObservers().contains(observer));
    }

    @Test
    void testRemoveObserver() {
        Observer<StockEvent> observer1 = new TableObserver();
        Observer<StockEvent> observer2 = new LineChartObserver();
        stockQuoteObservable.addObserver(observer1);
        stockQuoteObservable.addObserver(observer2);

        stockQuoteObservable.removeObserver(observer1);

        assertEquals(1, stockQuoteObservable.countObservers());
        assertTrue(stockQuoteObservable.getObservers().contains(observer2));
        assertTrue(!stockQuoteObservable.getObservers().contains(observer1));
    }

    @Test
    void testStockEventUpdate() {
        StockQuoteObservable stockObservable = new StockQuoteObservable();
        StockEventObserver stockObserver = new StockEventObserver();
        stockObservable.addObserver(stockObserver);
        stockObservable.addObserver(new TableObserver());
        stockObservable.addObserver(new LineChartObserver());
        stockObservable.addObserver(new S3DObserver());


        Random random = new Random();
        double currentQuote = 100.0;

        for (int i = 1; i <= 5; i++) {
            double newQuote = currentQuote + random.nextDouble() * 10 - 5;
            stockObservable.changeQuote("ABC", newQuote);

            assertEquals(i, stockObserver.getUpdatedEvents().size());
            StockEvent lastEvent = stockObserver.getUpdatedEvents().get(i - 1);
            assertEquals("ABC", lastEvent.getTicker());
            assertTrue(lastEvent.getQuote() >= currentQuote - 5 && lastEvent.getQuote() <= currentQuote + 5);

            currentQuote = newQuote;
        }
    }

    @Test
    void testNotifyObservers() {
        Observer<StockEvent> observer1 = new StockEventObserver();
        Observer<StockEvent> observer2 = new StockEventObserver();
        stockQuoteObservable.addObserver(observer1);
        stockQuoteObservable.addObserver(observer2);

        stockQuoteObservable.changeQuote("AAPL", 150.0);

        assertTrue(((StockEventObserver) observer1).isUpdated());
        assertTrue(((StockEventObserver) observer2).isUpdated());
    }

    @Test
    void testNotifyObserversWithMultipleQuotes() {
        Observer<StockEvent> observer = new StockEventObserver();
        stockQuoteObservable.addObserver(observer);

        stockQuoteObservable.changeQuote("AAPL", 150.0);
        stockQuoteObservable.changeQuote("GOOGL", 2500.0);
        stockQuoteObservable.changeQuote("TSLA", 600.0);

        assertEquals(3, ((StockEventObserver) observer).getUpdatedEvents().size());
    }

    @Test
    void testClearObservers() {
        Observer<StockEvent> observer1 = new StockEventObserver();
        Observer<StockEvent> observer2 = new StockEventObserver();
        stockQuoteObservable.addObserver(observer1);
        stockQuoteObservable.addObserver(observer2);

        stockQuoteObservable.clearObservers();

        assertEquals(0, stockQuoteObservable.countObservers());
        assertTrue(stockQuoteObservable.getObservers().isEmpty());
    }


}