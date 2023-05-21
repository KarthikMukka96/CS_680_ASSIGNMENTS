package edu.umb.cs680.hw16.StockApp;

public class StockEvent {

    private String ticker;
    private Double quote;

    public StockEvent(String ticker, Double quote) {
        this.quote = quote;
        this.ticker = ticker;
    }

    public Double getQuote() {
        return quote;
    }

    public String getTicker() {
        return ticker;
    }

}
