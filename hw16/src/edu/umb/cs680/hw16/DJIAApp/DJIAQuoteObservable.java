package edu.umb.cs680.hw16.DJIAApp;

import edu.umb.cs680.hw16.Observable;

public class DJIAQuoteObservable extends Observable<Double> {

    private double quote;

    public void changeQuote(double q) {
        quote = q;
        notifyObservers(quote);
    }
}
