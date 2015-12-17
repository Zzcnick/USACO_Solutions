// Zicheng Zhen
// Documentation Used: File (java 7), Scanner (java 7), Printwriter (java 7)
//                     Collections (java 7), HashSet (java 7)
// Resources Used: http://stackoverflow.com/questions/23868622/which-is-more-efficient-sorting-and-then-binary-search-over-a-collection-or-lin
// Used in order to improve efficiency of algorithm (replace ArrayList with a HashSet for .contains, improvement from O(n) to O(1) time


import java.io.*;
import java.util.*;

public class Cards {
    public static void main(String[] args) {
	File file = new File("highcard.in");
	try {
	    Scanner sc = new Scanner(file);
	    int len = sc.nextInt(); // Amount of cards in Elsie's hand
	    Set<Integer> elsie = new HashSet<Integer>();
	    for (int i = 0; i < len; i++) {
		elsie.add(sc.nextInt()); // Populate Elsie's Cards
	    }
	    
	    int wins = 0;
	    int elsieWins = 0;
	    for (int i = 1; i < (1 + len*2); i++) { // Go through each card.
		if (elsie.contains(i)) {
		    elsieWins++;
		} else if (elsieWins != 0) {
		    elsieWins--;
		    wins++;
		}
	    }
	    //System.out.println("Wins:\t" + wins);
	    PrintWriter printer = new PrintWriter(new File("highcard.out"));
	    printer.print(wins);
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
    }

    // Print array - debugging
    public static String makeString(int[] a) {
	String ret = "[";
	for (int i : a) {
	    ret += i + ",";
	}
	if (ret.equals("")) {return "[]";}
	return ret.substring(0,ret.length()-1) + "]";
    }
}
