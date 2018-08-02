import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.HashMap;

public class Run {


    public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException {

        String teststring = "this is a test string to check if things are working";

        Map<String, String> map = new HashMap<>();
        LinkedList<Process> jobs = new LinkedList<Process>();
        int index;
        int arrival;
        int burst;
        int priority;
        String key = "";
        File f;
        Scanner scan;
        String algorithm = "";
        int quantum;
        String save = "";

        //collects from CLI for hashmap
        //THIS WORKS!
        for (String value : args) {
            if (value.charAt(0) == '-') {
                key = value;
                // System.out.println(teststring);

            } else {
                if (key.equals("")) {
                    throw new RuntimeException("Invalid arguments");
                }
                map.put(key, value); //hashmap
                key = "";
            }
        }

        try {
            f = new File(map.get("-input"));
            scan = new Scanner(f);
            algorithm = map.get("-alg");

            if (algorithm.equalsIgnoreCase("RR")) {
                String quantumString = map.getOrDefault("-quantum", "");
                if (quantumString.equals("")) {
                    throw new RuntimeException("Quantum is required");
                }
                quantum = Integer.parseInt(quantumString);
            }

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Scanner scannedLine = new Scanner(line);
                if (scannedLine.hasNextInt()) {
                    index = Integer.parseInt(scannedLine.next());
                    arrival = Integer.parseInt(scannedLine.next());
                    burst = Integer.parseInt(scannedLine.next());
                    priority = Integer.parseInt(scannedLine.next());
                    Process p = new Process(index, arrival, burst, priority);
                    jobs.add(p);
                }

            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("this doesn't work");
        }

        if (algorithm.equalsIgnoreCase("FIFO")) {
            FIFO fifo = new FIFO(jobs);
            save = fifo.calcFIFO();
        }

        //TODO
        else if (algorithm.equalsIgnoreCase("SJF")) {
            // SJF sjf = new SJF(jobs);
            // sjf.calcSJF();

        } else if (algorithm.equalsIgnoreCase("PR")) {
            // PR pr = new PR(jobs);
            // pr.calcPR();
        } else if (algorithm.equalsIgnoreCase("RR")) {
            // RR rr = new RR(jobs, quantum);
            // rr.calcRR();
        }

		/*
		 *  saves results in a .txt 
		 */
        String fileout = map.get("-input") + "Output.txt";
        PrintWriter writer = new PrintWriter(fileout, "UTF-8");
        writer.write(save);
        writer.flush();
        writer.close();

        System.out.println(save);

    }
}