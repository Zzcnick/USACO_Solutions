// Zicheng Zhen
// Documentation Used: File (java 7), Scanner (java 7), Printwriter (java 7)
//                     Arrays (java 7)

import java.io.*;
import java.util.*;

public class Breeds2 {
    public static void main(String[] args) {
	File file = new File("bcount.in");
	try {
	    Scanner sc = new Scanner(file);
	    int len = sc.nextInt(); // Number in line
	    int q = sc.nextInt(); // Number of queries
	    int[] cows = new int[len];
	    for (int i = 0; i < len; i++) {
		cows[i] = sc.nextInt() - 1; // Cow list
	    }
	    int[][] counts = new int[len+1][3]; // Cows - Recursive
	    for (int i = 1; i < len+1; i++) {
		counts[i] = Arrays.copyOf(counts[i-1],3);
		counts[i][cows[i-1]] += 1;
	    }
	    /*
	    for (int i = 0; i < counts.length; i++) {
		System.out.println(makeString(counts[i]));
	    }
	    */
	    
	    PrintWriter printer = new PrintWriter("bcount.out");
	    for (int i = 0; i < q*2; i = i + 2) {
		int start = sc.nextInt() - 1;
		int end = sc.nextInt();
		printer.println((counts[end][0] - counts[start][0]) + " " +
				(counts[end][1] - counts[start][1]) + " " +
				(counts[end][2] - counts[start][2]));
	    }
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
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
