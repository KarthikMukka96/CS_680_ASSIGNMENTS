package edu.umb.cs680.hw16.StockApp;

import edu.umb.cs680.hw16.Observable;
import edu.umb.cs680.hw16.Observer;

public class TableObserver implements Observer<StockEvent> {
    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        System.out.println("Updating TableObserver with ticker = "+event.getTicker()+" and quote = "+event.getQuote().toString());
    }
}
