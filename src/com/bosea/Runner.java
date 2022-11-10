package com.bosea;

import com.bosea.concurrent.Printer;
import com.bosea.enums.PrinterType;
import com.bosea.state.PrinterState;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrinterState sharedState = new PrinterState(PrinterType.EVEN);
		
		Printer evenPrinter = new Printer(0, PrinterType.EVEN, PrinterType.ODD, 10, 2, sharedState);
		Printer oddPrinter = new Printer(1, PrinterType.ODD, PrinterType.EVEN, 10, 2, sharedState);
		
		Thread evenThread = new Thread(evenPrinter);
		Thread oddThread = new Thread(oddPrinter);
		
		evenThread.start();
		oddThread.start();
	}

}
