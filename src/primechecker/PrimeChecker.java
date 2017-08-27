/*
 * In this program we utilize thread class and runnable interface to find out 
 * whether given number is prime or not .
 * Note: it is not wise to do this because Thread class itself makes 
 * use of runnable only, so we dont actually gain anything by doing this
 * so doing only as part of this assignment

 */
package primechecker;

public class PrimeChecker extends Thread implements Runnable {  // our class extends  Thread class and 
                                                                // also implments runnable interface
    int number;                                                 // a number variable to to store our evaluation number
    boolean prime;                                              // this variable will hold a boolean value

    public void setNumber(int number) {                         // setter to set value for number variable
        this.number = number;       
    }

    public void run() {                                         // overriding run method from Thread class
        isPrime();                                              // calling isPrime method
    }

    public void isPrime() {                                  // this method evaluates if given number si prime
        prime = true;                                           // set prime variable true
        for (int i = 2; i < number; i++) {                      // run a loop till number variable
            if (number % i == 0) {                              // if number modulo loop counter i is 0 
                prime = false;                                  // that means it is not prime, hence set prime to false
                break;                                          // break out of loop
            }
        }
        if (prime) {                                            // based on boolean value of prime, show relevant output
            System.out.println(number + " is a Prime number");
        } else {
            System.out.println(number + " is not a Prime number");
        }
        
    }

    public static void main(String[] args) {                    // main starts here

        PrimeChecker objPC1 = new PrimeChecker();               //// create object of PrimeChecker class
        PrimeChecker objPC2 = new PrimeChecker();               //// create object of PrimeChecker class
        
        objPC1.setNumber(11);                                   //calling number setter
        Thread t1 = new Thread(objPC1);                         // creating object of Thread class
        t1.start();                                             // calling start method of thread class

        objPC2.setNumber(9);                                   //calling number setter
        Runnable t2 = new Thread(objPC2);                       // creating object of Runnable interface t2
        t2.run();                                               // calling run method  overridden in our PrimeChecker class

    }

}
