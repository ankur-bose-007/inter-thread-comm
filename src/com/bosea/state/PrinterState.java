package com.bosea.state;

import com.bosea.enums.PrinterType;

public class PrinterState {
	private PrinterType printerType;
	
	public PrinterState(final PrinterType printerType) {
		this.printerType = printerType;
	}

	public PrinterType getPrinterType() {
		return printerType;
	}

	public void setPrinterType(PrinterType printerType) {
		this.printerType = printerType;
	}
}
