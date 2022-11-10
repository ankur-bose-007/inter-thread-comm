package com.bosea.concurrent;

import com.bosea.enums.PrinterType;
import com.bosea.state.PrinterState;

public class Printer implements Runnable {
	private int currentValue;
	private PrinterType currentType;
	private PrinterType nextType;
	private int maxValue;
	private int incrementValue;
	private PrinterState state;
	
	public Printer(int currentValue, PrinterType currentType, PrinterType nextType,
			int maxValue, int incrementValue, PrinterState state){
		this.currentValue = currentValue;
		this.currentType = currentType;
		this.nextType = nextType;
		this.maxValue = maxValue;
		this.incrementValue = incrementValue;
		this.state = state;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(currentValue <= maxValue) {
			synchronized(state) {
				while(currentType != state.getPrinterType()) {
					try {
						state.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(currentType+ " : "+currentValue);
				state.setPrinterType(nextType);
				currentValue+=incrementValue;
				state.notifyAll();
			}
		}
	}

}
