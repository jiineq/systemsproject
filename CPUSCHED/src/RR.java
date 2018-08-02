import java.util.LinkedList;
/**
 * Round robin scheduler	
 * Non preemptive	
 */
public class RR {
    /*	
    List to store the queue of processes	
     */
    private LinkedList<Process> readyQ;
    /*
    List of incoming processes 
     */
    private LinkedList<Process> jobs;
    private LinkedList<Process> completed;
    private int quantum;
    private int contextSwitch;
    private int timer;
    private int count;
    private Process proc;

    public RR(LinkedList<Process> jobslist, int q) {
        this.quantum = q;
        this.jobs = jobslist;
        timer = 0;
        contextSwitch = 0;
        readyQ = new LinkedList<>();
        completed = new LinkedList<>();
        proc = null;
    }

    public void calcRR() {

        while(!readyQ.isEmpty() || !jobs.isEmpty() || proc != null) {

            for (int i = 0; i < jobs.size(); i++) {
                if (jobs.get(i).getArrivalTime()==timer) {
                    readyQ.add(jobs.remove(i));
                }
            }

            if (proc == null) {
                proc = readyQ.remove(0);
            }

            count++;
            proc.timeElapsed++;

            if (proc.burstLength == proc.timeElapsed) {
                proc.completion = timer;
                completed.add(proc);
                proc = null;
                contextSwitch++;
                count = 0;
            }

            else if (count == quantum) {
                readyQ.add(proc);
                proc = null;
                contextSwitch++;
                count = 0;
            }
            timer++;

        }

        double turnaroundTotal = 0.0;
        double waitTotal = 0.0;
        double util = 0.0;

        for (int i = 0; i < completed.size(); i++) {
            turnaroundTotal += completed.get(i).completion - completed.get(i).getArrivalTime();
            waitTotal += (completed.get(i).completion - completed.get(i).getArrivalTime()) - completed.get(i).burstLength;
            util += completed.get(i).burstLength;
        }

        double avgTurnaround = turnaroundTotal/completed.size();
        double avgWait = waitTotal/completed.size();
        double cpuUtil = (util - (contextSwitch*0.01))/timer;
        double throughput = (double)completed.size()/timer;

        System.out.println(avgTurnaround);
        System.out.println(avgWait);


    }



}