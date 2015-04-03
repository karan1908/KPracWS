package com.ibm.core.java;

/*
A Prime number is a number which doesn't have any multiples other than 1 or a number which come in its own 
table eg 2,3,5 etc.
Logic:
2 is the only even prime number , so in below logic, I have tested all the odd numbers for prime number test.
Now to test any number if prime or not , I have tested divisibilty of number with all the prime numbers so far less than
it starting from second prime number 3.
Eg to check whether 25 is Prime or not
25%3  not equals to 0.
Test divisibilty with next prime number 5.
25%5 equals to 0 , hence 25 is not a prime number.
*/


public class PrimeNumber {
    
    static final int totalPrimeNumberCount = 1000000;
    
    public static void main(String[] args)
    {
        PrimeNumber.printFirstOneMillionPrimeNumbers();
        
    }
    
    public static void printFirstOneMillionPrimeNumbers()
    {
        int count = 1;
        int[] primeNoArray = new int[totalPrimeNumberCount];
        boolean isPrimeNo = true;
        
        //printing first two prime numbers 2 and 3 beforehand
        primeNoArray[0] = 2;
        primeNoArray[1] = 3;
        
        System.out.println("2");
        System.out.println("3");
        
        for(int i = 5;count<totalPrimeNumberCount-1;i=i+2)
        {
            isPrimeNo=true;
            for(int j=1;j<=count;++j)
            {
                if(i%primeNoArray[j] == 0)
                {
                    isPrimeNo = false;
                    break;
                }
                if(primeNoArray[j]*primeNoArray[j]>i)
                {
                    isPrimeNo = true;
                    break;
                }
               
            }//innerFor
            
            if(isPrimeNo)
            {
                primeNoArray[++count] = i;
                System.out.println(i);  //printing next prime number
                try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
            
        }//outerFor
        
    }//main
    
    
}//PrimeNumber Class

/*Thanks 
Karan*/
    
