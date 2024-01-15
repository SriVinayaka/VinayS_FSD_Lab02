/**
 * 
 */
package denominations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * By Vinay S
 * Student of FSD GL & IIT Roorkee November 2023 Batch
 */
public class DenominationsCalculator {
	
	Integer[] denominations;
	Integer denominationSize;
	Integer paymentAmount;
	Scanner input;
	
	
	public DenominationsCalculator()
	{
		input = new Scanner(System.in);
		
	}
	
	
	void checkDenominations()
	{
		int index = 0;
		int tempValue = 0;
		
		for (; index < denominationSize; index++)
		{
			tempValue = denominations[index];
			if(tempValue <= 0)
			{
				System.out.printf("Invalid Value entered at %d\n", index + 1);
				System.out.println("Please re-enter the Values:");
				index = 0;
				readDenominations();
			}
		}
	}

	
	void readDenominations()
	{
		int index = 0;
		Integer tempValue = 0;
		System.out.printf("Enter the Currency %d Denomination Values:\n", denominationSize);
		for(; index < denominationSize; index++)
		{
			denominations[index] = input.nextInt();
		}
		
		checkDenominations();
	}
	
	
	void collectDenominations()
	{
		//System.out.println("Denominations:");
		System.out.println("Enter the Size of Currency Denominations:");
		denominationSize = input.nextInt();
		Integer tempValue = 0;
		int holdCounter = 0;
		int index = 0;
		
		if(denominationSize <= 0)
		{
			System.out.println("Please Enter Denomination Size Greater than Zero (0)");
			collectDenominations();
		}
		
		denominations = new Integer[denominationSize];
		
		//System.out.printf("Enter the Currency Denomination Values:\n");
		
		/*
		for(; index < denominationSize; index++)
		{
			//System.out.printf("Denomination Value: %d / %d", (index + 1), denominationSize);
			//System.out.println();
			tempValue = input.nextInt();

			if(tempValue <= 0)
			{
				holdCounter = index;
				System.out.printf("Invalid Value entered at %d\n", holdCounter + 1);
				System.out.println("Please re-enter the Values:");
				index = 0;
				Integer[] myNewDenominations = new Integer[denominationSize];
				denominations = myNewDenominations;
				continue;
			}
			denominations[index] = tempValue;
		}
		*/
		
		readDenominations();
		
		Arrays.sort(denominations, Collections.reverseOrder());
		
		//System.out.println("Denominations after Sorting from Highest to lowest");
		//System.out.println(Arrays.toString(denominations));
	}
	
	void collectPaymentAmount()
	{
		System.out.println("Enter the Amount you want to pay:");
		paymentAmount = input.nextInt();
		
		if(paymentAmount <= 0)
		{
			System.out.println("Please Enter a Positive Amount greater than zero (0)");
			collectPaymentAmount();
		}
	}
	
	
	
	void distinctPaymentDenominations()
	{
		Arrays.stream(denominations).distinct().toArray();
		
		denominationSize = denominations.length;
	}
	
	
	void calculatePayments()
	{
		int denominationIndex = 0;
		Integer tPaymentAmount = paymentAmount;
		boolean exactDenominationSupplied = false;
		Integer balanceAmount = 0;
		Integer denomination = 0;
		
		Integer noOfTimeDenominations = 0;
				
		while(denominationIndex < denominationSize)
		{
			denomination = denominations[denominationIndex];
			
			noOfTimeDenominations = tPaymentAmount / denomination;
			
			balanceAmount = tPaymentAmount % denomination;
			
			if(noOfTimeDenominations != 0)
			{
				System.out.printf("Denomination: %d No.of times: %d\n", denomination, noOfTimeDenominations);
			}
			
			
			if(balanceAmount == 0)
			{
				exactDenominationSupplied = true;
				break;
			}
			
			tPaymentAmount = balanceAmount;
			
			
			denominationIndex++;
			
		}
		
		if(exactDenominationSupplied)
		{
			System.out.println("Able to provide exact denominations");
		}
		else
		{
			System.out.println("Unble to provide exact denominations");
			System.out.printf("Remaining Balance Amount is: %d\n", balanceAmount);
		}
	}
	
	public void paymentApproach()
	{
		collectDenominations();
		collectPaymentAmount();
		distinctPaymentDenominations();
		calculatePayments();
	}
}
