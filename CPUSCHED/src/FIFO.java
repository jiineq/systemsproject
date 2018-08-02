import java.util.LinkedList;
/**
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
        int wait = 0;
        int turnaround = 0;
        int arr = arrMin(jobs);

        for (int i = 0; i < jobs.size(); i++) {
            Process p = new Process(jobs.get(i).getArrivalTime(), jobs.get(i).getBurstLength(), jobs.get(i).getPriority());
            arr += p.getBurstLength();
            wait += (arr - p.getArrivalTime() - p.getBurstLength());
            turnaround += (arr - p.getArrivalTime());
        }


        //TODO: 
        //System.out.println("Total elapsed time (for the scheduler):");
        //System.out.println("Throughput: " + (double)jobs.size()/totaltime*60);
        //System.out.println("CPU utilization: " );


        String outp = "Statistics for the Run\n" + "Number of processes: " + jobs.size() + "\nTotal elapsed time (for the scheduler):\n" + "Throughput: \n" + "CPU utilization: " + "\nAverage waiting time: " + (double)wait/jobs.size() + "\nAverage turnaround time: " + (double)turnaround/jobs.size() + "\nAverage response time: "+ (double)wait/jobs.size();//+ //(double)wait/jobs.size();
        return outp;

    }


}