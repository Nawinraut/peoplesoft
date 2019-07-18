package com.cloud.test.Finance;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String paymentString = "Payment 109 for 1,800.00 USD has been created.";
		
		//String [] a2 = a.split(" ");
		
		//String payment =paymentString.split(" ")[1];
		
		
		
		int payment = Integer.parseInt(paymentString.split(" ")[1]);
		
		System.out.println(payment);
		
		
		

	}

}
