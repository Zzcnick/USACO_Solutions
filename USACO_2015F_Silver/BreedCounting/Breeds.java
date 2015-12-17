// Zicheng Zhen
// Documentation Used: File (java 7), Scanner (java 7), Printwriter (java 7)

import java.io.*;
import java.util.*;

public class Breeds {
    public static void main(String[] args) {
	File file = new File("bcount.in");
	try {
	    Scanner sc = new Scanner(file);
	    int len = sc.nextInt(); // Number in line
	    int q = sc.nextInt(); // Number of queries
	    int[] cows = new int[len];
	    for (int i = 0; i < len; i++) {
		cows[i] = sc.nextInt(); // Cow list
	    }
	    
	    PrintWriter printer = new PrintWriter("bcount.out");
	    for (int i = 0; i < q*2; i = i + 2) {
		int[] toPrint = count(cows,sc.nextInt(),sc.nextInt());
		printer.println(toPrint[0] + " " +
				toPrint[1] + " " +
				toPrint[2]);
	    }
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
    }
    public static int[] count(int[] cows, int start, int end) {
	int b1 = 0;
	int b2 = 0;
	int b3 = 0;
	for (int i = start - 1; i < end; i++) {
	    if (cows[i] == 1) {
		b1 += 1;
	    } else if (cows[i] == 2) {
		b2 += 1;
	    } else {
		b3 += 1;
	    }
	}
	return new int[]{b1,b2,b3};
    }

    public static String makeString(int[] a) {
	String ret = "[";
	for (int i : a) {
	    ret += i + ",";
	}
	if (ret.equals("")) {return "[]";}
	return ret.substring(0,ret.length()-1) + "]";
    }
}
