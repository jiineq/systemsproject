import java.util.LinkedList;
/**
 * Shortest job first (SJF) scheduler	
 * preemptive	
 */
public class SJF {
    private LinkedList<Process> jobs;

    public SJF(LinkedList<Process> joblist) {
        this.jobs = joblist
    }

    public void sortJobs(LinkedList<Process> jobs) {
        LinkedList<Process> by = jobs;


    }

    public void calcSJF() {

        int wait = 0;
        int turnaround = 0;
        int arr = arrMin(jobs);
        Process next; //the next process to compare priority 
        for (int i = 0; i < jobs.size(); i++) {
            Process current = new Process(jobs.get(i).getArrivalTime(), jobs.get(i).getBurstLength(), jobs.get(i).getPriority());

            if (i!=jobs.size) {
                next = Process(jobs.get())

            }

            arr += p.getBurstLength();
            wait += (arr - p.getArrivalTime() - p.getBurstLength());
            turnaround += (arr - p.getArrivalTime());
        }


        System.out.println("Statistics for the Run");
        //     System.out.println("Total elapsed time (for the scheduler):" + totaltime);
        //     System.out.println("Throughput: " + (double)processes/totaltime*60);
        System.out.println("CPU utilization: " );
        System.out.println("Average waiting time: " + (double)wait/jobs.size());
        System.out.println("Average turnaround time: " + (double)turnaround/jobs.size());
        System.out.println("Average response time: ");

    }



}