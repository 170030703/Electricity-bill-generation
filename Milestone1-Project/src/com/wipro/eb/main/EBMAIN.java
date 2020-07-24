package com.wipro.eb.main;

import com.wipro.eb.service.ConnectionService;

public class EBMAIN {
	public static void main(String[] args)
	{
		System.out.println(new ConnectionService().generateBill(140,120,"comm"));
	}

}
