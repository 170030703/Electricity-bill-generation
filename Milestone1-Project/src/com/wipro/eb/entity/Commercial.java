package com.wipro.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading,float slabs[])
	{
		super( currentReading,  previousReading,slabs);
	}
	@Override
	public float computeBill() {
		int diff = currentReading-previousReading;
		float firstFifty = slabs[0];
		
		float secoundFifty = slabs[1];
		float BillAmount;
		float ElectricityDuty=0;
		float FinalAmount;
		
		if(diff>100)
		{
			int remaining = diff-100;
			
			BillAmount = firstFifty*50+secoundFifty*50+remaining*slabs[2];
			
			if(BillAmount>=10000)
			{
				ElectricityDuty=BillAmount* (float)0.09;
			}
			else if(BillAmount>=5000)
			{
				ElectricityDuty=BillAmount* (float)0.06;
			}
			else if(BillAmount<5000)
			{
				ElectricityDuty=BillAmount* (float)0.02;
			}
			FinalAmount = BillAmount+ElectricityDuty;
			return FinalAmount;
			
		}
		else if(diff>50 && diff<=100)
		{
			diff = diff-50;
			BillAmount = firstFifty*50+secoundFifty*diff;
			if(BillAmount>=10000)
			{
				ElectricityDuty=BillAmount* (float)0.09;
			}
			else if(BillAmount>=5000)
			{
				ElectricityDuty=BillAmount* (float)0.06;
			}
			else if(BillAmount<5000)
			{
				ElectricityDuty=BillAmount* (float)0.02;
			}
			FinalAmount = BillAmount+ElectricityDuty;
			return FinalAmount;
		}
		else
		{
			BillAmount = firstFifty*diff;
			if(BillAmount>=10000)
			{
				ElectricityDuty=BillAmount* (float)0.09;
			}
			else if(BillAmount>=5000)
			{
				ElectricityDuty=BillAmount* (float)0.06;
			}
			else if(BillAmount<5000)
			{
				ElectricityDuty=BillAmount* (float)0.02;
			}
			FinalAmount = BillAmount+ElectricityDuty;
			return FinalAmount;
		}
		
	}
	
	
	

}
