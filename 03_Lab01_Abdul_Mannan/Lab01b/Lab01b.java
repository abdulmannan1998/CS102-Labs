/**
 * This program creates an object of the IntBag class that can store a maximum number of prime numbers.
 * These prime numbers are computed by dividiing one number by all the previous prime numbers.
 * @author Abdul Mannan
 * @version 1.0, 20 Februrary 2019
 */
public class Lab01b {
  public static void main(String[] args) {
    
    //constants
    final int NUMBER_OF_PRIMES = 10;
    
    //variables
    IntBag primeNos = new IntBag(NUMBER_OF_PRIMES);
    int numberToCheck = 3;
    boolean full = false;
    int numberOfPrimes = 1;
    
    //program code
    primeNos.add(2); //first prime number
    
    while (!full) { //to run loop until collection is full
      
      if (primeNos.size() == NUMBER_OF_PRIMES) {
        full = true;
        
      }
      else {
        boolean Prime;
        Prime = true;
        int i = 0;
        while (i < primeNos.size() && Prime) { //dividing the number by previous primes
          if (numberToCheck % primeNos.get(i) == 0) { 
            Prime = false;
          }
          i++;
        }
        if (Prime){ //checking if the number was divided by any prime or not
          primeNos.add(numberToCheck);
          numberOfPrimes += 1;
        }
        
        numberToCheck += 1;
      }
    }
    System.out.println(primeNos);
    System.out.println(numberOfPrimes);
  } 
  
}
