package primefactors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {
    
    private final int questNumber;
    private final List<Integer> primes;
    private final List<Integer> result;

    public PrimeFactors(int number) {
        this.primes = new ArrayList<>();
        this.result = new ArrayList<>();
        this.questNumber = number;
        setPrimes(number);
    }

    public static void main(String[] args) {
        PrimeFactors pf = new PrimeFactors(input());
        //System.out.println(pf.primes);
        pf.factorize();
        pf.print();
    }

    private void setPrimes(int number) {
        for (int i = 2; i <= (int) (number / 2); i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }
    
    public static boolean isPrime(int number) {
        if (number == 2) return true;
        if (number < 2 || number % 2 == 0) return false;
        for(int i = 3; i * i <= number; i += 2) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

    private void factorize() {
        int number = questNumber;
        for (Integer prime : primes) {
            while (number % prime == 0) {
                this.result.add(prime);
                number /= prime;
            }
        }
    }

    private void print() {
        if (isPrime(questNumber)) {
            System.out.printf("Number %d is a PRIME.%n", questNumber);
        } else {
            int limit = result.size() - 1;
            System.out.printf("%d = ", questNumber);
            for (int i = 0; i < limit; i++) {
                System.out.printf("%d × ", result.get(i));
            }
            System.out.printf("%d%n", result.get(limit));
        }
    }
    
    private static int input() {
        int number = 0;
        while (number < 2) {
            System.out.print("Enter a positive whole number: ");
            try {
                String nextLine = new Scanner(System.in).nextLine();
                number = Integer.parseInt(nextLine);
            } catch(NumberFormatException e) {
                System.err.println(e);
                System.out.println("You have to enter a positive whole number!");
            }
        }
        return number;
    }
}