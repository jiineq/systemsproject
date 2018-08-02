import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.HashMap;

public class Run {


    public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException {

        String teststring = "this is a test string to check if things are working";

        Map<String, String> map = new HashMap<>();
        LinkedList<Process> jobs = new LinkedList<Process>();
        String key = "";

		/*
		 * collects from CLI for hashmap
		 */
        for (String value:args) {
            if (value.charAt(0) == '-') {
                key = value;
            }
            else {
                if (key.equals("")) {
                    throw new RuntimeException("Invalid arguments");
                }
                map.put(key, value); //hashmap
                key = "";
            }
        }

        File f;
        Scanner scan;
        String algorithm = "";

        try {
            f = new File(map.get("-input"));
            scan = new Scanner(f);
            algorithm = map.get("-alg");
            int quantum;

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
                    int index = Integer.parseInt(scannedLine.next());
                    int arrival = Integer.parseInt(scannedLine.next());
                    int burst = Integer.parseInt(scannedLine.next());
                    int priority = Integer.parseInt(scannedLine.next());
                    Process p = new Process(index, arrival, burst, priority);
                    jobs.add(p);					}

            }
            scan.close();

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("this doesn't work");
        }

        String results = "";

        if (algorithm.equalsIgnoreCase("FIFO")) {
            FIFO fifo = new FIFO(jobs);
            results = fifo.calcFIFO();
        }

        //TODO
        else if (algorithm.equalsIgnoreCase("SJF")) {
            // SJF sjf = new SJF(jobs);
            // results = sjf.calcSJF();

        }

        else if (algorithm.equalsIgnoreCase("PR")) {
            // PR pr = new PR(jobs);
            // results = pr.calcPR();
        }

        else if (algorithm.equalsIgnoreCase("RR")) {
            // RR rr = new RR(jobs, quantum);
            // results = rr.calcRR();
        }

		/*
		 *  saves results in a .txt
		 */
        String fileout = map.get("-input") + "Output.txt";
        PrintWriter writer = new PrintWriter(fileout, "UTF-8");
        writer.write(results);
        writer.flush();
        writer.close();

        System.out.println(results);


    }

}