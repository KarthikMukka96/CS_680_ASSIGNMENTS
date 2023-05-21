package edu.umb.cs680.hw16.StockApp;


import edu.umb.cs680.hw16.Observable;
import edu.umb.cs680.hw16.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockEventObserver implements Observer<StockEvent> {
    private boolean updated;
    private List<StockEvent> updatedEvents;

    public StockEventObserver() {
        this.updated = false;
        this.updatedEvents = new ArrayList<>();
    }

    @Override
    public void update(Observable<StockEvent> observable, StockEvent event) {
        updated = true;
        updatedEvents.add(event);
        System.out.println("Received Stock Event: " + event.getTicker() + " - " + event.getQuote());
    }

    public boolean isUpdated() {
        return updated;
    }

    public List<StockEvent> getUpdatedEvents() {
        return updatedEvents;
    }
}
