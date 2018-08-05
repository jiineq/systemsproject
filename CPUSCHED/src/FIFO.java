import java.util.LinkedList;
import java.util.*;
/**
 *
 * FIFO/FCFS scheduler    
 * Non preemptive   
 */
public class FIFO  {

    private LinkedList<Process> jobs;

    public FIFO(LinkedList<Process> joblist) {
        this.jobs = joblist;
    }

    public int arrMin(LinkedList<Process> p) {
        int min = p.get(0).getArrivalTime();
        for (Process proc : p) {
            if (proc.getArrivalTime() < min) {
                min = proc.getArrivalTime();
            }
        }
        return min;
    }

    public String calcFIFO() {
    	long millisStart = Calendar.getInstance().getTimeInMillis();
        int wait = 0;
        int turnaround = 0;
        int arr = arrMin(jobs);
        
        //CPU UTILIZATION: TOTAL BURST - (# CONTEXT SWITCHES * 0.1) / TOTAL BURST
        //THIS REFLECTS HOW MANY CYCLES WERE SPENT WORKING AND HOW MANY SWITCHING (switch is worth 10% of a regular burst cycle)

        for (int i = 0; i < jobs.size(); i++) {
            Process p = new Process(jobs.get(i).getArrivalTime(), jobs.get(i).getBurstLength(), jobs.get(i).getPriority());
            arr += p.getBurstLength();
            wait += (arr - p.getArrivalTime() - p.getBurstLength());
            turnaround += (arr - p.getArrivalTime());
        }
        long millisEnd = Calendar.getInstance().getTimeInMillis();
        long time = millisEnd - millisStart;
        double cpuUtil = (arr - (jobs.size() * 0.1))/arr;
        //TODO: 
        //System.out.println("Total elapsed time (for the scheduler):");
        //System.out.println("Throughput: " + (double)jobs.size()/totaltime*60);
        //System.out.println("CPU utilization: " );


        return "Statistics for the Run\n" + "Number of processes: " + jobs.size() + "\nTotal elapsed time (for the scheduler): "+time+"\n" + "Throughput: "+jobs.size()/time+"\n" + "CPU utilization: "+cpuUtil+ "\nAverage waiting time: " + (double)wait/jobs.size() + "\nAverage turnaround time: " + (double)turnaround/jobs.size() + "\nAverage response time: "+ (double)wait/jobs.size();//+ //(double)wait/jobs.size();

    }


}