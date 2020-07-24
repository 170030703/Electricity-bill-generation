package com.wipro.eb.entity;

public class Domestic extends Connection {
	
	
	public Domestic(int currentReading, int previousReading, float[] slabs) {
		super(currentReading, previousReading, slabs);
		
	}

	@Override
	public float computeBill() {
             
		int diff = currentReading-previousReading;
		System.out.println(diff);
		float firstFifty = slabs[0];
		
		float secoundFifty = slabs[1];
		float BillAmount;
	
		
		if(diff>100)
		{
			int remaining = diff-100;
			
			BillAmount = firstFifty*50+secoundFifty*50+remaining*slabs[2];
			
			
		
			return BillAmount;
			
		}
		else if(diff>50 && diff<=100)
		{
			diff = diff-50;
			BillAmount = firstFifty*50+secoundFifty*diff;
			
			return BillAmount;
		}
		else
		{
			BillAmount = firstFifty*diff;
			
			return BillAmount;
		}
		

	}
	

}
