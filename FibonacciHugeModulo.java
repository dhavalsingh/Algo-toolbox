

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FibonacciHugeModulo {

    
    private static long getFibonacciHuge(long n, long m) {
        // store moduloes only in one pisano period, but size is unknown
        List<Integer> modulos = new ArrayList<>();
        modulos.add(0);
        modulos.add(1);
        int i = 0;
        // must check both current and next modular
        while(! (i > 0 && modulos.get(i) == 0 && modulos.get(i + 1) == 1)) {
            modulos.add((int) ((
                    modulos.get(  i  ) % m +
                    modulos.get(i + 1) % m ) % m));
            i++;
        }
        // i is currently pisano period; loop to Fn % i again?
        // Time-Space tradeoff: store each value in the period.
        //System.out.println("pisano period=" + i);
        return modulos.get((int) (n % i));
    }

    public static long getFibonacciHuge_BZ(long n, long m) {
        /* Generate each Fibonacci # from Fi + F[i+1]? */
        long fi = 0, fj = 1;  // def fi as current Fib #, fj as next
        long i = 0, tmp = 0;
        while(! (i > 0 && fi % m == 0 && fj % m == 1)) {
            tmp = fi + fj;
            fi = fj;
            fj = tmp;
            i++;
        }
        //System.out.println("pisano period=" + i + " fi=" + fi);
        // take i as the pisano period, compute Fn % i % m
        return (n % i) % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long start = System.currentTimeMillis(); 
        System.out.println(getFibonacciHuge(n, m));
        long end = System.currentTimeMillis();
        //System.out.println("Timing: " + (end - start));
        scanner.close();
    }
}
