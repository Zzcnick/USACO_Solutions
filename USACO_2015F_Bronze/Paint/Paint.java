// Zicheng Zhen
// Documentation Used: BufferedReader (java 7), File (java 7), Scanner (java 7)
//                     Printwriter (java 7)

import java.io.*;
import java.util.*;

public class Paint {
    public static void main(String[] args) {
	File file = new File("paint.in");
	try {
	    Scanner sc = new Scanner(file);
	    int a = sc.nextInt(); // Farmer Left Bound
	    int b = sc.nextInt(); // Farmer Right Bound
	    int c = sc.nextInt(); // Bessie Left Bound
	    int d = sc.nextInt(); // Bessie Right Bound
	    int total = 0; // Total length
	    if ((c < a && d < a) || (c > b && d > b)) {
		total = (b - a) + (d - c); // Including overlap
	    } else if (c > a && d < b) { // Completely overlapped
		total = b - a;
	    } else if (c < a && d > b) {
		total = d - c;
	    } else if (c > a) {
		total = d - a;
	    } else {
		total = b - c;
	    }
			
	    System.out.println(total);
	    PrintWriter printer = new PrintWriter(new File("paint.out"));
	    printer.print(total);
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
    }
}
