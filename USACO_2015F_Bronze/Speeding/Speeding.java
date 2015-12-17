// Zicheng Zhen
// Documentation Used: BufferedReader (java 7), File (java 7), Scanner (java 7)
//                     Printwriter (java 7)

import java.io.*;
import java.util.*;

public class Speeding {
    public static void main(String[] args) {
	File file = new File("speeding.in");
	try {
	    Scanner sc = new Scanner(file);
	    List<Integer> speedLimits = new ArrayList<Integer>();
	    List<Integer> speed = new ArrayList<Integer>();
	    int overLimit = 0; // Spped over the limit.
	    int _roadSegs = sc.nextInt(); // Segments of peed Limits
	    int _speedSegs = sc.nextInt(); // Setgments of Bessie's Speeds
	    for (int i = 0; i < _roadSegs; i++) { // Populate speedLimits
		int len = sc.nextInt(); // Length of road
		int limit = sc.nextInt(); // Speedlimit for the length
		for (int j = 0; j < len; j++) {
		    speedLimits.add(limit);
		}
	    }
	    for (int i = 0; i < _speedSegs; i++) { // Populate speed
		int len = sc.nextInt(); // Length of Bessie's drive
		int limit = sc.nextInt(); // Speed for the length
		for (int j = 0; j < len; j++) {
		    speed.add(limit);
		}
	    }
	    for (int i = 0; i < 100; i++) {
	        int difference = speed.get(i) - speedLimits.get(i);
		if (difference > overLimit)
		    overLimit = difference;
	    }
	    
	    System.out.println(overLimit);
	    PrintWriter printer = new PrintWriter(new File("speeding.out"));
	    printer.print(overLimit);
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
    }
}
