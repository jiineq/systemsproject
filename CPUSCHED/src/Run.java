/**
 * Runs all the schedulers at user discretion and prints out statistics for the run
 *
 * command line format should be:
 *
 * java run -alg [FIFO||SJF||PR||RR]-quantum [integer] -inputFile [file.txt]
 * @author  Joy Zhang
 */

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Run {

    public static void main (String[] args) throws InterruptedException, IOException {

        Map<String, String> cliargs = new HashMap<>();
        List<Process> log = new ArrayList<>();
        String str = "";
        File f;
        Scanner scan;

        for (String s:args) {
            if(s.charAt(0) == '-') {
                str = s;
            }
            else {
                if (str.equals("")) {
                        throw new RuntimeException("Invalid arguments");
                }
                cliargs.put(str, s); //str key, s value
                str = "";
                }
            }


        try {
            f = new File(cliargs.get("-inputFile"));
            scan = new Scanner(f);
            String alg = cliargs.get("-alg");
            int quantum = 0;

            if (!(alg.equalsIgnoreCase("FIFO") || alg.equalsIgnoreCase("SJF") || alg.equalsIgnoreCase("PR") || (alg.equalsIgnoreCase("RR")))){
                System.out.println("Argument invalid");
            }
            if (alg.equalsIgnoreCase("RR")) {
                String quantumString = cliargs.getOrDefault("-quantum", "");
                if (quantumString.equals("")) {
                    throw new RuntimeException("Quantum is required");
                }
                quantum = Integer.parseInt(quantumString);
            }

        }

        //TODO: MORE STUFF HERE

        catch(FileNotFoundException e) {
            System.out.println("File" + cliargs.get("-input") + "not found.");
        }




        String fileout = cliargs.get("-input") + "Output.txt";
        PrintWriter writer = new PrintWriter(fileout, "UTF-8");
        writer.write("Statistics for the Run");
        writer.write("Total elapsed time (for the scheduler): ");
        writer.write("Throughput: ");
        writer.write("Average waiting time: ");
        writer.write("Average turnaround time: ");
        writer.write("Average response time: ");
        writer.close();


    }

    /**
     * Calculates the statistics and prints for output file
     * @param
     */
    private static void calculateStatistics(List<Process> log) throws IOException {

        //TODO: CALCULATE STATS
        double startT = log.get(0).arrT.get(0);
        double[] arrT;


        for (Process p: log) {

            System.out.println("Statistics for the Run");
            System.out.println("Total elapsed time (for the scheduler):") ;
            System.out.println("Throughput: ");
            System.out.println("CPU utilization: ");
            System.out.println("Average waiting time: ");
            System.out.println("Average turnaround time: ");
            System.out.println("Average response time: ");

        }





    }

}
