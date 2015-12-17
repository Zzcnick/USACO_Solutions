// Zicheng Zhen
// Documentation Used: File (java 7), Scanner (java 7), Printwriter (java 7)

import java.io.*;
import java.util.*;

public class Lights {
    public static void main(String[] args) {
	File file = new File("lightson.in");
	try {
	    Scanner sc = new Scanner(file);
	    int dimensions = sc.nextInt();
	    int _switches = sc.nextInt();
	    Set<String> grid = new HashSet<String>(); // List of lights on
	    grid.add("1,1");
	    List<Integer> switches = new ArrayList<Integer>();
	    for (int i = 0; i < _switches*4; i++) {
		switches.add(sc.nextInt());
	    }
	    int check = 0; // Index of switches
	    int size = switches.size();
	    while (check < size) {
		// System.out.println(switches);
		if (grid.contains(switches.get(check) + "," + switches.get(check+1))) {
		    grid.add(switches.get(check+2) + "," + switches.get(check+3));
		    switches.remove(check);
		    switches.remove(check);
		    switches.remove(check);
		    switches.remove(check);
		    check = 0; // Reset the check
		    size -= 4;
		} else {
		    check += 4;
		}
	    }
	    
	    PrintWriter printer = new PrintWriter(new File("lightson.out"));
	    printer.print(grid.size());
	    printer.close();
	    System.out.println(grid.size());
	} catch (Exception ex) {
	    ;
	}
    }
}
