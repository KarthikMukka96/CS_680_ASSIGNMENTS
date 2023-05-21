package edu.umb.cs680.hw16.StockApp;

import edu.umb.cs680.hw16.Observable;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {

    private Map<String, Double> mapping = new HashMap<>();

    public void changeQuote(String ticker, Double quote) {
        mapping.put(ticker, quote);
        notifyObservers(new StockEvent(ticker, quote));
    }
}
