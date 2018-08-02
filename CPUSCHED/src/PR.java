import java.util.ArrayList;
/**
 * Round robin scheduler	
 * preemptive	
 */
public class PR {

    private LinkedList<Process> jobs;

    public PR(LinkedList<Process> joblist) {
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

    public void calcPR() {
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