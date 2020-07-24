package com.wipro.eb.service;

import com.wipro.eb.entity.Domestic;
import com.wipro.eb.entity.Commercial;

import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
		if(currentReading>previousReading && currentReading>0 && previousReading>0 && (type.equals("Domestic") || type.equals("Commercial")))
		{
			return true;
	
		}
		else if(currentReading<previousReading || currentReading<0)
		{
			throw new InvalidReadingException();
		}
		else if(type!="Domestic" || type!="Commercial")
		{
			throw new InvalidConnectionException();
		}
		else
		{
			return false;
		}
		
	}
	
	public float calculateBillAmt(int currentReading, int previousReading, String type) 
	{
		boolean result;
		float output=0;
		try {
			 result = validate(currentReading,previousReading,type);
			
			if(result)
			{
				if(type.equals("Domestic")) {
					
					float[] slabs = {(float) 2.3,(float) 4.2,(float) 5.5};
					Domestic d = new Domestic(currentReading,previousReading,slabs);
					 output = d.computeBill();
					
				}
				else
				{
					System.out.println("commericals");
					float[] slabs = {(float) 5.2,(float) 6.8,(float) 8.3};
				   Commercial c = new Commercial(currentReading,previousReading,slabs);
					 output = c.computeBill();
					
				}
				
			}
			
		}
		catch(InvalidReadingException e)
		{
			
			return -1;
		}
		catch(InvalidConnectionException e)
		{
			
			return -2;
		}
		return output;
	}
	
	public String generateBill(int currentReading, int previousReading, String type)
	{
		float Value = calculateBillAmt(currentReading,previousReading,type);
		
		if(Value==-1)
		{
			return "Incorrect Reading";
		}
		else if(Value==-2)
		{
			return "Invalid Connection Type";
		}
		else
		{
			String Amount = "Amount to be paid is "+Value;
			return Amount;
		}
		
	}
	
}



