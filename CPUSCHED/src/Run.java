import java.io.*;
import java.util.Scanner;
import java.util.*;

public class thisisgay {


	public static void main(String[] args) {

		File f = new File("input.txt");
		//for testing 
		List<Integer> records = new ArrayList<Integer>();
		List<Process> jobs = new ArrayList<Process>();
		int index = 0; 
		int arrival; 
		int burst; 
		int priority;


		try {
			Scanner scan = new Scanner(f);
			while (scan.hasNextLine()) {
					String line = scan.nextLine();
					//System.out.println(line);
					Scanner scannedLine = new Scanner(line);
					if (scannedLine.hasNextInt()) {
						index = Integer.parseInt(scannedLine.next());
						arrival = Integer.parseInt(scannedLine.next());
						burst = Integer.parseInt(scannedLine.next());
						priority = Integer.parseInt(scannedLine.next());
						//records.add(burst);
						Process p = new Process(index, arrival, burst, priority);
						jobs.add(p);

					}
				
			}
			scan.close();

		}


		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.print("this doesn't work");
		}
		System.out.println(jobs);
		//System.out.println(jobs.get(2).getProcessID());
		//testing 
		//System.out.println(records);

	}

}
