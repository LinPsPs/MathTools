package algorithm; /**
 * 
 * @author Haolin
 * 
 * This is a Java program to test if three points are co-circular.
 */

import java.util.Scanner;

public class Cocircular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while(!done) {
            System.out.println("Input all three points to test where they are co-circular or not:");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            double x3 = sc.nextDouble();
            double y3 = sc.nextDouble();
            foo(x1, y1, x2, y2, x3, y3);
            System.out.println("Done! Press any key to continue; q to quit.");
            if(sc.next().equals("q")) {
                done = true;
            }
        }
    }

    public static void foo (double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = x1 - x2;
        double b = y1 - y2;
        double c = x1 - x3;
        double d = y1 - y3;
        double e = ((Math.pow(x1, 2) - (Math.pow(x2, 2))) - (Math.pow(y2, 2) - (Math.pow(y1, 2)))) / 2.0;
        double f = ((Math.pow(x1, 2) - (Math.pow(x3, 2))) - (Math.pow(y3, 2) - (Math.pow(y1, 2)))) / 2.0;
        double x0 = - (d*e - b*f) / (b*c - a*d);
        double y0 = - ((a*f - c*e) / (b*c - a*d));
        double r = Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
        System.out.println("(x - "+x0+")^2 + (y - "+y0+")^2 = "+r+"^2");
    }
}