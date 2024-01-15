/**
 * 
 */
package paymoney.dailytarget;

import java.util.Scanner;

/**
 * By Vinay S
 * FSD GL & IIT Roorkee November 2023 Batch 
 */

public class DailyTargetDeterminator {
	
	Integer transactionsArraySize;
	Integer[] transactionArray;
	Integer dailyTarget;
	Integer dailyTargetSize;
	
	Scanner input;

	
	public DailyTargetDeterminator()
	{
		input = new Scanner(System.in);
	}


	
	void readTransactionArraySize()
	{
		System.out.println("Enter the Size of the Transactions Array: ");
		
		transactionsArraySize = input.nextInt();
		
		if(transactionsArraySize <= 0)
		{
			System.out.println("Please Enter a Valid Size of transaction Array greater the Zero (>0)");
			readTransactionArraySize();
		}
	}
	
	
	void readTransactionArrayData()
	{
		System.out.println("Enter the Values of the Array:");
		int index = 0;
		for( ; index < transactionsArraySize; index++)
		{
			
			transactionArray[index] = input.nextInt();
			
		}
		
	}
	
	void checkTransactionArrayData()
	{
		readTransactionArrayData();
		
		int index = 0;
		for( ; index < transactionsArraySize; index++)
		{
			
			if(transactionArray[index] < 0)
			{
				System.out.println("Please enter Transactions data greater than or equal to Zero (>=0)");
				checkTransactionArrayData();
			}
			
		}
		
	}
	
	void collectTransactionValues()
	{
		// Get Scanner to get input
		//System.out.println("Transactions Array: ");
		
		//System.out.println("Enter the Size of the Transactions Array: ");
		
		//transactionsArraySize = input.nextInt();
		
		readTransactionArraySize();
		
		
		transactionArray = new Integer[transactionsArraySize];
		
		
		// Get Size of the Transaction Array
		
		// Size - for the Loop
		
		// for each value - update in the transactionArray
		
		//System.out.println("Enter the Values of the Array:");
		
		/*
		for(int index = 0; index < transactionsArraySize; index++)
		{
			//System.out.printf("Transaction Value: %d / %d", (index + 1), transactionsArraySize);
			
			//System.out.println();
			
			transactionArray[index] = input.nextInt();
			
		}
		*/
		
		checkTransactionArrayData();
		
		//System.out.println("Enter the Total no of Targets that needs to be achieved:");
		//dailyTargetSize = input.nextInt();
		
		readDailyTargetSize();
	}

	
	
	void readDailyTargetSize()
	{
		System.out.println("Enter the Total no of Targets that needs to be achieved:");
		dailyTargetSize = input.nextInt();
		
		if(dailyTargetSize <= 0)
		{
			System.out.println("Please enter correct value for Total no of Targets that needs to be achieved");
			readDailyTargetSize();
		}

	}
	
	
	
	void collectDailyTarget(int myDailyTarget)
	{
		// Using Scanner to collect the input
		
		System.out.printf("Enter the Value of Target : %d\n", myDailyTarget + 1);
		dailyTarget = input.nextInt();
		if( dailyTarget <= 0)
		{
			System.out.println("Please Enter Correct Value for dailyTarget");
			collectDailyTarget(myDailyTarget);
		}
		
		
		// Update the input for the "dailyTarget"
	}

	
	void determineTransactionSum(int myDailyTarget)
	{
		int counter = 0;
		boolean flag = false;
		Integer overallSumOfTransactionValues = 0;
		
		collectDailyTarget(myDailyTarget);
		
		for(; counter < transactionsArraySize; counter++)
		{
			overallSumOfTransactionValues += transactionArray[counter];
			//System.out.println(overallSumOfTransactionValues);
			//System.out.println(dailyTarget);
			if(overallSumOfTransactionValues >= dailyTarget)
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			//System.out.println("Target has been achieved");
			//System.out.printf("Target %d i.e %d is achieved after %d transactions\n", myDailyTarget + 1, dailyTarget, counter + 1);
			System.out.printf("Target %d of Value %d has been Achieved after %d transactions\n", myDailyTarget + 1, dailyTarget, counter + 1);
			//System.out.println();
		}
		else
		{
			//System.out.println("Given Target is not achieved");
			System.out.printf("Given Target %d of Value %d is not achieved\n", myDailyTarget + 1, dailyTarget);

		}
	}
	
	public void transactionAndTargetCheck()
	{
		collectTransactionValues();
		int itr = 0;
		for(; itr < dailyTargetSize; itr++)
		{
			determineTransactionSum(itr);
			System.out.println();
		}
		
	}

}
