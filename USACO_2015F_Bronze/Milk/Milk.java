// Zicheng Zhen
// Documentation Used: BufferedReader (java 7), File (java 7), Scanner (java 7)
//                     Printwriter (java 7), Collections (java 7)

import java.io.*;
import java.util.*;

public class Milk {
    // debugging
    public static String makeString(int[] a) {
	String ret = "[";
	for (int i : a) {
	    ret += i + ",";
	}
	if (ret.equals("")) {return "[]";}
	return ret.substring(0,ret.length()-1) + "]";
    }
    public static void printList(List<int[]> al) {
	for (int i = 0; i < al.size(); i++) {
	    System.out.println(makeString(al.get(i)));
	}
    }
    
    public static void main(String[] args) {
	File file = new File("badmilk.in");
	try {
	    Scanner sc = new Scanner(file);
	    int _people = sc.nextInt();
	    int _milkTypes = sc.nextInt();
	    int _drinks = sc.nextInt();
	    int _sick = sc.nextInt();
	    List<int[]> goodMilk = new ArrayList<int[]>(); // Definitely Good
	    List<int[]> badMilk  = new ArrayList<int[]>(); // Possible Bad
	    List<int[]> cases = new ArrayList<int[]>(); // Each cow's drink
	    List<int[]> sick  = new ArrayList<int[]>(); // Sick cows and times
	    for (int i = 0; i < _drinks; i++) {
		int[] _case = new int[3]; // [cow#, milk, time]
		_case[0] = sc.nextInt();
		_case[1] = sc.nextInt();
		_case[2] = sc.nextInt();
		cases.add(_case);
	    }
	    for (int i = 0; i < _sick; i++) {
		int[] sickCow = new int[2]; // [cow#, time]
		sickCow[0] = sc.nextInt();
		sickCow[1] = sc.nextInt();
		sick.add(sickCow);
	    }
	    
	    // Step 1: Isolate possible bad milks
	    for (int i = 0; i < sick.size(); i++) {
		int cow = sick.get(i)[0];
		int time = sick.get(i)[1];
		for (int j = cases.size()-1; j > -1; j--) {
		    if (cases.get(j)[2] < time && cases.get(j)[0] == cow) {
			badMilk.add(cases.remove(j));
		    }
		}
	    }
	    List<Integer> maybeBad = new ArrayList<Integer>();
	    for (int i = 0; i < badMilk.size(); i++) {
		int milk = badMilk.get(i)[1];
		if (!(maybeBad.contains(milk))) {
		    maybeBad.add(milk);
		}
	    }
	    // Step 1.5: Remove non-bad maybeBad milks
	    for (int i = maybeBad.size()-1; i > -1; i--) {
		int testBad = maybeBad.get(i);
		List<Integer> maybeSick = new ArrayList<Integer>();
		for (int j = 0; j < badMilk.size(); j++) {
		    // Test 1 milk at a time:
		    // If milk is the same as the one being tested
		    // Add the person to the maybeSick list if no duplicates
		    int milk = badMilk.get(j)[1];
		    int cow = badMilk.get(j)[0];
		    if (testBad == milk && 
			!(maybeSick.contains(cow))) { // Person
			maybeSick.add(badMilk.get(j)[0]);
		    }
		} // Finished adding maybeSick cows
		if (maybeSick.size() < _sick) { // All sick cows must've drank
		    maybeBad.remove(i); // If they didn't drink, milk is fine
		}
	    }
	    // Step 2: Isolate good milks
	    List<Integer> Good = new ArrayList<Integer>();
	    for (int i = 1; i <= _milkTypes; i++) {
		if (!(maybeBad.contains(i))) { // MaybeBad doesn't contain milk
		    Good.add(i); // So it must be good
		}
	    }
	    for (int i = cases.size()-1; i > -1; i--) {
		if (Good.contains(cases.get(i)[1])) {
		    goodMilk.add(cases.remove(i));
		}
	    }

	    // Step 2.5: Remove remaining cases to badMilk
	    for (int i = cases.size()-1; i > -1; i--) {
		badMilk.add(cases.remove(i));
	    }

	    // Step 3: Count maximum number of cases for each milk
	    int max = 0;
	    for (int i = 0; i < maybeBad.size(); i++) {
		int testBadMilk = maybeBad.get(i);
		List<Integer> cows = new ArrayList<Integer>(); // Which cows
		for (int j = 0; j < badMilk.size(); j++) {
		    int testCow = badMilk.get(j)[0];
		    int testCowMilk = badMilk.get(j)[1];
		    if (!(cows.contains(testCow)) &&
			testCowMilk == testBadMilk) {
			cows.add(testCow);
		    }
		}
		if (cows.size() > max) {
		    max = cows.size();
		}
	    }
	    /*
	    System.out.println("Sick: ");
	    printList(sick);
	    System.out.println("All Cases: ");
	    printList(cases);
	    System.out.println("badMilk Cases: ");
	    printList(badMilk);
	    System.out.println("goodMilk Cases: ");
	    printList(goodMilk);

	    System.out.print("\nMaybe Bad: ");
	    System.out.print(maybeBad.toString());
	    System.out.print("\nGood: ");
	    System.out.print(Good.toString() + "\n");
	    */
	    System.out.println(max);
	    
	    PrintWriter printer = new PrintWriter(new File("badmilk.out"));
	    printer.print(max);
	    printer.close();
	} catch (Exception ex) {
	    ;
	}
    }
}
