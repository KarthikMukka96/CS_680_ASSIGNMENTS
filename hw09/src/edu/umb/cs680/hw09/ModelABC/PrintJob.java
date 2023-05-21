package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.Printer.Command;

public class PrintJob implements Command {
    @Override
    public void execute() {
        Printer printer = Printer.getPrinter();
        printer.print();
    }
}
